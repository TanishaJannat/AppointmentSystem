package OOPLabFinal;

public class Appointment {
    private String date;
    private String time;
    private Doctor doctor;
    private Patient patient;

    public Appointment(String date, String time, Doctor doctor, Patient patient) {
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment on " + date + " at " + time + " with Dr. " + doctor.getName() + " for patient " + patient.getName();
    }
}
