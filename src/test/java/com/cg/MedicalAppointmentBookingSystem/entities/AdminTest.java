package com.cg.MedicalAppointmentBookingSystem.entities;

import com.cg.MedicalAppointmentBookingSystem.exceptions.AdminNotFoundException;
import com.cg.MedicalAppointmentBookingSystem.annotations.*;

import org.junit.jupiter.api.*;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
	
	Admin admin;
	Doctor doctor1;
	List<Doctor> doctors;
	
    @BeforeEach
    void setUp() {
        // Setup the Admin object with ID, Name, and Password
        admin = new Admin("A001", "Admin Name", "admin123");

        // Mock the doctor list
        doctors = new ArrayList<>();

        // Create a mock doctor
        doctor1 = new Doctor("D001","Dr. Ann");
        doctors.add(doctor1);
        
        System.out.println(doctors);
    }

    @Test
    void testAdminConstructor() {
        assertEquals("A001", admin.getId(), "Admin ID should be A001");
        assertEquals("Admin Name", admin.getName(), "Admin name should be 'Admin Name'");
        assertEquals("admin123", admin.getPassword(), "Admin password should be 'admin123'");
    }

    @Test
    void testShowProfile() {
    	
    	//Verify that showProfile is giving correct output
    	assertEquals("Admin ID: A001, Name: Admin Name",admin.showProfile());

        // Call the showProfile method
        admin.showProfile();
    }

    @Test
    void testVerifyPasswordCorrect() {
        assertTrue(admin.verifyPassword("admin123"), "Password should be verified correctly");
    }

    @Test
    void testVerifyPasswordIncorrect() {
        assertFalse(admin.verifyPassword("wrongpassword"), "Password should not be verified if incorrect");
    }

    @Test
    void testRemoveDoctorSuccessfully() {
        admin.removeDoctor(doctors, "D001");

        // Verify that the doctor is removed from the list
        assertTrue(doctors.isEmpty(), "Doctor should be removed from the list");
    }

    @Test
    void testRemoveDoctorDoctorNotFound() {
        // Try to remove a doctor that doesn't exist
        admin.removeDoctor(doctors, "D002");

        // The list should still contain one doctor (doctor1)
        assertFalse(doctors.isEmpty(), "Doctor should not be removed when not found");
    }

    @Test
    void testRemoveDoctorUnauthorized() {
        // Create a new admin with a different role (to simulate non-admin user)
        Admin nonAdmin = new Admin("A002", "Non-Admin", "password");
        assertThrows(AdminNotFoundException.class, () -> {
            nonAdmin.removeDoctor(doctors, "D001");
        }, "Should throw AdminNotFoundException for non-admin users");
    }

    @Test
    void testSecurityAnnotation() {
        // Check if the Admin class has the @Security annotation with the correct role
        Security security = admin.getClass().getAnnotation(Security.class);
        assertNotNull(security, "Security annotation should be present on the Admin class");
        assertEquals("Admin", security.role(), "The role in the annotation should be 'Admin'");
    }
    
    @AfterEach
    void setup() {
    	System.out.println(doctors);;
    }
}
