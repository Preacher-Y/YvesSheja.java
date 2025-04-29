package constructionMaterial;

public abstract class ConstructionMaterial {
    protected String contractorId;
    protected String contractorName;
    protected double materialQuantity;
    protected double materialBalance;

    public ConstructionMaterial(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        this.contractorId = contractorId;
        this.contractorName = contractorName;
        this.materialQuantity = materialQuantity;
        this.materialBalance = materialBalance;
    }

    public abstract void receiveMaterial();
    public abstract void useMaterial();
    public abstract void estimateCost();

    // Getters and Setters
    public String getContractorId() {
        return contractorId;
    }

    public String getContractorName() {
        return contractorName;
    }

    public double getMaterialBalance() {
        return materialBalance;
    }

    public void setMaterialBalance(double materialBalance) {
        this.materialBalance = materialBalance;
    }
}
