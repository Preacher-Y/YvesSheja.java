package RealConstructor1.main;

import java.util.Scanner;

import RealConstructor1.costEstimation.CostEstimation;
import RealConstructor1.materialDelivery.MaterialDelivery;
import RealConstructor1.materialUsage.MaterialUsage;

public class Main2 {
    private static Scanner sc = new Scanner(System.in);
    private static boolean materialsReceived = false;
    private static double materialBalance = 0;

    private static int getIntInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(sc.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    private static double getDoubleInput(String prompt, double min) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(sc.nextLine());
                if (value >= min) {
                    return value;
                }
                System.out.println("Please enter a number greater than or equal to " + min);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    public static void main(String[] args) {
        double currentBalance = 0;
        System.out.println("\n Welcome To Real Constructor ");
        System.out.println("-----------------------------");

        System.out.print("Enter Contractor ID: ");
        String id = sc.nextLine();
        while (id.isEmpty()) {
            System.out.print("Contractor ID cannot be empty. Please enter again: ");
            id = sc.nextLine();
            
        }

        System.out.print("Enter Contractor Name: ");
        String name = sc.nextLine();
        while (name.isEmpty()) {
            System.out.print("Contractor Name cannot be empty. Please enter again: ");
            name = sc.nextLine();
            
        }

        while (true) {
            System.out.println("\nWhat Service Do You Desire:");
            System.out.println("\n1. Receive Material");
            System.out.println("2. Use Material");
            System.out.println("3. Estimate Cost");
            System.out.println("4. Exit");
            int choice = getIntInput("Choose an option (1-4): ", 1, 4);

            if (choice == 4) {
                System.out.println("Exiting. Thank you!");
                break;
            }

            switch (choice) {
                case 1:
                    MaterialDelivery delivery = new MaterialDelivery(id, name, 
                        getDoubleInput("Enter quantity to receive (1-10 tons): ", 1), 0);
                    delivery.receiveMaterial();
                    materialsReceived = true;
                    materialBalance = delivery.getMaterialBalance();
                    break;
                case 2:
                    if (!materialsReceived) {
                        System.out.println("Error: No materials received yet. Please receive materials first.");
                    } else if (materialBalance <= 0) {
                        System.out.println("Error: No materials available. Please receive more materials.");
                    } else {
                        double qty = getDoubleInput("Enter Quantity: ", 0);
                        MaterialUsage usage = new MaterialUsage(id, name, qty, materialBalance);
                        usage.useMaterial();
                        materialBalance = usage.getMaterialBalance();
                    }
                    break;
                case 3:
                    double qty = getDoubleInput("Enter Quantity: ", 0);
                    CostEstimation cost = new CostEstimation(id, name, qty, currentBalance);
                    cost.estimateCost();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
