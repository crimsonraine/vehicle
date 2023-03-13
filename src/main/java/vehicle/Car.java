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
        return getMake() + " " + getModel() + " (" + getMileage() + " mi)";
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

    protected void addMileage(double miles) {
        if (miles < 0) throw new IllegalArgumentException();
        mileage += miles;
    }

    public int roadTrip(List<Double> milesEachDay) {
        int dayCount = 0;
        for (double routeLength : milesEachDay) {
            if (routeLength < 0) throw new IllegalArgumentException();
            if (routeLength < getRemainingRange()) {
                return dayCount;
            } else {
                drive(routeLength);
                dayCount += 1;
            }
        }
        return dayCount;
    }

}
