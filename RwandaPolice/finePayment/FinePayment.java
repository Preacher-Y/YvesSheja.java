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
    public void processPayment(double paymentAmount) {
        super.processPayment(paymentAmount); // Ensure it matches the superclass method
        
        if ("PAID".equals(paymentStatus)) {
            System.out.println("Error: This fine has already been paid!");
            return;
        }

        if (paymentAmount <= 0) {
            System.out.println("Error: Payment amount must be greater than zero!");
            return;
        }

        if (paymentAmount >= fineAmount) {
            fineAmount = 0;
            paymentStatus = "PAID";
            System.out.println("Payment completed in full. Fine is now marked as PAID.");
        } else {
            fineAmount -= paymentAmount;
            System.out.println("Partial payment accepted. Remaining fine amount: " + String.format("%,.2f RWF", fineAmount));
        }

        printReceipt(paymentAmount);
    }

    @Override
    public void processPayment() {
        System.out.println("Error: Payment amount is required to process payment.");
    }

    private void printReceipt(double paymentAmount) {
        System.out.println("\nPayment Receipt:");
        System.out.println("================");
        System.out.println("Driver Name: " + driverName);
        System.out.println("Driver ID: " + driverId);
        System.out.println("Vehicle Plate: " + vehiclePlate);
        System.out.println("Violation Type: " + violationType);
        System.out.println("Amount Paid: " + String.format("%,.2f RWF", paymentAmount));
        System.out.println("Remaining Fine Amount: " + String.format("%,.2f RWF", fineAmount));
        System.out.println("Status: " + paymentStatus);
        System.out.println("================");
    }
}
