package vehicle;

public abstract class ElectricCar extends Car {
    double milesOnMaxCharge;
    double mileageSinceLastCharge;
    double charge;

    public ElectricCar(String make, String model, double startingMileage, double milesOnMaxCharge) {
        super(make, model, startingMileage);
        if (milesOnMaxCharge <= 0) throw new IllegalArgumentException();
        this.milesOnMaxCharge = milesOnMaxCharge;
        this.mileageSinceLastCharge = 0;
        this.charge = 100;
    }

    public ElectricCar(String make, String model, double milesOnMaxCharge) {
        super(make, model);
        if (milesOnMaxCharge <= 0) throw new IllegalArgumentException();
        this.milesOnMaxCharge = milesOnMaxCharge;
        this.mileageSinceLastCharge = 0;
        this.charge = 100;
    }

    public void drive(double miles) {
        if (miles < 0 || !canDrive(miles)) throw new IllegalArgumentException();
        this.mileage += miles;
        decreaseCharge(miles);
    }

    public double getRemainingRange() {
        return getMaxRange() - this.mileageSinceLastCharge;
    }

    public double getMaxRange() {
        return this.milesOnMaxCharge;
    }

    public void recharge() {
        this.charge = 100;
        this.mileageSinceLastCharge = 0;
    }

    protected void decreaseCharge(double miles) {
        this.charge *= miles/getMaxRange();
    }

}
