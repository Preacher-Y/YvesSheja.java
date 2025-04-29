package materialUsage;

import constructionMaterial.ConstructionMaterial;

public class MaterialUsage extends ConstructionMaterial {
    public MaterialUsage(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void useMaterial() {
        if (materialBalance - materialQuantity >= 2) {
            materialBalance -= materialQuantity;
            System.out.println("Material used successfully. Remaining balance: " + materialBalance + " tons.");
        } else {
            System.out.println("Error: Insufficient material. At least 2 tons must remain after usage.");
        }
    }

    @Override
    public void receiveMaterial() {}

    @Override
    public void estimateCost() {}
}
