package vehicle;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying{ // extends GasPoweredCar {
    /** FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6. */
    public FordFrivolous(double startingMileage) {
        super("Ford", "Frivolous", startingMileage, 23.6, 20.0);
    }

    /** Defaults mileage to 0. */
    public FordFrivolous() {
        this(0.0);
    }

    @Override
    public boolean canFly(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException();
        }
        return miles >= 0 && ((miles / this.mpg) * 3 <= getRemainingRange());
    }

    @Override
    public void fly(double miles) {
        if (canFly(miles)) {
            this.fuelLevel -= (miles / this.mpg) * 3;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void driveAutonomously(double miles) {
        if (miles < 0) throw new IllegalArgumentException();
        drive(Math.min(getRemainingRange()/2, miles));
    }
}
