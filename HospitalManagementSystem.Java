
import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int patientId;
    String name;
    int age;
    String disease;

    Patient(int patientId, String name, int age, String disease) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
                ", Name: " + name +
                ", Age: " + age +
                ", Disease: " + disease;
    }
}

public class HospitalManagementSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(id, name, age, disease));

        System.out.println("Patient Added Successfully!");
    }

    public static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
            return;
        }

        System.out.println("\n===== PATIENT RECORDS =====");

        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    public static void searchPatient() {
        System.out.print("Enter Patient ID to Search: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.patientId == id) {
                System.out.println("\nPatient Found:");
                System.out.println(p);
                return;
            }
        }

        System.out.println("Patient Not Found.");
    }

    public static void deletePatient() {
        System.out.print("Enter Patient ID to Delete: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.patientId == id) {
                patients.remove(p);
                System.out.println("Patient Deleted Successfully!");
                return;
            }
        }

        System.out.println("Patient Not Found.");
    }

    public static void totalPatients() {
        System.out.println("Total Patients: " + patients.size());
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==================================");
            System.out.println("     HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Total Patients");
            System.out.println("6. Exit");
            System.out.println("==================================");

            System.out.print("Choose Option: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    searchPatient();
                    break;

                case 4:
                    deletePatient();
                    break;

                case 5:
                    totalPatients();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}