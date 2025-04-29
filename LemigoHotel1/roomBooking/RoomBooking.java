package LemigoHotel1.roomBooking;

import LemigoHotel1.hotelService.HotelService;

public class RoomBooking extends HotelService {
    public RoomBooking(String guestId, String guestName, String roomType, int stayDays, String roomStatus) {
        super(guestId, guestName, roomType, stayDays, roomStatus);
    }

    @Override
    public void bookRoom() {
        if (stayDays < 1 || stayDays > 30) {
            System.out.println("Error: Stay duration must be between 1 and 30 days.");
            return;
        }

        if (!roomStatus.equals("AVAILABLE")) {
            System.out.println("Error: Room is not available for booking.");
            return;
        }

        roomStatus = "OCCUPIED";
        System.out.println("Booking confirmed for " + guestName + ". Room is now OCCUPIED.");
    }

    @Override
    public void checkoutGuest() {}

    @Override
    public void generateBill() {}
}
