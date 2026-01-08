package com.learnJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
	
	private Connection con;
	//private Scanner sc;
	
	public Doctor(Connection con)
	{
		this.con = con;
		//this.sc = sc; 						
	}
	
	
	public void viewDoctors(){
        String query = "select * from doctors";
        try{
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Doctors: ");
            System.out.println("+------------+--------------------+------------------+");
            System.out.println("| Doctor Id  | Name               | Specialization   |");
            System.out.println("+------------+--------------------+------------------+");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String  Specialization = resultSet.getString("Specialization");
                System.out.printf("| %-10s | %-18s | %-16s |\n", id, name,  Specialization);
                System.out.println("+------------+--------------------+------------------+");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }	
	public boolean getDoctorByID(int id) {
		
		String query = "select * from doctors WHERE id = ?";
		
		
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1,id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				return true;
				
			}
			else {
				
				return false;
			}
			
		}
		catch(SQLException e)
		{
			
			System.out.println("In catch");
			
			
		}
		return false;
				
		
		
	}
	
	


}