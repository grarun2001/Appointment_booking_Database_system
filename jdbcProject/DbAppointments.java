package jdbcProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;






public class DbAppointments {
	private static final String host ="jdbc:mysql://localhost:3306/appointmentbookingdb";
	private static final String userName ="root";
	private static final String password ="8870021534arun";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(host, userName, password);
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
		public static void toAddAppointment(Appointments appointmentData) {
			try {
				Connection con = getConnection();
				String query = "Insert into appointments(custName, serviceType, costValue, status)" + 
								"values(?,?,?,?)";
				PreparedStatement stmt= con.prepareStatement(query);
				stmt.setString(1, appointmentData.custName);
				stmt.setString(2, appointmentData.serviceType);
				stmt.setLong(3, appointmentData.costValue);
				stmt.setString(4, appointmentData.status);
				
				stmt.executeUpdate();
				con.close();
				stmt.close();
				System.out.println("Appointment Creation successfull");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static HashMap<Integer, Appointments>toGetAllAppointmentData(){
			try {
				Connection con = getConnection();
				String query = "select * from appointments";
				PreparedStatement stmt = con.prepareStatement(query);
				ResultSet result = stmt.executeQuery();
				HashMap<Integer, Appointments>appointmentData = new HashMap<>();
				while(result.next()) {
					Appointments obj = new Appointments();
					obj.appointmentId= result.getInt(1);
					obj.custName= result.getString(2);
					obj.serviceType= result.getString(3);
					obj.costValue= result.getLong(4);
					obj.status= result.getString(5);
					appointmentData.put(obj.appointmentId, obj);
				}
				con.close();
				stmt.close();
				return appointmentData;
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		public static boolean appointmentExists(int id) {
			try {
				Connection con = getConnection();
				String query = "Select * from appointments where appointmentId=?";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, id);
				ResultSet result = stmt.executeQuery();
				boolean flag = result.next();
				con.close();
				return flag;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		public static void toRemoveAppointment(int id) {
			try {
				Connection con = getConnection();
				String query = "Delete from appointments where appointmentId = ?";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, id);
				stmt.executeUpdate();
				stmt.close();
				con.close();
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public static Appointments toSearchAppointment(int id) {


			
			try {
				Connection con = getConnection();
				String query = "Select * from appointments where appointmentId = ?";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, id);
				ResultSet result = stmt.executeQuery();
				Appointments appointmentData = new Appointments();
				result.next();
				appointmentData.appointmentId= result.getInt(1);
				appointmentData.custName= result.getString(2);
				appointmentData.serviceType= result.getString(3);
				appointmentData.costValue= result.getLong(4);
				appointmentData.status= result.getString(5);
				stmt.close();
				con.close();
				return appointmentData;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		public static void toUpdateName(int id, String name) {
			
			try {
				Connection con = getConnection();
				String query = "update appointments set custName = ? where appointmentId = ?";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, name);
				stmt.setInt(2, id);
				stmt.executeUpdate();
				stmt.close();
				con.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
		}
		public static void toUpdateServiceType(int id, String ServiceType) {
			
			try {
				Connection con = getConnection();
				String query = "update appointments set serviceType = ? where appointmentId = ?";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, ServiceType);
				stmt.setInt(2, id);
				stmt.executeUpdate();
				stmt.close();
				con.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
		}
		public static void toUpdateCostValue(int id, Long CostValue) {
			
			try {
				Connection con = getConnection();
				String query = "update appointments set costValue = ? where appointmentId = ?";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setLong(1, CostValue);
				stmt.setInt(2, id);
				stmt.executeUpdate();
				stmt.close();
				con.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
		}
		public static void toUpdateStatus(int id, String Status) {
			
			try {
				Connection con = getConnection();
				String query = "update appointments set status = ? where appointmentId = ?";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setString(1, Status);
				stmt.setInt(2, id);
				stmt.executeUpdate();
				stmt.close();
				con.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
		}
	}


	
