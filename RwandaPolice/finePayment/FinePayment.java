package RwandaPolice.finePayment;

import RwandaPolice.trafficRecord.TrafficRecord;

public class FinePayment extends TrafficRecord {
    public FinePayment(String driverId, String driverName, String vehiclePlate, 
                      String violationType, double fineAmount, String paymentStatus) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehiclePlate = vehiclePlate;
        this.violationType = violationType;
        this.fineAmount = fineAmount;
        this.paymentStatus = paymentStatus;
    }

    @Override
    public void recordViolation() {
        // This is handled by ViolationEntry class
    }

    @Override
    public void assessFine() {
        // This is handled by FineAssessment class
    }

    @Override
    public void processPayment() {
        if ("PAID".equals(paymentStatus)) {
            System.out.println("Error: This fine has already been paid!");
            return;
        }

        // Process the payment
        paymentStatus = "PAID";
        printReceipt();
    }

    private void printReceipt() {
        System.out.println("\nPayment Receipt:");
        System.out.println("================");
        System.out.println("Driver Name: " + driverName);
        System.out.println("Driver ID: " + driverId);
        System.out.println("Vehicle Plate: " + vehiclePlate);
        System.out.println("Violation Type: " + violationType);
        System.out.println("Amount Paid: " + String.format("%,.2f RWF", fineAmount));
        System.out.println("Status: " + paymentStatus);
        System.out.println("================");
    }
}
