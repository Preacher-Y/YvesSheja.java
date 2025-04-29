package main;

import java.util.Scanner;

import costEstimation.CostEstimation;
import materialDelivery.MaterialDelivery;
import materialUsage.MaterialUsage;

public class Main2 {
    private static Scanner sc = new Scanner(System.in);

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

        System.out.print("Enter Contractor Name: ");
        String name = sc.nextLine();

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

            double qty = getDoubleInput("Enter Quantity (must be positive): ", 0);

            switch (choice) {
                case 1:
                    MaterialDelivery delivery = new MaterialDelivery(id, name, qty, currentBalance);
                    delivery.receiveMaterial();
                    currentBalance = delivery.getMaterialBalance();
                    break;
                case 2:
                    MaterialUsage usage = new MaterialUsage(id, name, qty, currentBalance);
                    usage.useMaterial();
                    currentBalance = usage.getMaterialBalance();
                    break;
                case 3:
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
