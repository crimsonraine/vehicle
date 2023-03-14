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
        assertEquals(20.0, ford.getFuelCapacity(),  0.1, "Initial fuel capacity not correct.");
        assertEquals(20.0, ford.getFuelLevel(),  0.1, "The car should begin full.");
        assertEquals(23.6, ford.getMPG(), 0.1, "Initial mpg not correct.");
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
        assertEquals(20.0, ford.getFuelCapacity(),  0.1, "Initial fuel capacity not correct.");
        assertEquals(ford.getFuelCapacity(), ford.getFuelLevel(), 0.1, "The car should begin full.");
        assertEquals(23.6, ford.getMPG(), 0.1, "Initial mpg not correct.");
        assertEquals(30.0, ford.getMileage(), 0.1, "Default mileage should be zero.");
        assertEquals(ford.getFuelCapacity() * ford.getMPG(), ford.getRemainingRange(), 0.1,
                "Remaining range of car not correct at creation.");
        assertEquals("Ford", ford.getMake(), "make does not match");
        assertEquals("Frivolous", ford.getModel(), "model does not match");
        assertEquals("Ford Frivolous (30.0 mi)", ford.toString(), "toString does not match");
    }

    @Test
    public void fordDrivingTest3() {
        
    }
    
}
