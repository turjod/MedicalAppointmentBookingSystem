//package com.cg.MedicalAppointmentBookingSystem.ui;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
//import java.io.PrintStream;
//
//public class DriverTest {
//
//    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//    private final PrintStream originalErr = System.err;
//    private final InputStream originalIn = System.in;
//
//    @BeforeEach
//    public void setUp() {
//        System.setOut(new PrintStream(outputStream));
//        System.setErr(new PrintStream(outputStream));
//    }
//
//    @Test
//    public void testMain_Adding_New_Admin() {
//        String standardInput = "0\nA005\nraj\nraj123\n9\n";
//        ByteArrayInputStream input = new ByteArrayInputStream(standardInput.getBytes());
//        System.setIn(input);
//        Driver.main(new String[]{});
//        String output = outputStream.toString().trim();
//        String expected = "Super User Created Successfully!\n"+
//                "Welcome to Medical Appointment Booking System\n" +
//                "0. Add Super User: \n" +
//                "1. Register Patient: \n" +
//                "2. Register Doctor: \n" +
//                "3. Book Appointment: \n" +
//                "4. Show All Doctors: \n" +
//                "5. Show All Patients: \n" +
//                "6. Show All Appointments: \n" +
//                "7. Complete Appointment: \n" +
//                "8. Remove Doctor (Admin Only): \n" +
//                "9. Exit: \n" +
//                "Enter Your Choice: \n" +
//                "Thank you for using our Service!";
//        Assertions.assertTrue(output.contains(expected));
//    }
//
//    @Test
//    public void testMain_Adding_New_Patient() {
//        String standardInput = "1\nP005\nRajdeep\n9\n";
//        ByteArrayInputStream input = new ByteArrayInputStream(standardInput.getBytes());
//        System.setIn(input);
//        Driver.main(new String[]{});
//        String output = outputStream.toString().trim();
//        String expected = "Patient added sucessfully!\n"+
//                "Welcome to Medical Appointment Booking System\n" +
//                "0. Add Super User: \n" +
//                "1. Register Patient: \n" +
//                "2. Register Doctor: \n" +
//                "3. Book Appointment: \n" +
//                "4. Show All Doctors: \n" +
//                "5. Show All Patients: \n" +
//                "6. Show All Appointments: \n" +
//                "7. Complete Appointment: \n" +
//                "8. Remove Doctor (Admin Only): \n" +
//                "9. Exit: \n" +
//                "Enter Your Choice: \n" +
//                "Thank you for using our Service!";
//        Assertions.assertTrue(output.contains(expected));
//    }
//
//    @Test
//    public void testMain_Adding_New_Doctor() {
//        String standardInput = "2\nD005\nGOD\n9\n";
//        ByteArrayInputStream input = new ByteArrayInputStream(standardInput.getBytes());
//        System.setIn(input);
//        Driver.main(new String[]{});
//        String output = outputStream.toString().trim();
//        String expected = "Doctor added sucessfully!\n"+
//                "Welcome to Medical Appointment Booking System\n" +
//                "0. Add Super User: \n" +
//                "1. Register Patient: \n" +
//                "2. Register Doctor: \n" +
//                "3. Book Appointment: \n" +
//                "4. Show All Doctors: \n" +
//                "5. Show All Patients: \n" +
//                "6. Show All Appointments: \n" +
//                "7. Complete Appointment: \n" +
//                "8. Remove Doctor (Admin Only): \n" +
//                "9. Exit: \n" +
//                "Enter Your Choice: \n" +
//                "Thank you for using our Service!";
//        Assertions.assertTrue(output.contains(expected));
//    }
//
//    @Test
//    public void testMain_Booking_Appointment() {
//        String standardInput = "3\nP001\n9\n";
//        ByteArrayInputStream input = new ByteArrayInputStream(standardInput.getBytes());
//        System.setIn(input);
//        Driver.main(new String[]{});
//        String output = outputStream.toString().trim();
//        String expected = "No patient found!\n"+
//                "Welcome to Medical Appointment Booking System\n" +
//                "0. Add Super User: \n" +
//                "1. Register Patient: \n" +
//                "2. Register Doctor: \n" +
//                "3. Book Appointment: \n" +
//                "4. Show All Doctors: \n" +
//                "5. Show All Patients: \n" +
//                "6. Show All Appointments: \n" +
//                "7. Complete Appointment: \n" +
//                "8. Remove Doctor (Admin Only): \n" +
//                "9. Exit: \n" +
//                "Enter Your Choice: \n" +
//                "Thank you for using our Service!";
//        Assertions.assertTrue(output.contains(expected));
//    }
//
//    @Test
//    public void testMain_Remove_Doctor() {
//        String standardInput = "8\nA001\nadmin\nD001\n9\n";
//        ByteArrayInputStream input = new ByteArrayInputStream(standardInput.getBytes());
//        System.setIn(input);
//        Driver.main(new String[]{});
//        String output = outputStream.toString().trim();
//        String expected = "Doctor with ID D001 not found.\n"+
//                "Welcome to Medical Appointment Booking System\n" +
//                "0. Add Super User: \n" +
//                "1. Register Patient: \n" +
//                "2. Register Doctor: \n" +
//                "3. Book Appointment: \n" +
//                "4. Show All Doctors: \n" +
//                "5. Show All Patients: \n" +
//                "6. Show All Appointments: \n" +
//                "7. Complete Appointment: \n" +
//                "8. Remove Doctor (Admin Only): \n" +
//                "9. Exit: \n" +
//                "Enter Your Choice: \n" +
//                "Thank you for using our Service!";
//        Assertions.assertTrue(output.contains(expected));
//    }
//
//
//
//    @AfterEach
//    public void tearDown() {
//        System.setOut(originalOut);
//        System.setErr(originalErr);
//        System.setIn(originalIn);
//        outputStream.reset();
//    }
//
//}
//
////import com.cg.MedicalAppointmentBookingSystem.entities.*;
////import com.cg.MedicalAppointmentBookingSystem.exceptions.*;
////import com.cg.MedicalAppointmentBookingSystem.service.Impl.AppointmentSystemImpl;
////import com.cg.MedicalAppointmentBookingSystem.annotations.*;
////import org.junit.jupiter.api.BeforeEach;
////import org.junit.jupiter.api.Test;
////
////import java.util.List;
////
////import static org.junit.jupiter.api.Assertions.*;
////
////class DriverTest {
////
////    private AppointmentSystemImpl appointmentSystem;
////    private Driver driver;
////
////    @BeforeEach
////    void setUp() {
////        appointmentSystem = AppointmentSystemImpl.getInstance();
////        driver = new Driver();
////    }
////
////    @Test
////    void testRegisterPatient() {
////        // Simulate registering a new patient
////        String patientId = "P001";
////        String patientName = "John Doe";
////        Patient patient = new Patient(patientId, patientName);
////
////        // Register the patient
////        appointmentSystem.registerPatient(patient);
////
////        // Verify the patient was registered
////        List<Patient> patients = appointmentSystem.getPatients();
////        assertTrue(patients.contains(patient), "Patient should be registered");
////    }
////
////    @Test
////    void testRegisterDoctor() {
////        // Simulate registering a new doctor
////        String doctorId = "D001";
////        String doctorName = "Dr. Smith";
////        Doctor doctor = new Doctor(doctorId, doctorName);
////
////        // Register the doctor
////        appointmentSystem.registerDoctor(doctor);
////
////        // Verify the doctor was registered
////        List<Doctor> doctors = appointmentSystem.getDoctors();
////        assertTrue(doctors.contains(doctor), "Doctor should be registered");
////    }
////
////    @Test
////    void testBookAppointment() {
////        // First, register a patient and doctor
////        Patient patient = new Patient("P001", "John Doe");
////        Doctor doctor = new Doctor("D001", "Dr. Smith");
////        appointmentSystem.registerPatient(patient);
////        appointmentSystem.registerDoctor(doctor);
////
////        // Book the appointment for the patient
////        appointmentSystem.bookAppointment(patient);
////
////        // Verify the appointment was booked
////        assertEquals(1, appointmentSystem.getAppointments().size(), "Appointment should be booked");
////    }
////
////    @Test
////    void testShowAllDoctors() {
////        // Add doctors
////        Doctor doctor1 = new Doctor("D001", "Dr. Smith");
////        Doctor doctor2 = new Doctor("D002", "Dr. John");
////        appointmentSystem.registerDoctor(doctor1);
////        appointmentSystem.registerDoctor(doctor2);
////
////        // Show all doctors
////        List<Doctor> doctors = appointmentSystem.getDoctors();
////
////        // Assert that the list contains the doctors
////        assertTrue(doctors.contains(doctor1), "Doctors list should contain Dr. Smith");
////        assertTrue(doctors.contains(doctor2), "Doctors list should contain Dr. John");
////    }
////
////    @Test
////    void testShowAllPatients() {
////        // Add patients
////        Patient patient1 = new Patient("P001", "John Doe");
////        Patient patient2 = new Patient("P002", "Jane Doe");
////        appointmentSystem.registerPatient(patient1);
////        appointmentSystem.registerPatient(patient2);
////
////        // Show all patients
////        List<Patient> patients = appointmentSystem.getPatients();
////
////        // Assert that the list contains the patients
////        assertTrue(patients.contains(patient1), "Patients list should contain John Doe");
////        assertTrue(patients.contains(patient2), "Patients list should contain Jane Doe");
////    }
////
////    @Test
////    void testShowAllAppointments() {
////        // Add patient and doctor
////        Patient patient = new Patient("P001", "John Doe");
////        Doctor doctor = new Doctor("D001", "Dr. Smith");
////        appointmentSystem.registerPatient(patient);
////        appointmentSystem.registerDoctor(doctor);
////
////        // Book appointment
////        appointmentSystem.bookAppointment(patient);
////
////        // Show all appointments
////        assertEquals(1, appointmentSystem.getAppointments().size(), "There should be one appointment");
////    }
////
////    @Test
////    void testCompleteAppointment() {
////        // Add patient and doctor
////        Patient patient = new Patient("P001", "John Doe");
////        Doctor doctor = new Doctor("D001", "Dr. Smith");
////        appointmentSystem.registerPatient(patient);
////        appointmentSystem.registerDoctor(doctor);
////
////        // Book appointment
////        appointmentSystem.bookAppointment(patient);
////
////        // Complete the appointment
////        appointmentSystem.completeAppointment(0);
////
////        // Assert that the appointment is completed
////        assertEquals("Completed",appointmentSystem.getAppointments().get(0).getStatus(), "The appointment should be completed");
////    }
////
////    @Test
////    void testRemoveDoctor() {
////        // Add admin and doctor
////        Admin admin = new Admin("A001", "admin", "admin");
////        Doctor doctor = new Doctor("D001", "Dr. Smith");
////        appointmentSystem.registerDoctor(doctor);
////
////        // Simulate removing doctor
////        admin.removeDoctor(appointmentSystem.getDoctors(), doctor.getId());
////
////        // Verify doctor removal
////        assertFalse(appointmentSystem.getDoctors().contains(doctor), "Doctor should be removed");
////    }
////
////    @Test
////    void testInvalidPatientId() {
////        // Try to register a patient with an empty ID
////        try {
////            Patient patient = new Patient("", "John Doe");
////            appointmentSystem.registerPatient(patient);
////            fail("Patient registration should have thrown an exception for empty ID");
////        } catch (EmptyValueException e) {
////            // Expected exception
////            assertEquals("ID cannot be empty! ", e.getMessage());
////        }
////    }
////
////    @Test
////    void testInvalidDoctorName() {
////        // Try to register a doctor with an empty name
////        try {
////            Doctor doctor = new Doctor("D001", "");
////            appointmentSystem.registerDoctor(doctor);
////            fail("Doctor registration should have thrown an exception for empty name");
////        } catch (EmptyValueException e) {
////            // Expected exception
////            assertEquals("Name cannot be empty! ", e.getMessage());
////        }
////    }
////}