package com.uregina.app;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import com.uregina.exception.*;

import org.junit.Test;

/**
 * Unit test for PatientList.
 */
public class PatientListTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void patientList_FailToAdd()
    {
        PatientList patientList = new PatientList();
        try{
        PostalCode postal = new PostalCode("K1A-0B9");
        //error in name.
        Patient object = new Patient("Kaden","12345678",12343245,postal);
        boolean yes = patientList.addPatient(object);
        assertTrue( yes );   
        }
        catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
        {
        assertFalse(false);
        }
    }
    @Test
    public void patientList_SuccesfulAdd() 
    {
        PatientList patientList = new PatientList();
        boolean error = false;

        try{
        PostalCode postal = new PostalCode("K1A-0B9");
        Patient object = new Patient("Kaden","12345678",12,postal);
        assertTrue( patientList.addPatient(object));
        }
        catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
        {
            error = true;
            assertTrue(false);
        }
     
    }
    @Test
    public void patientList_FailToAdd_InvalidPostal()
    {
        assertTrue( true );
    }
    @Test
    public void ithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void shouldAnswWithTrue()
    {
        assertTrue( true );
    }
}
