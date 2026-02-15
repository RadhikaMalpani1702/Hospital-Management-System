package management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import db.DBConnection;
import java.time.LocalDate;

public class Appointment {
	
	private int id;
	private Patient patient;
	private Doctor doctor;
	private LocalDate date;
	
	public Appointment(Patient patient, Doctor doctor, LocalDate date)
	{
		this.patient = patient;
		this.doctor = doctor;
		this.date = date;
	}
	
	public void saveToDB()
	{
		try {
			
			Connection con = DBConnection.getConnection();
			String query = "Insert Into Appointments (patient_id, doctor_id, appointment_date) values(?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, patient.getId());
			ps.setInt(2, doctor.getId());
			ps.setDate(3, java.sql.Date.valueOf(date));
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
	public String toString()
	{
		return ("Appointment: [Patient: "+patient+" ,Doctor: "+doctor+" ,Date: "+date);
	}
	
}
