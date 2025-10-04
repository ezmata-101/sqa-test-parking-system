import java.time.LocalDateTime;
import java.util.List;

public class ParkingSystem {
    private static final List<Vehicle> vehicles;
    private static final List<ParkingSlot> parkingSlots;
    private static final List<Booking> bookings;
    private static final double PARKING_RATE_PER_HOUR = 10.0;
    private static final Wallet SYSTEM_WALLET = new Wallet();

    static {
        vehicles = new java.util.ArrayList<>();
        parkingSlots = new java.util.ArrayList<>();
        bookings = new java.util.ArrayList<>();
    }

    public List<ParkingSlot> getAvailableParkingSlots(Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime) {
        List<ParkingSlot> availableSlots = new java.util.ArrayList<>();
        for (ParkingSlot slot : parkingSlots) {
            if (slot.isCompatible(vehicle.getVehicleType(), startTime, endTime)) {
                availableSlots.add(slot);
            }
        }
        return availableSlots;
    }

    public Booking book(Vehicle vehicle, ParkingSlot slot, LocalDateTime startTime, LocalDateTime endTime) {
        if (endTime.isBefore(startTime) || endTime.isEqual(startTime)) {
            throw new IllegalBookingTimeException();
        }

        if (!slot.isCompatible(vehicle.getVehicleType(), startTime, endTime)) {
            throw new IllegalArgumentException("Parking slot is not compatible or not available for the given time.");
        }

        double hours = java.time.Duration.between(startTime, endTime).toHours();
        double amount = hours * PARKING_RATE_PER_HOUR * getVehicleTypeRate(vehicle.getVehicleType()) * parkingSlotTypeMultiplier(slot.getSlotType());

        Booking booking = new Booking(bookings.size() + 1, vehicle, slot, startTime, endTime, amount);
        bookings.add(booking);

        vehicle.getWallet().transferFunds(SYSTEM_WALLET, amount);
        slot.getBookings().add(booking);

        return booking;
    }

    public void completeBooking(Booking booking) {
        booking.completeBooking();
        SYSTEM_WALLET.transferFunds(booking.getParkingSlot().getWallet(), booking.getAmount() * 0.8);
    }

    public void cancelBooking(Booking booking) {
        booking.cancelBooking();
        SYSTEM_WALLET.transferFunds(booking.getVehicle().getWallet(), booking.getAmount() * 0.9);
    }

    public static void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public static void addParkingSlot(ParkingSlot slot) {
        parkingSlots.add(slot);
    }

    private double getVehicleTypeRate(VehicleType type) {
        switch (type) {
            case BICYCLE:
                return 0.2;
            case MOTORCYCLE:
                return 0.5;
            case MICROCAR:
                return 1.5;
            case BUS:
                return 2.0;
            case TRUCK:
                return 3.0;
            default:
                return 1.0;
        }
    }

    private double parkingSlotTypeMultiplier(ParkingSlotType type) {
        switch (type) {
            case COMPACT:
                return 0.8;
            case LARGE:
                return 1.5;
            case HANDICAPPED:
                return 1.2;
            default:
                return 1.0;
        }
    }
}

class IllegalBookingTimeException extends RuntimeException {
    public IllegalBookingTimeException() {
        super("End time must be after start time");
    }
}

class IllegalBookingArgumentException extends RuntimeException {
    public IllegalBookingArgumentException() {
        super("Parking slot is not compatible or not available for the given time.");
    }
}

class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException() {
        super("Insufficient balance in wallet to complete the booking.");
    }
}