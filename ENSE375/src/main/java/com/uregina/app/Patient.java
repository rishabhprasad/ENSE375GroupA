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
		this.name=name;
		this.ID=ID;
		this.age=age;
		this.pstalCode= new postCode();
		this.postalCode=postalCode;
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
		if((age > 0 && age < 110)&&(this.age==age))//compare set age with input age
		{
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
		if(this.postalCode.getPostalCode().equals(postalCode.getPostalCode())&&postalCode.isValidPostalCode(this.postalCode.getPostalCode()))//compare parameter with set postCode
		{
				return true;
		}
	return false;
	}
}
