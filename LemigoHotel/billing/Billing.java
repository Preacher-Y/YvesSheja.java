package billing;

import hotelService.HotelService;

public class Billing extends HotelService {
    public Billing(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void generateBill() {
        int ratePerNight = switch (roomType.toUpperCase()) {
            case "STANDARD" -> 50000;
            case "DELUXE" -> 80000;
            case "SUITE" -> 120000;
            default -> 0;
        };

        if (ratePerNight == 0) {
            System.out.println("Error: Invalid room type.");
            return;
        }

        int totalCost = ratePerNight * stayDays;

        System.out.println("\n--- Billing Information ---");
        System.out.println("Guest ID: " + guestId);
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Stay Duration: " + stayDays + " nights");
        System.out.printf("Total Bill: RWF %,d%n", totalCost);
    }

    @Override
    public void bookRoom() {}

    @Override
    public void checkoutGuest() {}
}
