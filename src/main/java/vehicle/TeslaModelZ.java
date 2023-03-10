package vehicle;

public class TeslaModelZ extends ElectricCar implements SelfDriving {
    int modelNum;

    public TeslaModelZ(double startingMileage, int modelNum) {
        super("Tesla", "Z", startingMileage, 340);
        this.modelNum = modelNum;
    }

    public TeslaModelZ(int modelNum) {
        super("Tesla", "Z", 340);
        this.modelNum = modelNum;
    }

    public int getModelNum() {
        return this.modelNum;
    }

    public String getModel() {
        return this.model;
    }

    public String toString() {
        return getMake() + " " + getModel() + getModelNum() + " (" + getMileage() + " mi)";
    }

    public void driveAutonomously(double miles) {
        if (miles < 0) throw new IllegalArgumentException();
        drive(Math.min(getRemainingRange(), miles));
    }

}
