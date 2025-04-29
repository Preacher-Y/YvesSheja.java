package RwandaPolice.fineAssessment;

import RwandaPolice.trafficRecord.TrafficRecord;

public class FineAssessment extends TrafficRecord {
    private static final double SPEEDING_FINE = 50000.0;
    private static final double RED_LIGHT_FINE = 80000.0;
    private static final double NO_HELMET_FINE = 30000.0;
    private static final double DUI_FINE = 150000.0;

    public FineAssessment(String driverId, String driverName, String vehiclePlate, String violationType) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehiclePlate = vehiclePlate;
        this.violationType = violationType;
        this.paymentStatus = "UNPAID";
    }

    @Override
    public void recordViolation() {
        // This is handled by ViolationEntry class
    }

    @Override
    public void assessFine() {
        switch(violationType.toUpperCase()) {
            case "SPEEDING":
                fineAmount = SPEEDING_FINE;
                break;
            case "RED_LIGHT":
                fineAmount = RED_LIGHT_FINE;
                break;
            case "NO_HELMET":
                fineAmount = NO_HELMET_FINE;
                break;
            case "DUI":
                fineAmount = DUI_FINE;
                break;
            default:
                System.out.println("Error: Unrecognized violation type!");
                return;
        }

        displayFineDetails();
    }

    @Override
    public void processPayment() {
        // This is handled by FinePayment class
    }

    private void displayFineDetails() {
        System.out.println("\nFine Assessment Details:");
        System.out.println("Driver: " + driverName + " (ID: " + driverId + ")");
        System.out.println("Vehicle Plate: " + vehiclePlate);
        System.out.println("Violation Type: " + violationType);
        System.out.println("Fine Amount: " + String.format("%,.2f RWF", fineAmount));
        System.out.println("Payment Status: " + paymentStatus);
    }
}
