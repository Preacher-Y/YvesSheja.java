package LemigoHotel1.billing;

import java.util.Scanner;
import LemigoHotel1.hotelService.HotelService;

public class Billing extends HotelService {
    private static Scanner sc = new Scanner(System.in);
    private boolean isPaid = false;
    
    public Billing(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void generateBill() {
        if (isPaid) {
            System.out.println("\nBill already paid!");
            return;
        }
        if (roomStatus.equals("AVAILABLE")) {
            System.out.println("\nNo Bill to generate. No bills for "+guestName);
            return; 
        }
        
        
        System.out.print("\nEnter actual number of nights stayed: ");
        int actualNights = sc.nextInt();
        sc.nextLine(); 
        setStayDays(actualNights);
        
        
        int total = calculateRate(roomType) * stayDays;
        System.out.println("\n--- Billing Information ---");
        System.out.println("Guest ID: " + guestId);
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Stay Duration: " + stayDays + " nights");
        System.out.printf("Total Bill: RWF %,d%n", total);
        
        System.out.print("\nWould you like to pay now? (yes/no): ");
        String response = sc.nextLine().trim().toLowerCase();

        while (!response.equals("yes") && !response.equals("no")) {
            System.out.print("Invalid input. Please enter 'yes' or 'no': \n");
            response = sc.nextLine().trim().toLowerCase();
        }

        if (response.equals("yes")) {
            while (true) {
                System.out.print("Enter payment amount (RWF): ");
                
                if (!sc.hasNextDouble()) {
                    System.out.println("\nInvalid input. Please enter a numeric value.");
                    sc.nextLine();
                    continue;
                }

                double amount = sc.nextDouble();
                sc.nextLine();

                if (Math.abs(amount - total) <= 0.01) {
                    isPaid = true;
                    System.out.println("\nPayment processed successfully!");
                    return;
                } else {
                    System.out.printf("\nError: Payment must be exactly %,d RWF. Try again or enter 0 to cancel.%n", total);
                    if (amount == 0) return;
                }
            }
        }

    }
    
    public int calculateRate(String roomType) {
        switch (roomType.toUpperCase()) {
            case "STANDARD": return 50000;
            case "DELUXE": return 80000;
            case "SUITE": return 120000;
            default: return 0;
        }
    }

    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public void bookRoom() {}

    @Override
    public void checkoutGuest() {}
}
