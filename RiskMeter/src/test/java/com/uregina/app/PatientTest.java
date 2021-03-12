package com.uregina.app;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.uregina.exception.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;

/**
 * Unit test for Patient.
 */
public class PatientTest 
{
    @Test
    public void patient_Name_Valid()
    {
        try
        {
        PostalCode postalCode = new PostalCode("K1A-0B9");
        Patient patient = new Patient("Kaden","123456789",12,postalCode);
        assertTrue(true);
        }
        catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
        {}
    }
    @Test
    public void patient_Invalid_Name_Exception()
    {    
        assertThrows(InvalidNameException.class, () -> {
            PostalCode postalCode = new PostalCode("K1A-0B9"); 
            Patient patient = new Patient("Kaden@","123456789",12,postalCode);
        });  
    }
    @Test
    public void patient_Invalid_Name_Null()
    {
        assertThrows(NullPointerException.class, () -> {
            PostalCode postalCode = new PostalCode("K1A-0B9"); 
            Patient patient = new Patient(null,"123456789",12,postalCode);
        });  
    }

    @Test
    public void patient_ID_Valid()
    {
        try
        {
        PostalCode postalCode = new PostalCode("K1A-0B9");
        Patient patient = new Patient("Kaden","123456789",12,postalCode);
        assertTrue(true);
        }
        catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
        {}
    }
    @Test
    public void patient_Invalid_ID_Exception()
    {    
        assertThrows(InvalidIDException.class, () -> {
            PostalCode postalCode = new PostalCode("K1A-0B9"); 
            Patient patient = new Patient("Kaden","000000000",12,postalCode);
        });  
    }

    @Test
    public void patient_Invalid_ID_Character_Exception()
    {    
        assertThrows(InvalidIDException.class, () -> {
            PostalCode postalCode = new PostalCode("K1A-0B9"); 
            Patient patient = new Patient("Kaden","A0002 000",12,postalCode);
        });  
    }

    @Test
    public void patient_Invalid_ID_Null()
    {
        assertThrows(NullPointerException.class, () -> {
            PostalCode postalCode = new PostalCode("K1A-0B9"); 
            Patient patient = new Patient("Kaden",null,12,postalCode);
        });  
    }

    @Test
    public void patient_Invalid_Age_Exception()
    {    
        assertThrows(InvalidAgeException.class, () -> {
            PostalCode postalCode = new PostalCode("K1A-0B9");
            Patient patient = new Patient("Kaden","100010001",120,postalCode);
        });  
    }



}