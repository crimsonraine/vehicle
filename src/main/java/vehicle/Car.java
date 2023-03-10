package vehicle;

import java.util.List;

public abstract class Car {
    String make;
    String model;
    double mileage;

    public Car(String make, String model, double startingMileage) {
        if (startingMileage < 0) throw new IllegalArgumentException();
        this.make = make;
        this.model = model;
        this.mileage = startingMileage;
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.mileage = 0;
    }

    public boolean canDrive(double miles) {
        if (miles < 0) throw new IllegalArgumentException();
        return miles <= getRemainingRange();
    }

    public abstract void drive(double miles);

    public String toString() {
        return this.make + " " + this.model + " (" + this.mileage + " mi)";
    }

    public double getMileage() {
        return mileage;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public abstract double getRemainingRange();

    // implement
    protected void addMileage(double miles) {

    }

    // implement
    public int roadTrip(List<Double> milesEachDay) {
        return 0;
    }

}
