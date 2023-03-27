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
        return ((miles * 3 / getMPG()) <= getFuelLevel());
    }

    @Override
    public void fly(double miles) {
        if (canFly(miles)) {
            this.fuelLevel -= (miles / getMPG()) * 3;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void driveAutonomously(double miles) {
        if (miles < 0) throw new IllegalArgumentException();
        double distance = Math.min(getRemainingRange(), miles*2);
        drive(distance);
        this.mileage -= distance/2;
    }
}
