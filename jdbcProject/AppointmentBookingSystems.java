package jdbcProject;

import java.util.Scanner;



public class AppointmentBookingSystems {
	
	public static void printmenu() {
		System.out.println("\n1. Appointment creation");
		System.out.println("2. Remove the Appointment");
		System.out.println("3. Update the Appointment");
		System.out.println("4. Display All the Appointment");
		System.out.println("5. Search the Appointment");
		System.out.println("6. Exit");
		System.out.println("\nEnter the choice:");
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("\t\t\tAppointment Booking System");
		
		while(true) {
			printmenu();
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				Appointments.toCreateAppointment();
				break;
			case 2:
				Appointments.toRemoveAppointment();
				break;
			case 3:
				Appointments.toUpdateAppointment();
				break;
			case 4:
				Appointments.toDisplayAppointment();
				break;
			case 5:
				Appointments.toSearchAppointment();
				break;
			case 6:
				System.out.println("application exited!!!");
				input.close();
				return;
			default:
				System.out.println("enter a valid choice: ");
			}
		}
	}
}
