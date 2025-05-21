package com.cg.MedicalAppointmentBookingSystem.entities;
/**
 * Patient class represents a patient in the system.
 * It extends the User class and contains specific attributes and methods for patients.
 * It contains the overridden method showProfile() to display the patient's profile.
 *
 * @author Suchismita
 */
public class Patient extends User{
	/**
	 * constructor to create a patient with ID and name.
	 * @param id
	 * @param name
	 */
    public Patient(String id, String name) {
        super(id, name);
    }

    public Patient() {
    }
    
    /***
	 * 
	 * @return the String of the patient details.
	 */
    @Override
    public String showProfile() {
    	String patientDetails="Patient ID: " + id + ", Patient Name: " + name;
        System.out.println(patientDetails);
        return patientDetails;
    }
}
