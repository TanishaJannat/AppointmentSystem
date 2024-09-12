package OOPLabFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClinicManagementSystem {
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Done");
    }

    public void registerPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient registered: " + patient.getName());
    }

    public void bookAppointment(String patientId, String doctorName, String date, String time) {
        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorByName(doctorName);
        if (patient != null && doctor != null) {
            Appointment appointment = new Appointment(date, time, doctor, patient);
            appointments.add(appointment);
            System.out.println("Appointment booked: " + appointment);
        } else {
            System.out.println("Doctor or Patient not found.");
        }
    }

    private Patient findPatientById(String id) {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) return patient;
        }
        return null;
    }

    private Doctor findDoctorByName(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equals(name)) return doctor;
        }
        return null;
    }

    public void displayAllDoctors() {
        for (Doctor doctor : doctors) {
            doctor.displayAvailability();
        }
    }

    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No registered.");
        } else {
            System.out.println("Patient Details:");
            for (Patient patient : patients) {
                System.out.println("Name: " + patient.getName() + ", ID: " + patient.getId());
            }
        }
    }

    public static void main(String[] args) {
        ClinicManagementSystem system = new ClinicManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nClinic Management System Menu:");
            System.out.println("1. Add Doctor");
            System.out.println("2. Register Patient");
            System.out.println("3. Book Appointment");
            System.out.println("4. Display All Doctors");
            System.out.println("5. Display All Patients"); 
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter doctor's name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter specialization: ");
                    String specialization = scanner.nextLine();
                    system.addDoctor(new Specialist(doctorName, specialization));
                    break;
                case 2:
                    System.out.print("Enter patient's name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient's ID: ");
                    String patientId = scanner.nextLine();
                    system.registerPatient(new Patient(patientName, patientId));
                    break;
                case 3:
                    System.out.print("Enter patient ID: ");
                    String bookPatientId = scanner.nextLine();
                    System.out.print("Enter doctor name: ");
                    String bookDoctorName = scanner.nextLine();
                    System.out.print("Enter appointment date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter appointment time: ");
                    String time = scanner.nextLine();
                    system.bookAppointment(bookPatientId, bookDoctorName, date, time);
                    break;
                case 4:
                    system.displayAllDoctors();
                    break;
                case 5:
                    system.displayAllPatients();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting ");
                    break;
                default:
                    System.out.println("Please try again.");
            }
        }
        scanner.close();
    }
}
