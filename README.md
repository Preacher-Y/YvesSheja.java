# Object-Oriented Programming Project

This repository contains three Java-based Object-Oriented Programming (OOP) projects, each designed to demonstrate the use of abstract classes and inheritance. Below is an overview of the projects and their requirements.

## 1. Site Construction Management System (REAL CONSTRUCTOR)

This project simulates material handling and cost tracking on a construction site. It includes the following components:

### Abstract Class: `ConstructionMaterial`
- **Abstract Methods:**
  - `receiveMaterial()` - For processing delivered materials.
  - `useMaterial()` - For handling consumption of materials.
  - `estimateCost()` - For calculating cost based on usage.
- **Shared Fields:**
  - `contractorId` (String) - Unique identifier for the contractor.
  - `contractorName` (String) - Full name of the contractor.
  - `materialQuantity` (double) - Quantity of material (in tons).
  - `materialBalance` (double) - Current available quantity in stock.

### Concrete Classes:
1. **`MaterialDelivery`**
   - Handles material deliveries to the site.
   - Accepts delivery only if quantity is between 1 and 10 tons.
   - Updates `materialBalance` on successful delivery.
2. **`MaterialUsage`**
   - Allows material usage only if `materialBalance` remains ≥ 2 tons.
   - Subtracts used quantity from `materialBalance`.
3. **`CostEstimation`**
   - Calculates cost per ton based on quantity.
   - Displays contractor details, quantity used, and total cost.

---

## 2. Hotel Management System (LEMIGO HOTEL)

This project manages hotel guest reservations, checkouts, and billing. It includes the following components:

### Abstract Class: `HotelService`
- **Abstract Methods:**
  - `bookRoom()`
  - `checkoutGuest()`
  - `generateBill()`
- **Common Attributes:**
  - `guestId` (String) - Unique ID of the guest.
  - `guestName` (String) - Full name of the guest.
  - `roomType` (String) - Can be "STANDARD", "DELUXE", or "SUITE".
  - `stayDays` (int) - Number of days the guest plans to stay.
  - `roomStatus` (String) - Either "AVAILABLE" or "OCCUPIED".

### Concrete Classes:
1. **`RoomBooking`**
   - Allows booking if `stayDays` is between 1 and 30 and `roomStatus` is "AVAILABLE".
   - Updates `roomStatus` to "OCCUPIED" on successful booking.
2. **`GuestCheckout`**
   - Processes checkout if `roomStatus` is "OCCUPIED".
   - Updates `roomStatus` to "AVAILABLE" after checkout.
3. **`Billing`**
   - Calculates cost based on `roomType` and `stayDays`.
   - Displays guest details, room type, days stayed, and total cost.

---

## 3. Traffic Fine Management System (Rwanda National Police)

This project manages traffic violations, fines, and payments. It includes the following components:

### Abstract Class: `TrafficRecord`
- **Abstract Methods:**
  - `recordViolation()`
  - `assessFine()`
  - `processPayment()`
- **Common Attributes:**
  - `driverId` (String) - National ID or driving license number.
  - `driverName` (String)
  - `vehiclePlate` (String) - Vehicle registration plate.
  - `violationType` (String) - e.g., "SPEEDING", "RED_LIGHT", etc.
  - `fineAmount` (double)
  - `paymentStatus` (String) - "UNPAID" or "PAID".

### Concrete Classes:
1. **`ViolationEntry`**
   - Records new traffic violations.
   - Sets `paymentStatus` to "UNPAID".
2. **`FineAssessment`**
   - Calculates fine based on `violationType`.
   - Displays fine details.
3. **`FinePayment`**
   - Processes payment if `paymentStatus` is "UNPAID".
   - Updates `paymentStatus` to "PAID" and displays receipt.

---

## Implementation Notes
- Each project includes a `main()` method for user input and validations.
- Proper error handling and meaningful messages are implemented.
- Constructors and getter/setter methods are used for data encapsulation.

## Docker Usage

**Note:**
We cannot use the Docker GUI for this project because Java applications require TTY (a terminal interface) for proper interaction. The `-it` flag in the Docker command ensures that the container runs in an interactive terminal mode, which is essential for the Java-based console applications in this project.

To access and run this project using Docker in the terminal, use the following command:

```bash
docker run -it shejayves/oop-project_26500
```
