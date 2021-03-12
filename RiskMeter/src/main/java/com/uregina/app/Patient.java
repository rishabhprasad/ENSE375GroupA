package com.uregina.app;
import com.uregina.exception.*;
import java.util.regex.*;

public class Patient 
{
	private String name;
	private String ID;
	private int age;
	private PostalCode postalCode;
	
	public Patient(String name, String ID, int age, PostalCode postalCode) throws InvalidNameException, InvalidAgeException ,InvalidIDException, InvalidPostalCodeException
	{		
		 //The patient ID is a 9-digit string with a non-zero digit. 
		 String IDCheck = "^([0-9]{9})$";
		 Boolean IDFormat = Pattern.matches(IDCheck,ID);
 
		 //Patient name can only contain alphabetic letters as well as spaces and dots. 
		 //Check if name is correct in format
		 String nameCheck = "^([a-zA-Z_.])+$";
		 boolean isCorrectName = Pattern.matches(nameCheck, name);
 
		 if((age > 0 && age < 110))
		 {
		 if(IDFormat && isCorrectName && (postalCode != null))
		 {
		this.name=name;
		this.ID=ID;
		this.age=age;
		this.postalCode= postalCode;
		 }
		}
	}
	public String getName()
	{
		return this.name;
	}
	public String getID()
	{
		return this.ID;
	}
	public int getAge()
	{
		return this.age;
	}
	public PostalCode getPostalCode()
	{	
		return this.postalCode;
	}
	/**
	*
	* @return boolean: true if the age is corrected set 
	*/
	public boolean setAge(int age)
	{	
		if(this.age<age&&age<110)//compare set age with input age
		{
			this.age = age;
			return true;
		}
		return false;
	}
	/**
	*
	* @return boolean: true if the postal code is corrected set 
	*/
	public boolean setPostalCode(PostalCode postalCode)
	{
		
		System.out.println(postal.getPostalCode());
		System.out.println(this.postalCode.getPostalCode());
	
		if((postalCode.getPostalCode().equals(this.postalCode.getPostalCode())==false)&&postalCode!=null)//compare parameter with set postCode
		{
			this.postalCode = postalCode;
				return true;
		}
	return false;
	}
}
