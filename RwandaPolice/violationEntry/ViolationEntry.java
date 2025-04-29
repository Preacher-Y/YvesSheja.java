package RwandaPolice.violationEntry;

import RwandaPolice.trafficRecord.TrafficRecord;

public class ViolationEntry extends TrafficRecord {
    private static final String[] VALID_VIOLATIONS = {"SPEEDING", "RED_LIGHT", "NO_HELMET", "DUI"};

    public ViolationEntry(String driverId, String driverName, String vehiclePlate, String violationType) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehiclePlate = vehiclePlate;
        this.violationType = violationType;
        this.paymentStatus = "UNPAID";
    }

    @Override
    public void recordViolation() {
        if (!isValidViolationType()) {
            System.out.println("Error: Invalid violation type!");
            return;
        }
        
        if (!isValidDriverId()) {
            System.out.println("Error: Driver ID must be exactly 16 digits!");
            return;
        }

        if (!isValidPlateNumber()) {
            System.out.println("Error: Invalid plate number format! Should be like RAB123D");
            return;
        }

        System.out.println("\nViolation Recorded Successfully:");
        System.out.println("Driver: " + driverName + " (ID: " + driverId + ")");
        System.out.println("Vehicle Plate: " + vehiclePlate);
        System.out.println("Violation Type: " + violationType);
        System.out.println("Status: " + paymentStatus);
    }

    @Override
    public void assessFine() {
        // This will be handled by FineAssessment class
    }

    @Override
    public void processPayment() {
        // This will be handled by FinePayment class
    }

    private boolean isValidViolationType() {
        for (String validType : VALID_VIOLATIONS) {
            if (validType.equalsIgnoreCase(violationType)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidDriverId() {
        return driverId != null && driverId.length() == 16 && driverId.matches("\\d+");
    }

    private boolean isValidPlateNumber() {
        return vehiclePlate != null && vehiclePlate.matches("RAB\\d{3}[A-Z]");
    }
}
