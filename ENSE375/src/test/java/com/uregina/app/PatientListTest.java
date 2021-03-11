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
        Patient object = new Patient();
        assertFalse( patientList.addPatient(object));
    }
    @Test
    public void patientList_SuccesfulAdd() 
    {
        PatientList patientList = new PatientList();
        boolean error = false;

        try{
        PostalCode postal = new PostalCode("K1A-0B9");
       
    }
        catch (InvalidPostalCodeException e)
        {
            error = true;
        }


        try{
    		Patient object = new Patient("Kaden","12345678",12,postal);
    	}
    	catch(InvalidNameException e){
    		error = true;
    		
    	}
    	catch(InvalidAgeException e){
    		error = true;
    	
    	}
    	catch(InvalidIDException e){
    		error = true;
    		
    	}
    	catch(InvalidPostalCodeException e){
    		error = true;
    		
    	}
        if (error = false)
        {
        assertTrue(true);
        }
        else
        {
         assertTrue( patientList.addPatient(object));
        }
    }
    @Test
    public void patientList_FailToAdd_InvalidPostal()
    {
        PatientList patientList = new PatientList();
        PostalCode postal;
        Patient object = new Patient("Kaden","12345678",12,postal);
        assertFalse( true );
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
