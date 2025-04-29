package RwandaPolice.trafficRecord;

public abstract class TrafficRecord {
    protected String driverId;          // National ID or driving license number
    protected String driverName;
    protected String vehiclePlate;      // Vehicle registration plate
    protected String violationType;      // SPEEDING, RED_LIGHT, NO_HELMET, DUI
    protected double fineAmount;
    protected String paymentStatus;      // UNPAID or PAID

    public abstract void recordViolation();
    public abstract void assessFine();
    public abstract void processPayment();

    public void processPayment(double paymentAmount) {
        // Default implementation for partial payment, can be overridden by subclasses
        System.out.println("Partial payment processing is not implemented for this record type.");
    }

    // Getters and Setters
    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getViolationType() {
        return violationType;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
