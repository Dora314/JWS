package com.vn.jewelry_management_system;

import com.vn.jewelry_management_system.domain.Stall;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StallTest {

    @Test
    public void testStallConstructorAndGettersAndSetters() {
        // Create a Stall object
        Stall stall = new Stall("Stall A", "North Wing");

        // Assert that the constructor and getters work correctly
        assertEquals("Stall A", stall.getStallName());
        assertEquals("North Wing", stall.getLocation());

        // Update the stall's information using setters
        stall.setStallName("Stall B");
        stall.setLocation("South Wing");

        // Assert that the setters work correctly
        assertEquals("Stall B", stall.getStallName());
        assertEquals("South Wing", stall.getLocation());
    }

    @Test
    public void testStallToString() {
        // Create a Stall object
        Stall stall = new Stall("Stall A", "North Wing");

        // Set the stall ID (normally done by the database)
        stall.setStallId(1);

        // Assert that the toString method produces the expected output
        String expectedToString = "Stall [stallId=1, stallName=Stall A, location=North Wing]";
        assertEquals(expectedToString, stall.toString());
    }
}