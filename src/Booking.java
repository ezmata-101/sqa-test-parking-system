import java.time.LocalDateTime;

public class Booking {
    private int bookingId;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double amount;
    private BookingStatus bookingStatus;

    public Booking(int bookingId, Vehicle vehicle, ParkingSlot parkingSlot, LocalDateTime startTime, LocalDateTime endTime, double amount) {
        this.bookingId = bookingId;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.startTime = startTime;
        this.endTime = endTime;
        this.amount = amount;
        this.bookingStatus = BookingStatus.ACTIVE;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public double getAmount() {
        return amount;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void completeBooking() {
        this.bookingStatus = BookingStatus.COMPLETED;
    }

    public void cancelBooking() {
        this.bookingStatus = BookingStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", vehicle=" + vehicle +
                ", parkingSlot=" + parkingSlot +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", amount=" + amount +
                ", bookingStatus=" + bookingStatus +
                '}';
    }
}