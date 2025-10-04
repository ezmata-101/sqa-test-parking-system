public class Vehicle {
    private int vehicleId;
    private VehicleType vehicleType;
    Wallet wallet;

    public Vehicle(int vehicleId, VehicleType vehicleType, Wallet wallet) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.wallet = wallet;
    }

    public Vehicle(int vehicleId, VehicleType vehicleType, double initialBalance) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.wallet = new Wallet(initialBalance);
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Wallet getWallet() {
        return wallet;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleType=" + vehicleType +
                ", walletBalance=" + wallet.getBalance() +
                '}';
    }
}