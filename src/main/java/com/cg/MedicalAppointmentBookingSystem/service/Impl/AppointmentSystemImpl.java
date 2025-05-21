package com.cg.MedicalAppointmentBookingSystem.service.Impl;

import com.cg.MedicalAppointmentBookingSystem.entities.Appointment;
import com.cg.MedicalAppointmentBookingSystem.entities.Doctor;
import com.cg.MedicalAppointmentBookingSystem.entities.Patient;
import com.cg.MedicalAppointmentBookingSystem.exceptions.*;
import com.cg.MedicalAppointmentBookingSystem.service.AppointmentSystem;

import java.util.ArrayList;
import java.util.List;
/***@author Aishik
 * @author Rajdeep
 *
 * This class implements the AppointmentSystem interface and provides methods to manage patients, doctors, and appointments.
 */
public class AppointmentSystemImpl implements AppointmentSystem {
    private final List<Patient> patients;
    private final List<Doctor> doctors;
    private final List<Appointment> appointments;

    //Constructor to initialize the lists
    public AppointmentSystemImpl() {
    	this.patients=new ArrayList<Patient>();
    	this.doctors=new ArrayList<Doctor>();
    	this.appointments=new ArrayList<Appointment>();
    }
    
    //Getter Methods to Access private lists
    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }
    
    /*
     * This is a singleton class that implements the AppointmentSystem interface.
     */
    
    //This produces a singleton instance of AppointmentSystemImpl that can be used throughout the application.
    //without different instances of the class being created , for all the users and operations.
    private static AppointmentSystemImpl INSTANCE;

    public static AppointmentSystemImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppointmentSystemImpl();
        }
        return INSTANCE;
    }

    /***
     * Register a new patient
     * @param patient
     */
	public void registerPatient(Patient patient) {
		patients.add(patient);
		System.out.println("Patient added sucessfully!");
	}

    /***
     * Register a new doctor
     * @param doctor
     */
	public void registerDoctor(Doctor doctor) {
		doctors.add(doctor);
		System.out.println("Doctor added sucessfully!");
	}

    /***
     * Book an appointment for a patient
     * @param patient
     * @return Appointment
     */

	public Appointment bookAppointment(Patient patient) {
			if (patient == null) {
			throw new InvalidAppointmentException("Invalid patient");
		}

		Doctor doctor=null;
		doctor=doctors.stream().filter(Doctor::isAvailable).findFirst().get();
		Appointment appointment = new Appointment(patient, doctor);
        appointments.add(appointment);
        System.out.println("Appointment booked successfully with Dr. " + doctor.getName());
        return appointment;
    }

    /***
     * Complete an appointment
     * @param index
     */
	public void completeAppointment(int index) {
			if (index < 0 || index >= appointments.size()) {
				throw new InvalidAppointmentException("Invalid appointment index");
			}
			for (int i = 0; i < appointments.size(); i++) {
				if (i == index && appointments.get(i).getStatus().equals("Scheduled")) {
					appointments.get(i).completedAppointment();
					System.out.println("Appointment completed successfully.");
					return;
				}
			}
			throw new InvalidAppointmentException("Invalid appointment index or already completed");
	}

    /***
     * Show all doctors
     */

	public void showAllDoctors() {
		
			if(doctors.isEmpty()) {
				throw new EmptyValueException("No doctors available");
			}else {
				System.out.println("--------------------------------");
				//Using method reference to refer to the showProfile() method of the Doctor Class
				doctors.forEach(Doctor::showProfile);
				System.out.println("--------------------------------");
			}
	}


	/***
	 * Show all patients
	 */
	public void showAllPatients(){
			if(patients.isEmpty()) {
				throw new EmptyValueException("No Patients available");
			}
			else {
				System.out.println("--------------------------------");
				//Using Method Reference to refer to showProfile() method of the Patient Class
				patients.forEach(Patient::showProfile);
				System.out.println("--------------------------------");
			}
	}

    /***
     * Show all appointments
     */
	public void showAllAppointments() {
			if(appointments.isEmpty()) {
				throw new EmptyValueException("No appointments found");
			}else {
				System.out.println("--------------------------------");
				//Using Method Reference to refer to appointmentDetails() method of the Appointment Class
				appointments.forEach(Appointment::appointmentDetails);
				System.out.println("--------------------------------");
			}
	}	
}

