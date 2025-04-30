package LemigoHotel1.main;

import java.util.Scanner;

import LemigoHotel1.billing.Billing;
import LemigoHotel1.guestCheckout.GuestCheckout;
import LemigoHotel1.roomBooking.RoomBooking;

public class Main1 {
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

    private static String getRoomType() {
        while (true) {
            System.out.println("Tariff Details:");
            System.out.println("--------------\n");
            System.out.println("1. STANDARD - 50,000 RWF per night\n2. DELUXE - 80,000 RWF per night\n3. SUITE - 120,000 RWF per night\n");
            System.out.print("Enter Room Type (STANDARD/DELUXE/SUITE): ");
            String type = sc.nextLine().toUpperCase();
            if (type.equals("STANDARD") || type.equals("DELUXE") || type.equals("SUITE")) {
                return type;
            }
            System.out.println("Invalid room type. Please enter STANDARD, DELUXE, or SUITE");
        }
    }

    public static void main(String[] args) {
        String status = "AVAILABLE";
        System.out.println("\n Welcome To Lemigo Hotel ");
        System.out.println("-------------------------");

        System.out.print("\nEnter Guest ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Guest Name: ");
        String name = sc.nextLine();

        String type = getRoomType();
        int days = getIntInput("Enter Number of Stay Days (1-30): ", 1, 30);

        while (true) {
            System.out.println("\nWhat Service Do You Desire:");
            System.out.println("\n1. Book Room");
            System.out.println("2. Checkout Guest");
            System.out.println("3. Generate Bill");
            System.out.println("4. Exit");
            
            int option = getIntInput("\nChoose option (1-4): ", 1, 4);

            switch (option) {
                case 1:
                    RoomBooking booking = new RoomBooking(id, name, type, days, status);
                    booking.bookRoom();
                    status = booking.getRoomStatus();
                    break;
                case 2:
                    GuestCheckout checkout = new GuestCheckout(id, name, type, days, status);
                    checkout.checkoutGuest();
                    status = checkout.getRoomStatus();
                    break;
                case 3:
                    Billing bill = new Billing(id, name, type, days, status);
                    bill.generateBill();
                    break;
                case 4:
                    System.out.println("\nThank you for using LEMIGO HOTEL System!");
                    sc.close();
                    return;
                default:
                    System.out.println("\nInvalid option. Please try again.");
            }
        }
    }
}
