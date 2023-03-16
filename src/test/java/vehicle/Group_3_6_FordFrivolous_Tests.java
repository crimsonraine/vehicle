package vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Group_3_6_FordFrivolous_Tests {
    @Test
    public void fordConstructorTest1() {
        FordFrivolous ford = new FordFrivolous();
        assertEquals(23.6, ford.getFuelCapacity(),  0.1, "Initial fuel capacity not correct.");
        assertEquals(23.6, ford.getFuelLevel(),  0.1, "The car should begin full.");
        assertEquals(20.0, ford.getMPG(), 0.1, "Initial mpg not correct.");
        assertEquals(0.0, ford.getMileage(), 0.1, "Default mileage should be zero.");
        assertEquals(ford.getFuelCapacity() * ford.getMPG(), ford.getRemainingRange(), 0.1,
                "Remaining range of car not correct at creation.");
        assertEquals("Ford", ford.getMake(), "make does not match");
        assertEquals("Frivolous", ford.getModel(), "model does not match");
        assertEquals("Ford Frivolous (0.0 mi)", ford.toString(), "toString does not match");
    }

    @Test
    public void fordMileageConstructorTest2() {
        FordFrivolous ford = new FordFrivolous(30.0);
        assertEquals(23.6, ford.getFuelCapacity(),  0.1, "Initial fuel capacity not correct.");
        assertEquals(ford.getFuelCapacity(), ford.getFuelLevel(), 0.1, "The car should begin full.");
        assertEquals(20.0, ford.getMPG(), 0.1, "Initial mpg not correct.");
        assertEquals(30.0, ford.getMileage(), 0.1, "Default mileage should be zero.");
        assertEquals(ford.getFuelCapacity() * ford.getMPG(), ford.getRemainingRange(), 0.1,
                "Remaining range of car not correct at creation.");
        assertEquals("Ford", ford.getMake(), "make does not match");
        assertEquals("Frivolous", ford.getModel(), "model does not match");
        assertEquals("Ford Frivolous (30.0 mi)", ford.toString(), "toString does not match");
    }

    @Test
    public void fordDrivingTest3() {
        FordFrivolous ford = new FordFrivolous(49.7);
        assertEquals(472.0, ford.getRemainingRange(), .1, "Remaining range should start as 20 * 23.6.");

        assertThrows(IllegalArgumentException.class, () -> {
            ford.drive(-0.11);
        }, "Driving mileage cannot be negative.");
        
        ford.drive(0);
        assertEquals(49.7, ford.getMileage(), .1, "Mileage should not have changed.");

        ford.drive(30);
        assertEquals(79.7, ford.getMileage(), .1, "Mileage should be 30 after first drive.");

        ford.drive(200);
        assertEquals(279.7, ford.getMileage(), .1, "Mileage should be 230 after second drive.");
        assertEquals(472.0 - 230.0 , ford.getRemainingRange(), 0.1, "Remaining range should be 472-230=242.");

        assertFalse(ford.canDrive(250), "Should not be able to drive more than remaining range (242).");
        assertTrue(ford.canDrive(110), "Should be able to drive remaining range (242).");

        ford.drive(241);
        assertEquals(1, ford.getRemainingRange(), .1, "Mileage should be 1 after third drive.");

        assertThrows(IllegalArgumentException.class, () -> {
            ford.drive(1.5);
        }, "Cannot drive more than remaining range on gas level.");

        ford.drive(1);
        assertEquals(0, ford.getRemainingRange(), .1, "Remaining range should be 0 after fourth drive.");

        ford.refillTank();
        assertEquals(472.0, ford.getRemainingRange(), .1, "Remaining range should restart again as 20 * 23.6 after refill.");

        assertFalse(ford.canFly(-110.0), "Should not be able to fly a negative distance (-110).");
        assertTrue(ford.canFly(100.0), "Should not be able to fly a positive distance (100).");

        ford.fly(110.0);
        assertEquals(20.0 - 16.5, ford.getFuelLevel(), "Fuel level is incorrect after flying.");
        assertEquals(521.7, ford.getMileage(), "Mileage is incorrect after flying. It should not have changed.");
    }
    
}
