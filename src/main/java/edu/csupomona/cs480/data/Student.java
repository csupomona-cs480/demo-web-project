package edu.csupomona.cs480.data;

public class Student {

	private String name;
	public int age;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if (age < 0 || age > 150) {
			throw new RuntimeException("Invalid age");
		} else {
			this.age = age;
		}
	}
	
}
