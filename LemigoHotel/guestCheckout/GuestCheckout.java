package guestCheckout;

import hotelService.HotelService;

public class GuestCheckout extends HotelService {
    public GuestCheckout(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void checkoutGuest() {
        if (!roomStatus.equals("OCCUPIED")) {
            System.out.println("Error: Room is already available.");
            return;
        }

        roomStatus = "AVAILABLE";
        System.out.println("Checkout successful for " + guestName + ". Room is now AVAILABLE.");
    }

    @Override
    public void bookRoom() {}

    @Override
    public void generateBill() {}
}
