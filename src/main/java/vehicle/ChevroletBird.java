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
        if (checkWingsExtended()) this.wingsExtended = false;
        super.drive(miles);
    }

    @Override
    public boolean canFly(double miles) {
        if (miles < 0) throw new IllegalArgumentException();
        return checkWingsExtended();
    }

    @Override
    public void fly(double miles) {
        if (!checkWingsExtended()) this.wingsExtended = true;
        if (canFly(miles)) {
            super.drive(miles);
            this.mileage -= miles;
        }
    }
    
}
