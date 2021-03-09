package com.uregina.app;
import com.uregina.exception.*;


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
		this.postalCode=postalCode;
	}
	public String getName()
	{
		return name;
	}
	public String getID()
	{
		return ID;
	}
	public int getAge()
	{
		return age;
	}
	public PostalCode getPostalCode()
	{	
		return postalCode;
	}
	/**
	*
	* @return boolean: true if the age is corrected set 
	*/
	public boolean setAge(int age)
	{	
		if(this.age==age)//compare set age with input age
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
		if(this.postalCode.getPostalCode().equals(postalCode.getPostalCode()))//compare parameter with set postCode
		{
		return true;
		}
		return false;
	}
}
