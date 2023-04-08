package com.beans;

public class Student {
private String name;
private String Clss;
private int id;



public Student(String name, String clss, int id) {
	super();
	this.name = name;
	Clss = clss;
	this.id = id;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getClss() {
	return Clss;
}
public void setClss(String clss) {
	Clss = clss;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

	
		
}
