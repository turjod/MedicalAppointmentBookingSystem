package MedicalAppointmentBookingSystem.service;

import com.cg.MedicalAppointmentBookingSystem.entities.Appointment;
import com.cg.MedicalAppointmentBookingSystem.entities.Doctor;
import com.cg.MedicalAppointmentBookingSystem.entities.Patient;
import com.cg.MedicalAppointmentBookingSystem.service.Impl.AppointmentSystemImpl;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class AppointmentSystemTest {

    static AppointmentSystemImpl appointmentSystem;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.err;

    @BeforeAll
    public static void setUp() {
        appointmentSystem = AppointmentSystemImpl.getInstance();
    }

    @BeforeEach
    public void init() {
        appointmentSystem.registerPatient(new Patient("P001", "John Doe"));
        appointmentSystem.registerPatient(new Patient("P002", "Mark Jones"));
        appointmentSystem.registerPatient(new Patient("P005", "Jupiter Smith"));

        appointmentSystem.registerDoctor(new Doctor("D001", "Dr. Smith"));
        appointmentSystem.registerDoctor(new Doctor("D002", "Dr. Bean"));
        appointmentSystem.registerDoctor(new Doctor("D003", "Dr. Milo"));

        appointmentSystem.bookAppointment(appointmentSystem.getPatients().get(0));
        appointmentSystem.bookAppointment(appointmentSystem.getPatients().get(1));


        System.setErr(new PrintStream(outContent));
    }

    @Test
    public void testRegisterPatient_Pass() {
        Patient patient = new Patient("P003", "A man");
        appointmentSystem.registerPatient(patient);
        assert appointmentSystem.getPatients().contains(patient);
    }
    
    
    @Test
    public void testRegisterPatient_Fail() {
        Patient patient = new Patient("P008", "A Dog");
        try {
            assert appointmentSystem.getPatients().contains(patient);
            Assertions.fail("Expected an AssertionError to be thrown");
        } catch (AssertionError e) {
            
        }
    }


    @Test
    public void testRegisterDoctor_Pass() {
        Doctor doctor = new Doctor("D001", "Dr. Faustus");
        appointmentSystem.registerDoctor(doctor);
        assert appointmentSystem.getDoctors().contains(doctor);
    }

    @Test
    public void testRegisterDoctor_Fail() {
        Doctor doctor = new Doctor("D001", "Dr. Faustus");
        try {
            assert appointmentSystem.getDoctors().contains(doctor);
            Assertions.fail("Expected an AssertionError to be thrown");
        } catch (AssertionError e) {

        }
    }

    @Test
    public void testBookAppointment_Pass() {
        Patient patient = appointmentSystem.getPatients().get(0);
        Appointment appointment = appointmentSystem.bookAppointment(patient);
        assert appointment != null;
        assert appointment.getStatus().equals("Scheduled");
    }

    @Test
    public void testBookAppointment_Fail_With_Null() {
        Patient patient = null;
        Appointment appointment = appointmentSystem.bookAppointment(patient);
        Assertions.assertNull(appointment);
    }

    @Test
    public void testBookAppointment_Fail_InvalidAppointmentException() {
        Patient patient = null;
        appointmentSystem.bookAppointment(patient);
        String expectedOutput = "Error: Invalid patient";
        boolean value = outContent.toString().trim().contains(expectedOutput);
        Assertions.assertTrue(value);
    }

    @Test
    public void testCompleteAppointment() {
        Patient patient = appointmentSystem.getPatients().get(2);
        Appointment appointment = appointmentSystem.bookAppointment(patient);
        appointmentSystem.completeAppointment(2);
        Assertions.assertEquals("Completed", appointment.getStatus());
    }

    @Test
    public void testCompleteAppointment_Invalid_Index() {
        appointmentSystem.completeAppointment(-1);
        String expectedOutput = "Error: Invalid appointment index";
        boolean value = outContent.toString().trim().contains(expectedOutput);
        Assertions.assertTrue(value);
    }

    @Test
    public void testCompleteAppointment_Already_Completed() {
        appointmentSystem.completeAppointment(0);
        appointmentSystem.completeAppointment(0);
        String expectedOutput = "Error: Invalid appointment index or already completed";
        boolean value = outContent.toString().trim().contains(expectedOutput);
        Assertions.assertTrue(value);
    }

    @Test
    public void showAllPatients_Pass() {
        appointmentSystem.showAllPatients();
        Assertions.assertEquals(3, appointmentSystem.getPatients().size());
    }

    @Test
    public void showAllPatients_Fail() {
        appointmentSystem.getPatients().clear();
        appointmentSystem.showAllPatients();
        String expectedOutput = "No Patients available";
        boolean value = outContent.toString().trim().contains(expectedOutput);
        Assertions.assertTrue(value);
    }

    @Test
    public void showAllDoctors() {
        appointmentSystem.showAllDoctors();
        Assertions.assertEquals(3, appointmentSystem.getDoctors().size());
    }

    @Test
    public void showAllDoctors_Fail() {
        appointmentSystem.getDoctors().clear();
        appointmentSystem.showAllDoctors();
        String expectedOutput = "No doctors available";
        boolean value = outContent.toString().trim().contains(expectedOutput);
        Assertions.assertTrue(value);
    }

    @Test
    public void showAllAppointments() {
        appointmentSystem.showAllAppointments();
        Assertions.assertEquals(2, appointmentSystem.getAppointments().size());
    }

    @Test
    public void showAllAppointments_Fail() {
        appointmentSystem.getAppointments().clear();
        appointmentSystem.showAllAppointments();
        String expectedOutput = "No appointments found";
        boolean value = outContent.toString().trim().contains(expectedOutput);
        Assertions.assertTrue(value);
    }

    @AfterEach
    public void tearDown() {
        appointmentSystem.getPatients().clear();
        appointmentSystem.getDoctors().clear();
        appointmentSystem.getAppointments().clear();

        System.setOut(originalOut);
    }
}