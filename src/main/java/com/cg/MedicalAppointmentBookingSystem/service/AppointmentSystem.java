package com.cg.MedicalAppointmentBookingSystem.service;
/**
 * AppointmentSystem is an interface that defines the methods for managing appointments in a medical appointment booking system.
 * It includes methods for registering patients and doctors, booking appointments, completing appointments, and displaying all appointments, doctors, and patients.
 *
 * @author Suchismita
 */
import com.cg.MedicalAppointmentBookingSystem.entities.Appointment;
import com.cg.MedicalAppointmentBookingSystem.entities.Doctor;
import com.cg.MedicalAppointmentBookingSystem.entities.Patient;

public interface AppointmentSystem {

	void registerPatient(Patient patient);

	void registerDoctor(Doctor doctor);

	Appointment bookAppointment(Patient patient);

	void completeAppointment(int index);

	void showAllAppointments();

	void showAllDoctors();
	
	void showAllPatients();

}
