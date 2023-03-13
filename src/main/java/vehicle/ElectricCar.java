package vehicle;

public abstract class ElectricCar extends Car {
    double milesOnMaxCharge;
    double charge;

    public ElectricCar(String make, String model, double startingMileage, double milesOnMaxCharge) {
        super(make, model, startingMileage);
        if (milesOnMaxCharge <= 0) throw new IllegalArgumentException();
        this.milesOnMaxCharge = milesOnMaxCharge;
        recharge();
    }

    public ElectricCar(String make, String model, double milesOnMaxCharge) {
        super(make, model);
        if (milesOnMaxCharge <= 0) throw new IllegalArgumentException();
        this.milesOnMaxCharge = milesOnMaxCharge;
        recharge();
    }

    public void drive(double miles) {
        if (miles < 0 || !canDrive(miles)) throw new IllegalArgumentException();
        addMileage(miles);
        decreaseCharge(miles);
    }

    public double getRemainingRange() {
        return this.charge;
    }

    public double getMaxRange() {
        return this.milesOnMaxCharge;
    }

    public void recharge() {
        this.charge = getMaxRange();
    }

    protected void decreaseCharge(double miles) {
        this.charge -= miles;
    }

}
