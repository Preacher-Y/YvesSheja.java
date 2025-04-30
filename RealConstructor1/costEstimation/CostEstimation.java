package RealConstructor1.costEstimation;

import RealConstructor1.constructionMaterial.ConstructionMaterial;

public class CostEstimation extends ConstructionMaterial {
    public CostEstimation(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void estimateCost() {
        double costPerTon = (materialQuantity > 15) ? 180000 : 200000;
        double totalCost = costPerTon * materialQuantity;

        System.out.println("\n--- Cost Estimation ---");
        System.out.println("Contractor ID: " + contractorId);
        System.out.println("Contractor Name: " + contractorName);
        System.out.printf("Quantity Needed: %.2f tons%n", materialQuantity);
        System.out.printf("Total Cost: RWF %, .2f%n", totalCost);
    }

    @Override
    public void receiveMaterial() {}

    @Override
    public void useMaterial() {}
}
