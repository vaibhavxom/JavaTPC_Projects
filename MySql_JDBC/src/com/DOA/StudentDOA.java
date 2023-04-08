package com.DOA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.utils.DBConnect;
import com.beans.Student;
public class StudentDOA {
	
	
public Student getStudent(int Id)throws SQLException {
		
		Connection con=DBConnect.getConnection();
		
		Student stud = new Student();
		
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("select * from stud_info where id = "+ Id);
		
		if(rs.next())
		{
			stud.setId(rs.getInt(1));
			stud.setName(rs.getString(2));
			stud.setClss(rs.getString(3));
		}
		else
		{
			System.err.println("record not found");
		}
		rs.close();
		smt.close();
		con.close();
		
		
		return stud;
	} 
	
	public boolean InsertStudent(Student emp)throws SQLException
	{
		boolean flag = false;
		Connection con = DBConnect.getConnection();
		
		String Qury = "insert into stud_info (name,class) values(?,?);";
		
		PreparedStatement pst = con.prepareStatement(Qury); 
		//pst.setInt(0, emp.getId());
		pst.setString(1,emp.getName());
		pst.setString(2,emp.getClss());
		
		int count = pst.executeUpdate();
		
		if(count >0)
		{
			flag = true;
		}
		pst.close();
		con.close();
		return flag;
	}
	public boolean updateStudent(Student emp)throws SQLException
	{
		boolean flag = false;
		Connection con = DBConnect.getConnection();
		
		String Qury = "update Stud_info set name =? ,Class =? where Id = ?;";
		
		PreparedStatement pst = con.prepareStatement(Qury); 
		pst.setInt(3, emp.getId());
		pst.setString(1,emp.getName());
		pst.setString(2,emp.getClss());
		
		int count = pst.executeUpdate();
		
		if(count >0)
		{
			flag = true;
		}
		pst.close();
		con.close();
		return flag;
	}
	public boolean deleteStudent(int Id)throws SQLException
	{
		boolean flag = false;
		Connection con = DBConnect.getConnection();
		
		String Qury = "delete from stud_info where id = ?";
		
		PreparedStatement pst = con.prepareStatement(Qury); 
		pst.setInt(1,Id);
		
		int count = pst.executeUpdate();
		
		if(count >0)
		{
			flag = true;
		}
		pst.close();
		con.close();
		return flag;
	}
	
	public List<Student> getAllStudent() throws SQLException
	{
		List<Student> list = new ArrayList<Student>() ;
		
		Connection con = DBConnect.getConnection();
		
		PreparedStatement pst = con.prepareStatement("select * from stud_info");
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{
			list.add(new Student(rs.getString(2),rs.getString(3),rs.getInt(1)));
		}
		rs.close();
		pst.close();
		con.close();
		
		return list;
		
	}	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
