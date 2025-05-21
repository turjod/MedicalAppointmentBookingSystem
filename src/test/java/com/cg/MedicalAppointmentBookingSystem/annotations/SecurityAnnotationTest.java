package com.cg.MedicalAppointmentBookingSystem.annotations;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecurityAnnotationTest {

    @Test
    void testSecurityAnnotation() {
        // Check if the annotation is present on the class
        Class<?> clazz = SampleClassWithSecurityAnnotation.class;
        assertTrue(clazz.isAnnotationPresent(Security.class), "Security annotation should be present on class");

        // Retrieve the annotation from the class
        Security securityAnnotation = clazz.getAnnotation(Security.class);

        // Verify that the default role is "User"
        assertEquals("User", securityAnnotation.role(), "The default role should be 'User'");
    }

    // Sample class for testing
    @Security
    static class SampleClassWithSecurityAnnotation {
        // This class has the @Security annotation with the default role "User"
    }
    
    @Security(role="Admin")
    static class SampleAdminClassWithAnnotation{
    	
    }
    
    @Test
    void testAdminRoleAnnotation(){
    	// Check if the annotation is present on the class
    	Class<?> clazz=SampleAdminClassWithAnnotation.class;
    	assertTrue(clazz.isAnnotationPresent(Security.class));
    	
    	// Retrieve the annotation from the class
    	Security securityAnnotation=clazz.getAnnotation(Security.class);
    	
    	// Verify that the default role is "User"
        assertEquals("Admin", securityAnnotation.role(), "The default role should be 'Admin'");
    }
}
