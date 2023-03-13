package vehicle;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying{ // extends GasPoweredCar {
    /** FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6. */
    public FordFrivolous(double startingMileage) {
        
    }

    /** Defaults mileage to 0. */
    public FordFrivolous() {
        
    }

    @Override
    public boolean canFly(double miles) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canFly'");
    }

    @Override
    public void fly(double miles) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fly'");
    }

    @Override
    public void driveAutonomously(double miles) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'driveAutonomously'");
    }
}
