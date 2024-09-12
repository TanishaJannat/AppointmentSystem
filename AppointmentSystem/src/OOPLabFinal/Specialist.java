package OOPLabFinal;

public class Specialist extends Doctor {
    public Specialist(String name, String specialization) {
        super(name, specialization);
    }

    @Override
    public void displayAvailability() {
        System.out.println("Specialist " + getName() + " (" + getSpecialization() + ") requires appointment confirmation.");
    }
}
