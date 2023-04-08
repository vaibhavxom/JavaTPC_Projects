package com.service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.DOA.StudentDOA;
import com.beans.Student;

public class StudentService {

	public static void main(String[] args) {
		
		StudentDOA  doa = new StudentDOA();
		
		Scanner sc = new Scanner(System.in);
		
		int ch = 0;
		while(true)	
		{
				System.out.println("MAIN MENU \n=========================");
				System.out.println("enter an sql action to perform");
				System.out.println("1. Access single record ");
				System.out.println("2. Insert a record : ");
				System.out.println("3. Update a record: ");
				System.out.println("4. Delete a record: ");
				System.out.println("5. GetAll records: ");
				System.out.println("6. Exit: ");
				System.out.print("Enter your choice(1..6): ");
				
				ch=sc.nextInt();
				
				StudentService ss = new StudentService();
				
				switch (ch) {
					case 1:
					StudentService.access(sc, doa);
					
					
					break;
				case 2:
						
						StudentService.insert(sc, doa);
						
						break;
				case 3:
					
					StudentService.update(sc, doa);
					
					break;
				case 4:
					
					StudentService.delete(sc, doa);
					break;
				case 5:
					StudentService.getAll(doa);
					break;
				
				}	
				if(ch==6);	
				{
				System.err.print("Exiting ...!! Thanks for using the application");
					System.exit(0);
				
					}
		}
	}

		
		/*	this is alternate way to call the functions one by one
				//access(sc, doa);
				//insert(sc, doa);
				//update(sc, doa);
				//delete(sc, doa);
				//getAll(doa);
			*/
			
			static void access(Scanner sc,StudentDOA dao){
				int Id;
				
				System.out.println("enter  employee id : ");
				
				Id = sc.nextInt();
				try {
				Student stud = dao.getStudent(Id);
				
				if(stud != null)
				{
					System.out.println("emp id = " + stud.getId());
					System.out.println("emp name = " +stud.getName());
					System.out.println("emp salaray =" + stud.getClss());
				}
				else
				{
					System.out.println("Student Not found");
					
				}
				}
				catch(SQLException ex)
				{
					System.err.println(ex.getMessage());
				}
				System.err.println("thanks for using Mysql.........!!!");

			}
			
			 static void insert(Scanner sc,StudentDOA doa ) {
					
					System.out.println("enter Student Id : ");
					int Id = sc.nextInt();
					System.out.println("enter Student name :");
					String Name = sc.next();
					System.out.println("enter Student Class :");
					String clss = sc.next();
					
					Student stud = new Student(Name,clss, Id);
				
					try {
						if(doa.InsertStudent(stud))
						{
							System.err.println("Student Inserted");
						}
						else
						{
							System.err.println("error inserting ");
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
			}
			
			 static void update(Scanner sc,StudentDOA doa ) {
					
					System.out.println("enter Student Id to update : ");
					int Id=sc.nextInt();
					System.out.println("enter Student name to update:");
					String Name = sc.next();
					System.out.println("enter Student salary to update :");
					String Clss=sc.next();
					
					Student stud = new Student(Name,Clss, Id);
				
					try {
						if(doa.updateStudent(stud))
						{
							System.err.println("Student updated");
						}
						else
						{
							System.err.println("error unable to update ");
						}
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
			}
			 
			  static void delete(Scanner sc,StudentDOA doa ) {
					
					System.out.println("enter Student Id to update : ");
					int Id =sc.nextInt();			
					
				
					try {
						if(doa.deleteStudent(Id))
						{
							System.err.println("Student deleted");
						}
						else
						{
							System.err.println("error unable to delete ");
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
			}
			 
			  static void getAll(StudentDOA doa)
			 {
				 try {
					List<Student> emplist = doa.getAllStudent();
					if(emplist.size()>0)
					{
						Iterator<Student> it = emplist.iterator();
						while(it.hasNext()) 
						{
							Student stud =(Student)it.next();
							System.out.println("|"+stud.getId()+"|" +stud.getName()+"|"+ stud.getClss());
						}
					}
					else 
					{
						System.err.println("Student are not  present");
					}
				} catch (SQLException ex) {
					
					ex.printStackTrace();
				} 


	}

}
