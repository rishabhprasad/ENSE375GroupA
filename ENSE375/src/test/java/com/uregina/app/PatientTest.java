package com.uregina.app;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import com.uregina.exception.*;
import org.junit.jupiter.api.BeforeAll;
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
            assertTrue(patient.setAge(13));
        }
        catch (InvalidPostalCodeException e)
        {
            assertTrue(false);
            throw new InvalidPostalCodeException();
            
        }
        catch (InvalidNameException e)
        {
            assertTrue(false);
            throw new InvalidNameException("Invalid Name");
          
        }
        catch (InvalidAgeException e)
        {
            assertTrue(false);
            throw new InvalidAgeException(-1);
           
        }
        catch (InvalidIDException e)
        {
            assertTrue(false);
            throw new InvalidIDException("Invalid ID");
           
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
                    assertTrue(false);
                    throw new InvalidPostalCodeException();
                   
                }
                catch (InvalidNameException e)
                {
                    assertTrue(false);
                    throw new InvalidNameException("Invalid Name");
                  
                }
                catch (InvalidAgeException e)
                {
                    assertTrue(false);
                    throw new InvalidAgeException(-1);
                  
                }
                catch (InvalidIDException e)
                {
                    assertTrue(false);
                    throw new InvalidIDException("Invalid ID");
                  
                }
    }

    @Test
    public void Correct_age_False_outOf_bellow_Range()
    {        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "123456789",12,postalCode);
            assertFalse(patient.setAge(11));
                }
                catch (InvalidPostalCodeException e)
                {
                    assertTrue(false);
                    throw new InvalidPostalCodeException();
                   
                }
                catch (InvalidNameException e)
                {
                    assertTrue(false);
                    throw new InvalidNameException("Invalid Name");
                   
                }
                catch (InvalidAgeException e)
                {
                    assertTrue(false);
                    throw new InvalidAgeException(-1);
                  
                }
                catch (InvalidIDException e)
                {
                    assertTrue(false);
                    throw new InvalidIDException("Invalid ID");
                 
                }
    }

    @Test
    public void Correct_postalCode_True()
    {
        try{
            PostalCode postalCode = new PostalCode("K1A-0B6");
            PostalCode postalc = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "123456789",12,postalCode);
            assertTrue(patient.setPostalCode(postalc));
        }
        catch (InvalidPostalCodeException e)
        {
            assertTrue(false);
            throw new InvalidPostalCodeException();
            
        }
        catch (InvalidNameException e)
        {
            assertTrue(false);
            throw new InvalidNameException("Invalid Name");
          
        }
        catch (InvalidAgeException e)
        {
            assertTrue(false);
            throw new InvalidAgeException(-1);
            
        }
        catch (InvalidIDException e)
        {
            assertTrue(false);
            throw new InvalidIDException("Invalid ID");
          
        }
    }
    @Test
    public void Correct_postalCode_False_SameCode()
    {
        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            PostalCode postalc = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "123456789",12,postalCode);
            assertTrue(patient.setPostalCode(postalc));
        }
        catch (InvalidPostalCodeException e)
        {
            assertTrue(false);
            throw new InvalidPostalCodeException();
          
        }
        catch (InvalidNameException e)
        {
            assertTrue(false);
            throw new InvalidNameException("Invalid Name");
           
        }
        catch (InvalidAgeException e)
        {
            assertTrue(false);
            throw new InvalidAgeException(-1);
           
        }
        catch (InvalidIDException e)
        {
            assertTrue(false);
            throw new InvalidIDException("Invalid ID");
           
        }
    }
    @Test
    public void Correct_postalCode_null()
    {
        try{
            PostalCode postalCode = new PostalCode("");
            PostalCode postalc = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "123456789",12,postalCode);
            assertTrue(patient.setPostalCode(postalc));
        }
        catch (InvalidPostalCodeException e)
        {
            assertTrue(false);
            throw new InvalidPostalCodeException();
          
        }
        catch (InvalidNameException e)
        {
            assertTrue(false);
            throw new InvalidNameException("Invalid Name");
            
        }
        catch (InvalidAgeException e)
        {
            assertTrue(false);
            throw new InvalidAgeException(-1);
           
        }
        catch (InvalidIDException e)
        {
            assertTrue(false);
            throw new InvalidIDException("Invalid ID");
            
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
        assertTrue(false);
        throw new InvalidPostalCodeException();
        
    }
    catch (InvalidNameException e)
    {
        throw new InvalidNameException("Invalid Name");
    }
    catch (InvalidAgeException e)
    {
        assertTrue(false);
        throw new InvalidAgeException(-1);
        
    }
    catch (InvalidIDException e)
    {
        assertTrue(false);
        throw new InvalidIDException("Invalid ID");
        
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
            assertTrue(false);
            throw new InvalidPostalCodeException();
            
        }
        catch (InvalidNameException e)
        {
            assertTrue(false);
            throw new InvalidNameException("Invalid Name");
         
        }
        catch (InvalidAgeException e)
        {
            assertTrue(false);
            throw new InvalidAgeException(-1);
          
        }
        catch (InvalidIDException e)
        {
            assertTrue(true);
            throw new InvalidIDException("Invalid ID");
            
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
        assertTrue(false);
        throw new InvalidPostalCodeException();
        
    }
    catch (InvalidNameException e)
    {
        assertTrue(false);
        throw new InvalidNameException("Invalid Name");
        
    }
    catch (InvalidAgeException e)
    {
        assertTrue(false);
        throw new InvalidAgeException(-1);
       
    }
    catch (InvalidIDException e)
    {
        assertTrue(true);
        throw new InvalidIDException("Invalid ID");
       
    }
    }


}