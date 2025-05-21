package com.cg.MedicalAppointmentBookingSystem.entities;
/**
 * Appointment class represents an appointment in the system.
 * It contains attributes and methods related to appointments.
 * It includes methods to get appointment details and update appointment status.
 *
 * @author Aiindrila
 */
public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String status = "Scheduled";
    
    // Default constructor
    public Appointment() {
    }
    /***
	 * Constructor to create an appointment with a patient, doctor, and status.
	 * @param patient The patient associated with the appointment.
	 * @param doctor The doctor associated with the appointment.
	 * @param status The status of the appointment.
	 */
    // Constructor to create an appointment with a patient and a doctor
    public Appointment(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
        this.doctor.setAvailable(false);
    }
    
    /***
     * 
     * @return the status of the appointment.
     */
    // Constructor to create an appointment with a patient, doctor, and status
    public String getStatus() {
        return status;
    }
    
    /***
	 * 
	 * @param status The status of the appointment.
	 */
    //Access patient for the particular appointment
    public Patient getPatient() {
    	return this.patient;
    }
    
    /***
     * 
     * @return the status of the appointment.
     */
    //Access doctor for this particular appointment
    public Doctor getDoctor() {
    	return this.doctor;
    }
    
    /***
     * @param status The status of the appointment. 
     */
    // Method to get the patient of the appointment
    public void completedAppointment() {
        this.status = "Completed";
        this.doctor.setAvailable(true);
    }
    /***
	 * @param status The status of the appointment. 
	 */
    // Method to get the doctor of the appointment
    public String appointmentDetails() {
    	String appointmentDetails="Appointment Details: \n" +
                "Patient: " + patient.name + "\n" +
                "Doctor: " + doctor.name + "\n" +
                "Status: " + status;
        System.out.println(appointmentDetails);
        return appointmentDetails;
    }

}