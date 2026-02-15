package management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import db.DBConnection;

public class Patient {

	private static int idcounter = 0;
	private int id;
	private String name;
	private String gender;
	private int age;
	
	
	// constructors are setter (that not contain return type)
	public Patient(String name, String gender, int age) // local variables
	{
		this.id = ++idcounter;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
			
	public void saveToDB() {
		try {
			Connection con = DBConnection.getConnection();
			String query = "Insert Into Patients(name, gender, age) values(?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setString(2, gender);
			ps.setInt(3, age);
			ps.executeUpdate();
			
			var rs = ps.getGeneratedKeys();
			if(rs.next()) id = rs.getInt(1);
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
	}
	public int getId() {
		return id;
		}
	
	// ovveride the tostring method
	public String toString()
	{
		return ("Patient_ID: "+id+" ,Patient_Name: "+name+" ,Patient_Gender: "+gender+" ,Patient_Age: "+age);
	}
	
}
