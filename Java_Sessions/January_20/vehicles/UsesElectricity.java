package vehicles;

public interface UsesElectricity {
    public void charge(double strength, double duration);

    public void replaceBattery(String newBattery);
}
