package vehicle;

public abstract class GasPoweredCar extends Car {
    double mpg;
    double fuelCapacityGallons;
    double fuelLevel;

    /**
     * Note: Start with a full tank of gas
     * 
     * @throws IllegalArgumentException if mpg or fuelCapacityGallons are
     *                                  non-positive.
     */
    public GasPoweredCar(String make, String model, double startingMileage, double mpg, double fuelCapacityGallons) {
        super(make, model, startingMileage);
        if (mpg <= 0 || fuelCapacityGallons <= 0) throw new IllegalArgumentException();
        this.mpg = mpg;
        this.fuelCapacityGallons = fuelCapacityGallons;
        this.fuelLevel = fuelCapacityGallons;
    }

    /**
     * Defaults mileage to 0.
     * 
     * @throws IllegalArgumentException if mpg or fuelCapacityGallons are
     *                                  non-positive.
     */
    public GasPoweredCar(String make, String model, double mpg, double fuelCapacityGallons) {
        this(make, model, 0, mpg, fuelCapacityGallons);
    }

    /**
     * Drives the full given number of miles.
     * 
     * @throws IllegalArgumentException if miles is negative.
     * @throws IllegalArgumentException if miles is too high given the
     *                                  current fuel.
     */
    public void drive(double miles) {
        if (canDrive(miles)) {
            decreaseFuelLevel(miles);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /** Returns how many miles can be driven on one gallon of gas. */
    public double getMPG() {
        return this.mpg;
    }

    /** Returns how many gallons of fuel are currently in the car. */
    public double getFuelLevel() {
        return this.fuelLevel;
    }

    /** Returns how many gallons of fuel the car can hold at max. */
    public double getFuelCapacity() {
        return this.fuelCapacityGallons;
    }

    /** Refuels the car to max fuel capacity. */
    public void refillTank() {
        this.fuelLevel = this.fuelCapacityGallons;
    }

    /**
     * Returns how many more miles the car can currently go without
     * refueling.
     */
    public double getRemainingRange() {
        return this.fuelLevel * this.mpg;
    }

    /**
     * Attempt to refuel the car with additional gallons.
     * 
     * @throws IllegalArgumentException if gallons is negative OR gallons
     *                                  would overfill the tank.
     */
    public void refillTank(double gallons) {
        if (gallons < 0 || this.fuelLevel + gallons > this.fuelCapacityGallons) throw new IllegalArgumentException();
        this.fuelLevel += gallons;
    }

    /**
     * Decreases the amount of fuel in the gas tank based upon
     * mpg and the number of miles passed as an argument.
     */
    protected void decreaseFuelLevel(double miles) {
        this.fuelLevel -= miles / this.mpg;
        this.mileage += miles;
    }
}
