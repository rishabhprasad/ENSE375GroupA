package com.uregina.app;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import com.uregina.exception.*;

import org.junit.Test;

/**
 * Unit test for Patient.
 */
public class PatientTest 
{
    @Test
    public void Correct_True()
    {
        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "123456789",12,postalCode);
            assertTrue(patient.setAge(12));
        }
        catch (InvalidPostalCodeException e)
        {
            throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
            assertTrue(false);
        }
        catch (InvalidNameException e1)
        {
            throw new InvalidNameException("Name Exception","Invalid Name");
            assertTrue(false);
        }
        catch (InvalidAgeException e2)
        {
            throw new InvalidAgeException("Age Exception","Invalid Age");
            assertTrue(false);
        }
        catch (InvalidIDException e3)
        {
            throw new InvalidIDException("ID Exception","Invalid ID");
            assertTrue(false);
        }
    }
  
    @Test
    public void Correct_age_False_outOf_above_Range()
    {        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "123456789",120,postalCode);
            assertFalse(patient.setAge(120));
                }
                catch (InvalidPostalCodeException e)
                {
                    throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
                    assertTrue(false);
                }
                catch (InvalidNameException e1)
                {
                    throw new InvalidNameException("Name Exception","Invalid Name");
                    assertTrue(false);
                }
                catch (InvalidAgeException e2)
                {
                    throw new InvalidAgeException("Age Exception","Invalid Age");
                    assertTrue(false);
                }
                catch (InvalidIDException e3)
                {
                    throw new InvalidIDException("ID Exception","Invalid ID");
                    assertTrue(false);
                }
    }

    @Test
    public void Correct_age_False_outOf_bellow_Range()
    {        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "123456789",12,postalCode);
            assertFalse(patient.setAge(-12));
                }
                catch (InvalidPostalCodeException e)
                {
                    throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
                    assertTrue(false);
                }
                catch (InvalidNameException e1)
                {
                    throw new InvalidNameException("Name Exception","Invalid Name");
                    assertTrue(false);
                }
                catch (InvalidAgeException e2)
                {
                    throw new InvalidAgeException("Age Exception","Invalid Age");
                    assertTrue(false);
                }
                catch (InvalidIDException e3)
                {
                    throw new InvalidIDException("ID Exception","Invalid ID");
                    assertTrue(false);
                }
    }

    @Test
    public void Correct_postalCode_True()
    {
        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            PostalCode postalc = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "123456789",12,postalCode);
            assertTrue(patient.setPostalCode(postalc));
        }
        catch (InvalidPostalCodeException e)
        {
            throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
            assertTrue(false);
        }
        catch (InvalidNameException e1)
        {
            throw new InvalidNameException("Name Exception","Invalid Name");
            assertTrue(false);
        }
        catch (InvalidAgeException e2)
        {
            throw new InvalidAgeException("Age Exception","Invalid Age");
            assertTrue(false);
        }
        catch (InvalidIDException e3)
        {
            throw new InvalidIDException("ID Exception","Invalid ID");
            assertTrue(false);
        }
    }

    @Test
    public void InvalidName_True()
    {
        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            PostalCode postalc = new PostalCode("K1A-0B9");
            Patient patient = new Patient("#@#!Landry", "123456789",12,postalCode);
            //error not caught if it doesnt throw exception.
            assertTrue(false);
        }
        catch (InvalidPostalCodeException e)
        {
            throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
            assertTrue(false);
        }
        catch (InvalidNameException e1)
        {
            throw new InvalidNameException("Name Exception","Invalid Name");
            assertTrue(true);
        }
        catch (InvalidAgeException e2)
        {
            throw new InvalidAgeException("Age Exception","Invalid Age");
            assertTrue(false);
        }
        catch (InvalidIDException e3)
        {
            throw new InvalidIDException("ID Exception","Invalid ID");
            assertTrue(false);
        }
    }

    @Test
    public void InvalidID_True()
    {
        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            PostalCode postalc = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "123456765789",12,postalCode);
            //error not caught if it doesnt throw exception.
            assertTrue(false);
        }
        catch (InvalidPostalCodeException e)
        {
            throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
            assertTrue(false);
        }
        catch (InvalidNameException e1)
        {
            throw new InvalidNameException("Name Exception","Invalid Name");
            assertTrue(false);
        }
        catch (InvalidAgeException e2)
        {
            throw new InvalidAgeException("Age Exception","Invalid Age");
            assertTrue(false);
        }
        catch (InvalidIDException e3)
        {
            throw new InvalidIDException("ID Exception","Invalid ID");
            assertTrue(true);
        }
    }

    @Test
    public void InvalidID0_True()
    {
        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            PostalCode postalc = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "000000000",12,postalCode);
            //error not caught if it doesnt throw exception.
            assertTrue(false);
        }
        catch (InvalidPostalCodeException e)
        {
            throw new InvalidPostalCodeException("Postal Code Exception","Invalid Postal Code");
            assertTrue(false);
        }
        catch (InvalidNameException e1)
        {
            throw new InvalidNameException("Name Exception","Invalid Name");
            assertTrue(false);
        }
        catch (InvalidAgeException e2)
        {
            throw new InvalidAgeException("Age Exception","Invalid Age");
            assertTrue(false);
        }
        catch (InvalidIDException e3)
        {
            throw new InvalidIDException("ID Exception","Invalid ID");
            assertTrue(true);
        }
    }


}
