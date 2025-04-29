package LemigoHotel1.billing;

import LemigoHotel1.hotelService.HotelService;

public class Billing extends HotelService {
    public Billing(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void generateBill() {
        int ratePerNight = calculateRate(roomType);

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

    public int calculateRate(String roomType) {
        int ratePerNight;
        switch (roomType.toUpperCase()) {
            case "STANDARD":
                ratePerNight = 50000;
                break;
            case "DELUXE":
                ratePerNight = 80000;
                break;
            case "SUITE":
                ratePerNight = 120000;
                break;
            default:
                ratePerNight = 0;
        }
        return ratePerNight;
    }

    @Override
    public void bookRoom() {}

    @Override
    public void checkoutGuest() {}
}
