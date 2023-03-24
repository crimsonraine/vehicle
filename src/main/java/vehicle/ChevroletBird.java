package vehicle;

public class ChevroletBird extends ElectricCar implements Flying {
    boolean wingsExtended;

    public ChevroletBird(double startingMileage) {
        super("Chevrolet", "Bird", startingMileage, 250);
        this.wingsExtended = false;
    }

    public ChevroletBird() {
        this(0);
    }

    public boolean checkWingsExtended() {
        return this.wingsExtended;
    }

    public void drive(double miles) {
        super.drive(miles);
        if (checkWingsExtended()) this.wingsExtended = false;
    }

    @Override
    public boolean canFly(double miles) {
        if (miles < 0) throw new IllegalArgumentException();
        return miles <= this.getRemainingRange();
    }

    @Override
    public void fly(double miles) {
        super.drive(miles);
        this.mileage -= miles;
        if (!checkWingsExtended()) this.wingsExtended = true;
    }
    
}
