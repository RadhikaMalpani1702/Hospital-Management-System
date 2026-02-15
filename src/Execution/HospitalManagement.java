package Execution;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;


import management.Doctor;
import management.Patient;
import management.Appointment;

public class HospitalManagement {
	
	private static ArrayList <Patient> patients = new ArrayList<>();
	private static ArrayList <Doctor> doctors = new ArrayList<>();
	private static ArrayList <Appointment> appointments = new ArrayList<>();

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("\n\n++++++++++++ HOSPITAL MANAGEMENT SYSTEM ++++++++++++\n\n");
			System.out.println("1. Add Patient");
			System.out.println("2. Add Doctor");
			System.out.println("3. Schedule Appoimtment");
			System.out.println("4. View Patients");
			System.out.println("5. View Doctors");
			System.out.println("6. View Appointment");
			System.out.println("0. Exit");
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				addPatient(sc);
			break;
			case 2: 
				addDoctor(sc);
			break;
			case 3:
				scheduleAppointment(sc);
			break;
			case 4:
				viewPatient();
			break;
			case 5:
				viewDoctor();
			break;
			case 6:
				viewAppointment();
			break;
			case 0:
				System.out.println("Exiting...");
			break;
			default:
				System.out.println("INVALID CHOICE. PLEASE TRY AGAIN.");
			break;
			}
		}while(choice !=0);
	}
	
	// -----------Methods-----------
	private static void addPatient(Scanner sc)  // -----------addpatient-----------
	{
		sc.nextLine();
		System.out.println("Enter Patient Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Patient Gender: ");
		String gender = sc.next();
		System.out.println("Enter Patient age: ");
		int age = sc.nextInt();
		
		Patient patient = new Patient(name, gender, age);
		patient.saveToDB();
		patients.add(patient);
		System.out.println("Patient Addeded Succefully."); 
	}
	private static void addDoctor(Scanner sc)               // -------------adddoctor------------
	{
		sc.nextLine();
		System.out.println("Enter Doctor Name:  ");
		String name = sc.nextLine();
		System.out.println("Enter Speciality: ");
		String specialist = sc.nextLine();
		
		Doctor doctor = new Doctor(name, specialist);
		doctor.saveToDB();
		doctors.add(doctor);
		System.out.println("Doctor Addeded Succefully.");
	}
	private static void scheduleAppointment(Scanner sc)  // ------------scheduleAppointment-------------
	{
		
		if(patients.isEmpty() || doctors.isEmpty())
		{
			System.out.println("Add patient and doctor first.");
			return;
		}
		
		System.out.println("Select Patient Index:");
		for(int i=0; i<patients.size(); i++)
		{
			System.out.println(i+" : "+patients.get(i));
		}
		
		int pIndex = sc.nextInt();
		
		System.out.println("Select Doctor Index:");
		for(int i=0; i<doctors.size(); i++)
		{
			System.out.println(i+" : "+doctors.get(i));
		}
		int dIndex = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("Enter Appointment Date (YYYY-MM-DD): ");
		String dateInput = sc.next();
		
		LocalDate date = LocalDate.parse(dateInput);
		
		Appointment appointment = new Appointment(patients.get(pIndex), doctors.get(dIndex), date);
		appointment.saveToDB();
		appointments.add(appointment);
		System.out.println("Appointments scheduled successfully.");
	}
	
	private static void viewPatient()  // --------------viewpatient----------------
	{
		for(Patient p : patients)
			System.out.println(p);
	}
	private static void viewDoctor() // --------------viewDoctor----------------
	{
		for(Doctor d : doctors)
			System.out.println(d);
	}
	private static void viewAppointment() // --------------viewAppointment----------------
	{
		for(Appointment a : appointments)
			System.out.println(a);
	}
	
	

}

