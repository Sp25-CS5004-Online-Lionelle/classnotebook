package vehicles;

public class HybridCar extends Car implements UsesGasoline, UsesElectricity{
    @Override
    public void charge(double strength, double duration) {

    }

    @Override
    public void replaceBattery(String newBattery) {

    }

    @Override
    public void pumpGas(double gasVolume) {

    }

    @Override
    public double calculatePollution(double gasVolume) {
        return 0;
    }
}
