package jdbcProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import jdbcApplication.DbOperations;




class Appointments{
	int appointmentId;
	String custName;
	String serviceType;
	Long costValue;
	String status;
	
	
	 
	 public static void toCreateAppointment() {
		 System.out.println("Creating New Appointment\n");
		 Appointments appointmentData = new Appointments();
		 Scanner input = new Scanner(System.in);
	
		 
		 System.out.println("CustomerName: ");
		 appointmentData.custName = input.next();
		 
		 System.out.println("ServiceType: ");
		 appointmentData.serviceType = input.next();
		 
		 System.out.println("CostValue: ");
		 appointmentData.costValue = input.nextLong();
		 
		 System.out.println("Status: ");
		 appointmentData.status = input.next();
		 
		 
		 DbAppointments.toAddAppointment(appointmentData);
		 
	 }
	 public static void toRemoveAppointment() {
		 System.out.println("Remove the Appointment\n");
		 Scanner input = new Scanner(System.in);
		 System.out.println("Enter an ID to be Removed: ");
		 int id = input.nextInt();
		 
		 if(DbAppointments.appointmentExists(id)) {
			 DbAppointments.toRemoveAppointment(id);
			 System.out.println("Appointment " + id + " is Removed Successfully!!!");
		 }
		 else {
			 System.err.println("Appointment " + id + " is not exist!!!");
		 }
	 }
	 public static void toUpdateAppointment() {
		 System.out.println("Update the Appointment\n");
			Scanner input = new Scanner(System.in);
			
			System.out.println("Enter an Id to be Updated");
			int id = input.nextInt();
			if (DbAppointments.appointmentExists(id)) {
				System.out.println("1. Update CustomerName");
				System.out.println("2. Update ServiceType");
				System.out.println("3. Update CostValue");
				System.out.println("4. Update Status");
				int choice = input.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter update CustomerName: ");
					DbAppointments.toUpdateName(id, input.next());
					System.out.println("CustomerName is updated Suddessfully!!!");
					break;
				case 2:
					System.out.println("Enter update ServiceType: ");
					DbAppointments.toUpdateServiceType(id, input.next());
					System.out.println("ServiceType is updated Suddessfully!!!");
					break;
				case 3:
					System.out.println("Enter update CostValue: ");
					DbAppointments.toUpdateCostValue(id, input.nextLong());
					System.out.println("CostValue is updated Suddessfully!!!");
					break;
				case 4:
					System.out.println("Enter Status: ");
					DbAppointments.toUpdateStatus(id, input.next());
					System.out.println("Status is updated Suddessfully!!!");
					break;
				default:
					System.out.println("Enter a valid choice!!!");
					break;
					
				}
				
			}
			else {
				System.err.println("Appointment " + id + " is not exist!!!");
			}
			
		}
	 
	 public static void toDisplayAppointment() {
		 HashMap<Integer, Appointments>appointmentDatabase = DbAppointments.toGetAllAppointmentData();
		 System.out.println("Display the Appointment\n");
		 System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("Id \t\t CustomerName \t ServiceType \t CostValue \t Status");
			System.out.println("-------------------------------------------------------------------------------------");
			for (Map.Entry<Integer, Appointments> appointmentEntry : appointmentDatabase.entrySet()) {
				System.out.print(appointmentEntry.getKey() + "\t\t");
				System.out.print(appointmentEntry.getValue().custName + "\t\t");
				System.out.print(appointmentEntry.getValue().serviceType + "\t\t");
				System.out.print(appointmentEntry.getValue().costValue + "\t\t");
				System.out.println(appointmentEntry.getValue().status);
				System.out.println("-------------------------------------------------------------------------------------");
			}
	 }
	 public static void toSearchAppointment() {
		 System.out.println("Search the Appointment\n");
		 Scanner input = new Scanner(System.in);
			
			System.out.println("Enter an ID to be Searched: ");
			int id = input.nextInt();
			
			if(DbAppointments.appointmentExists(id)) {
				Appointments appointmentObj = DbAppointments.toSearchAppointment(id);
				System.out.println("appointment ID           : " + appointmentObj.appointmentId);
				System.out.println("appointment Name         : " + appointmentObj.custName);
				System.out.println("appointment serviceType   : " + appointmentObj.serviceType);
				System.out.println("appointment Grade        : " + appointmentObj.costValue);
				System.out.println("appointment costValue: " + appointmentObj.status);
				System.out.println("Appointment Data printed successfully!!!");
			}
			else {
				System.err.println("Appointment " + id + " is not exist!!!");
			}
			
		}
	 }
	 
