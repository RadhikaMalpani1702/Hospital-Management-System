package management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import db.DBConnection;

public class Doctor {

	private static int idcounter = 1;
	private int id;
	private String name;
	private String speciality;
	public Doctor(String name, String speciality)
	{
		this.id = idcounter++;
		this.name = name;
		this.speciality = speciality;
	}
	
	public void saveToDB()
	{
		try {
			Connection con = DBConnection.getConnection();
			String query = "Insert into doctors(name, speciality) values(?, ?)";
			PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setString(2, speciality);
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
	
	public int getId()
	{
		return id;
	}
	@Override
	public String toString()
	{
		return ("Doctor_ID: "+id+" ,Doctor_Name: "+name+" ,speciality: "+speciality);
	}
	
}
