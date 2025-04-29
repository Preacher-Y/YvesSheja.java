package RwandaPolice.main;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import RwandaPolice.violationEntry.ViolationEntry;
import RwandaPolice.fineAssessment.FineAssessment;
import RwandaPolice.finePayment.FinePayment;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<ViolationEntry> violationList = new ArrayList<>();
    private static List<FinePayment> fineList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("\n Welcome To Rwanda National Police - Traffic Fine Management System ");
        System.out.println("--------------------------------------------------------------------");
        while (true) {
            System.out.println("\n What Service Do You Desire:");
            System.out.println("\n1. Record New Violation");
            System.out.println("2. Assess Fine");
            System.out.println("3. Process Payment");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = getChoice();

            switch (choice) {
                case 1:
                    recordNewViolation();
                    break;
                case 2:
                    assessFine();
                    break;
                case 3:
                    processPayment();
                    break;
                case 4:
                    System.out.println("Exiting the system... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 4) {
                    return choice;
                }
                System.out.println("Please enter a number between 1 and 4");
                System.out.print("Enter your choice (1-4): ");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
                System.out.print("Enter your choice (1-4): ");
            }
        }
    }

    private static String getViolationType() {
        while (true) {
            System.out.print("Violation Type (SPEEDING/RED_LIGHT/NO_HELMET/DUI): ");
            String type = sc.nextLine().toUpperCase();
            if (type.equals("SPEEDING") || type.equals("RED_LIGHT") || 
                type.equals("NO_HELMET") || type.equals("DUI")) {
                return type;
            }
            System.out.println("Invalid violation type. Please enter SPEEDING, RED_LIGHT, NO_HELMET, or DUI");
        }
    }

    private static String getDriverId() {
        while (true) {
            System.out.print("Driver ID (16 digits): ");
            String id = sc.nextLine();
            if (id.matches("\\d{16}")) {
                return id;
            }
            System.out.println("Invalid Driver ID. Please enter exactly 16 digits");
        }
    }

    private static String getVehiclePlate() {
        while (true) {
            System.out.print("Vehicle Plate (format RAB123X): ");
            String plate = sc.nextLine().toUpperCase();
            if (plate.matches("RAB\\d{3}[A-Z]")) {
                return plate;
            }
            System.out.println("Invalid plate format. Please use format RAB123X where X is a letter");
        }
    }

    private static void recordNewViolation() {
        System.out.println("\nEnter Violation Details:");
        
        String driverId = getDriverId();
        
        System.out.print("Driver Name: ");
        String driverName = sc.nextLine();
        while (driverName.isEmpty()) {
            System.out.print("Driver Name cannot be empty. Please enter again: ");
            driverName = sc.nextLine();
            
        }
        
        String vehiclePlate = getVehiclePlate();
        String violationType = getViolationType();
        
        ViolationEntry violation = new ViolationEntry(driverId, driverName, vehiclePlate, violationType);
        violation.recordViolation();
        violationList.add(violation);
    }
    
    private static void assessFine() {
        System.out.println("\nEnter Details for Fine Assessment:");
        
        String driverId = getDriverId();
        String vehiclePlate = getVehiclePlate();
        
        ViolationEntry entry = null;
        for (ViolationEntry v : violationList) {
            if (v.getDriverId().equals(driverId) && v.getVehiclePlate().equals(vehiclePlate)) {
                entry = v;
                break;
            }
        }
        if (entry == null) {
            System.out.println("Error: No matching violation entry found. Please record the violation first.");
            return;
        }
        
        // Check existing payment record
        for (FinePayment p : fineList) {
            if (p.getDriverId().equals(driverId) && p.getVehiclePlate().equals(vehiclePlate)) {
                if ("PAID".equals(p.getPaymentStatus())) {
                    System.out.println("This fine has already been paid.");
                } else {
                    System.out.println("\nOutstanding Fine Details:");
                    System.out.println("Driver: " + p.getDriverName() + " (ID: " + p.getDriverId() + ")");
                    System.out.println("Vehicle Plate: " + p.getVehiclePlate());
                    System.out.println("Violation Type: " + p.getViolationType());
                    System.out.println("Remaining Fine Amount: " + String.format("%,.2f RWF", p.getFineAmount()));
                    System.out.println("Payment Status: " + p.getPaymentStatus());
                }
                return;
            }
        }
        
        FineAssessment assessment = new FineAssessment(driverId, entry.getDriverName(), vehiclePlate, entry.getViolationType());
        assessment.assessFine();
        FinePayment paymentRecord = new FinePayment(driverId, entry.getDriverName(), vehiclePlate, entry.getViolationType(), assessment.getFineAmount(), assessment.getPaymentStatus());
        fineList.add(paymentRecord);
    }
    
    private static void processPayment() {
        System.out.println("\nEnter Payment Details:");
        
        String driverId = getDriverId();
        String vehiclePlate = getVehiclePlate();
        
        FinePayment payment = null;
        for (FinePayment p : fineList) {
            if (p.getDriverId().equals(driverId) && p.getVehiclePlate().equals(vehiclePlate)) {
                payment = p;
                break;
            }
        }
        if (payment == null) {
            System.out.println("Error: No assessed fine found for given ID and vehicle plate. Please assess fine first.");
            return;
        }
        
        double paymentAmount = 0;
        while (true) {
            System.out.print("Payment Amount: ");
            try {
                paymentAmount = Double.parseDouble(sc.nextLine());
                if (paymentAmount <= 0) {
                    System.out.println("Payment amount must be greater than 0");
                } else if (paymentAmount > payment.getFineAmount()) {
                    System.out.println(String.format("Payment amount cannot exceed remaining fine amount: %,.2f RWF", payment.getFineAmount()));
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
        payment.processPayment(paymentAmount);
    }
}
