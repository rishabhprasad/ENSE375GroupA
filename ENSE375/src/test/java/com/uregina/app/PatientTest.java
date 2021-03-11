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
    public void Correct_age_True()
    {
        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "000000000",12,postalCode);
            assertTrue(patient.setAge(12));
        }
        catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
        {
            assertTrue(true);
        }
    }
    @Test
    public void Correct_age_False_unequal()
    {
                try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "000000000",12,postalCode);
            assertFalse(patient.setAge(13));
        }
        catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
        {
            assertTrue(false);
        }
    }
    @Test
    public void Correct_age_False_outOf_above_Range()
    {        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "000000000",120,postalCode);
            assertFalse(patient.setAge(120));
                }
            catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
        {
            assertTrue(false);
        }
    }
    @Test
    public void Correct_age_False_outOf_bellow_Range()
    {        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "000000000",12,postalCode);
            assertFalse(patient.setAge(-12));
                }
            catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
        {
            assertTrue(false);
        }
    }
    @Test
    public void Correct_postalCode_True()
    {
        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            PostalCode postalc = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Landry", "000000000",12,postalCode);
            assertTrue(patient.setPostalCode(postalc));
        }
        catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
        {
            assertTrue(true);
        }
    }
    @Test
    public void Correct_postalCode_False_incorecte_input()
    {        try{
            PostalCode postalCode = new PostalCode("K1A_0B9");
            PostalCode postalc = new PostalCode("K1A_0B9");
            Patient patient = new Patient("Landry", "000000000",12,postalCode);
            assertFalse(patient.setPostalCode(postalc));
        } catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
        {
            assertTrue(false);
        }
    }
    @Test
    public void Correct_postalCode_False_unequal()
    {        try{
            PostalCode postalCode = new PostalCode("K1A-0B9");
            PostalCode postalc=new PostalCode("K1A-0B6");
            Patient patient = new Patient("Landry", "000000000",12,postalCode);
            assertFalse(patient.setPostalCode(postalc));
          } catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
        {
            assertTrue(false);
        }
    }
}
