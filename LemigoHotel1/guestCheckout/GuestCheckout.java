package LemigoHotel1.guestCheckout;

import LemigoHotel1.billing.Billing;
import LemigoHotel1.hotelService.HotelService;

public class GuestCheckout extends HotelService {
    public GuestCheckout(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void checkoutGuest() {
        if (!roomStatus.equals("OCCUPIED")) {
            System.out.println("\nError: Room is already available.");
            return;
        }
        
        Billing bill = new Billing(guestId, guestName, roomType, stayDays, roomStatus);
        
        if (!bill.isPaid()) {
            System.out.println("\nPlease pay your bill first before checking out!");
            bill.generateBill();
           
            if (bill.isPaid()) {
                roomStatus = "AVAILABLE";
                System.out.println("\nCheckout successful for " + guestName + ". Room is now AVAILABLE.");
            }
        } else {
            roomStatus = "AVAILABLE";
            System.out.println("\nCheckout successful for " + guestName + ". Room is now AVAILABLE.");
        }
    }

    @Override
    public void bookRoom() {}

    @Override
    public void generateBill() {}
}
