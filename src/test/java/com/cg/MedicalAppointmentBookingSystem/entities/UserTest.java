package com.cg.MedicalAppointmentBookingSystem.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    static class TestUser extends User {
        public TestUser(String id, String name) {
            super(id, name);
        }

        @Override
        public String showProfile() {
            return "User Profile - ID: " + id + ", Name: " + name;
        }
    }

    @BeforeEach
    void setUp() {
        // Create a TestUser object with ID and Name
        user = new TestUser("U001", "Alice Johnson");
    }

    @Test
    void testConstructor() {
        // Verify the user's ID and Name
        assertEquals("U001", user.getId(), "User ID should be 'U001'.");
        assertEquals("Alice Johnson", user.getName(), "User name should be 'Alice Johnson'.");
    }

    @Test
    void testShowProfile() {
        // Get the user profile details
        String profile = user.showProfile();

        // Verify that the profile contains the correct information
        assertTrue(profile.contains("ID: U001"), "Profile should contain User ID.");
        assertTrue(profile.contains("Name: Alice Johnson"), "Profile should contain User Name.");
    }
}
