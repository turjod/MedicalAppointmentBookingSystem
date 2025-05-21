package com.cg.MedicalAppointmentBookingSystem.ui;

import java.util.*;

import com.cg.MedicalAppointmentBookingSystem.entities.Admin;
import com.cg.MedicalAppointmentBookingSystem.entities.Doctor;
import com.cg.MedicalAppointmentBookingSystem.entities.Patient;
import com.cg.MedicalAppointmentBookingSystem.exceptions.*;
import com.cg.MedicalAppointmentBookingSystem.service.Impl.AppointmentSystemImpl;

/**
 *
 * This is the main driver class for the Medical Appointment Booking System.
 * It provides a command-line interface for users to interact with the system.
 * Users can register patients and doctors, book appointments, view all doctors,
 * patients, and appointments, complete appointments, and remove doctors (admin only).
 *
 * @author Turjo
 * @author Dipanjan
 * @author Subhranil
 */
public class Driver {
	/*
	 * The main method serves as the entry point for the application. It initializes
	 * the system, displays the menu, and handles user input.
	 */
	public static void main(String[] args) {

		/*
		 * The following code initializes the system and creates a list of admins. It
		 * also creates a default admin user with ID "A001", name "admin", and password
		 * "admin".
		 */
		String name = "";
		String id = "";
		List<Admin> admins = new ArrayList<>();
		admins.add(new Admin("A001", "admin", "admin"));

		/*
		 * The following code creates a Scanner object to read user input from the
		 * console. It also initializes a boolean flag to control the main menu loop.
		 */

		Scanner sc = new Scanner(System.in);
		/*
		 * The following code displays the main menu and handles user input. It provides
		 * options for adding a super user, registering patients and doctors, booking
		 * appointments, showing all doctors, patients, and appointments, completing
		 * appointments, removing doctors (admin only), and exiting the program.
		 */
		
		// Create an instance of AppointmentSystemImpl
		// to access the appointment system functionality
		// This is a singleton instance, so it will be the same throughout the application
		// This ensures that the appointment system is initialized and ready to use
		// The AppointmentSystemImpl class is responsible for managing appointments,
		AppointmentSystemImpl appointmentSystem = AppointmentSystemImpl.getInstance();
		while (true) {
			System.out.println("Welcome to Medical Appointment Booking System");
			System.out.println("0. Add Super User: ");
			System.out.println("1. Register Patient: ");
			System.out.println("2. Register Doctor: ");
			System.out.println("3. Book Appointment: ");
			System.out.println("4. Show All Doctors: ");
			System.out.println("5. Show All Patients: ");
			System.out.println("6. Show All Appointments: ");
			System.out.println("7. Complete Appointment: ");
			System.out.println("8. Remove Doctor (Admin Only): ");
			System.out.println("9. Exit: ");
			System.out.print("Enter Your Choice: ");
			try {
			int choice = sc.nextInt();
			sc.nextLine();

			/*
			 * The following code handles the user's choice and performs the corresponding
			 * action. It uses a switch statement to determine which action to take based on
			 * the user's input.
			 */

			// Handle user input based on the choice

			switch (choice) {
			case 0:
				// Add Super User
				// This option allows the admin to create a new super user
				// The super user has administrative privileges to manage the system
				// The user is prompted to enter the ID, name, and password for the new super
				// user
				
				String admin_id;
				try {
					// Prompt the user for super user details
					System.out.print("Enter Admin ID: ");
					admin_id = sc.nextLine();
					// Check if the ID is empty
					// If it is empty, throw an exception
					if (admin_id.isEmpty()) {
						throw new EmptyValueException("ID cannot be empty! ");
					}
					
					// Check if the ID already exists in the list of admins
					Admin existing_admin=admins.stream().filter(a->a.getId().equals(admin_id)).findFirst().orElse(null);
					if(existing_admin!=null) {
						throw new IdAlreadyExistsException("This Admin ID already exists!");
					}
					
					System.out.print("Enter Admin Name: ");
					name = sc.nextLine();
					if (name.isEmpty()) {
						throw new EmptyValueException("Name cannot be empty! ");
					}
					// Check if the name contains only letters
					System.out.print("Enter Admin Password: ");
					String password = sc.nextLine();
					if (password.isEmpty()) {
						throw new EmptyValueException("Password cannot be empty! ");
					}
					// Check if the password is valid
					Admin admin = new Admin(admin_id, name, password);
					admins.add(admin);
					System.out.println("Super User Created Successfully!");
				} catch (EmptyValueException e) {
					System.err.println("Error: " + e.getMessage());
					break;
				} catch (IdAlreadyExistsException e) {
					System.err.println("Error: " + e.getMessage());
					break;
				}
				break;

			case 1:
				// Register Patient
				// This option allows the user to register a new patient
				// Check if the ID already exists in the list of patients
				// If it does, throw an exception
				// Prompt the user for patient details
				String patient_id;
				
				try {
					System.out.print("Enter Id For New Patient: ");
					patient_id = sc.nextLine();

					if (patient_id.isEmpty()) {
						throw new EmptyValueException("ID cannot be empty! ");
					}
					
					Patient patient=appointmentSystem.getPatients().stream().filter(p->p.getId().equals(patient_id)).findFirst().orElse(null);
					if(patient!=null) {
						throw new IdAlreadyExistsException("This Patient ID already Exists!");
					}
				} catch (EmptyValueException e) {
					System.err.println("Error: " + e.getMessage());
					break;
				} catch (IdAlreadyExistsException e) {
					System.err.println("Error: " + e.getMessage());
					break;
				}
				
				try {
					System.out.println("Enter Name of new Patient: ");
					name = sc.nextLine();

					if (name.isEmpty()) {
						throw new InvalidNameException("Name cannot be empty! ");
					}

					boolean letters = true;

					if (!name.isEmpty()) {
						for (char c : name.toCharArray()) {
							if (!Character.isLetter(c)) {
								letters = false;
								break;
							}
						}
					}

					if (!letters) {
						throw new InvalidNameException("Name must contain only letters.");
					}
				} catch (InvalidNameException e) {
					System.err.println("Error: " + e.getMessage());
					break;
				}
				// Create a new Patient object with the provided ID and name
				// and register it with the appointment system

				Patient patient = new Patient(patient_id, name);
				appointmentSystem.registerPatient(patient);
				break;

			case 2:
				// Register Doctor
				// This option allows the user to register a new doctor
				// The user is prompted to enter the ID and name for the new doctor
				// Check if the ID already exists in the list of doctors
				// If it does, throw an exception
				String doctor_id;
				
				try {
					System.out.print("Enter Id For New Doctor: ");
					doctor_id = sc.nextLine();

					if (doctor_id.isEmpty()) {
						throw new EmptyValueException("ID cannot be empty! ");
					}
					
					Doctor doctor=appointmentSystem.getDoctors().stream().filter(d->d.getId().equals(doctor_id)).findFirst().orElse(null);
					if(doctor!=null) {
						throw new IdAlreadyExistsException("This Doctor ID already Exists!");
					}
					
				} catch (EmptyValueException e) {
					System.err.println("Error: " + e.getMessage());
					break;
				} catch (IdAlreadyExistsException e) {
					System.err.println("Error: " + e.getMessage());
					break;
				}

				try {
					System.out.println("Enter Name of new Doctor: ");
					name = sc.nextLine();

					if (name.isEmpty()) {
						throw new InvalidNameException("Name cannot be empty! ");
					}

					boolean letters = true;

					if (!name.isEmpty()) {
						for (char c : name.toCharArray()) {
							if (!Character.isLetter(c)) {
								letters = false;
								break;
							}
						}
					}

					if (!letters) {
						throw new InvalidNameException("Name must contain only letters.");
					}
				} catch (InvalidNameException e) {
					System.err.println("Error: " + e.getMessage());
					break;
				}
				// Create a new Doctor object with the provided ID and name
				// and register it with the appointment system
				// The Doctor class represents a doctor in the system
				// The registerDoctor method adds the doctor to the list of doctors
				// in the appointment system
				Doctor doctor = new Doctor(doctor_id, name);
				appointmentSystem.registerDoctor(doctor);
				break;

			case 3:
				// Book Appointment
				// This option allows the user to book an appointment for a patient
				// The user is prompted to enter the ID of the patient for whom the appointment
				// is being booked
				// Check if the ID exists in the list of patients
				// If it does, book the appointment for that patient
				// If it doesn't, display an error message
				// The bookAppointment method adds the appointment to the list of appointments
				// in the appointment system

				try {
					System.out.print("Enter patient ID for booking appointment: ");
					String inputId = sc.nextLine();
					
					List<Patient>patients=appointmentSystem.getPatients();
					patient=patients.stream().filter(p->p.getId().equals(inputId)).findFirst().orElse(null);
					if(patient == null) {
						throw new InvalidAppointmentException("Patient not found!");
					}
					else {
						appointmentSystem.bookAppointment(patient);
					}
					
				} catch (InvalidAppointmentException e) {
					System.err.println("Error: " + e.getMessage());
				} 

				break;

			// Show All Doctors
			case 4:
				try {
					appointmentSystem.showAllDoctors();
				} catch (EmptyValueException e) {
					System.err.println("Error: " + e.getMessage());
				}
				break;
			// Show All Patients
			case 5:
				try {
					appointmentSystem.showAllPatients();
				} catch (EmptyValueException e) {
					System.err.println("Error: " + e.getMessage());
				}
				break;
			// Show All Appointments
			case 6:
				try {
					appointmentSystem.showAllAppointments();
				} catch (EmptyValueException e) {
					System.err.println("Error: " + e.getMessage());
				}
				break;
			// Complete Appointment
			case 7:
				try {
					System.out.println("Enter Index For Complete Appointment: ");
					int index = sc.nextInt();
					sc.nextLine();
					appointmentSystem.completeAppointment(index);
				} catch (InvalidAppointmentException e) {
					System.err.println("Error: " + e.getMessage());
				} catch (InputMismatchException e1) {

					System.err.println("Wrong input provided");
				}
				break;
			// Remove Doctor (Admin Only)
			case 8:
				System.out.println("Enter Admin ID: ");
				String adminId = sc.nextLine();

				System.out.println("Enter Admin Password: ");
				String inputPass = sc.nextLine();
				Admin admin = null;
				
				// Check if the admin ID and password are valid
				
				Admin checkAdmin=admins.stream().filter(ad->ad.getId().equals(adminId)).findFirst().orElse(null);
				
				if(checkAdmin != null && checkAdmin.verifyPassword(inputPass)){
					admin=checkAdmin;
				}
				
				try {
					if (admin == null) {
						throw new AdminNotFoundException("Unauthorized: Not an admin.");
					}

					// Prompt the admin for the ID of the doctor to be removed
					System.out.print("Enter Doctor ID to remove: ");
					String removeId = sc.nextLine();
				
					admin.removeDoctor(appointmentSystem.getDoctors(), removeId);
				} catch (AdminNotFoundException e) {
					System.err.println("Error: " + e.getMessage());
				}
				break;

			case 9:
				System.out.println("\nThank you for using our Service!");
				sc.close();
				System.exit(0);

			default:
				System.err.println("Invalid Choice!");
			}
		}catch(InputMismatchException c){
			System.err.println("Invalid Input provided. PLease Provide Correct Input.");
			sc.next();
		}
		}
	}
}
