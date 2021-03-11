//package com.uregina.app;


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
        Patient object;
        assertFalse( patientList.addPatient(object));
    }
    @Test
    public void patientList_SuccesfulAdd()
    {
        PatientList patientList = new PatientList();
        PostalCode postal = new PostalCode("K1A-0B9");
        Patient object = new Patient("Kaden","12345678",12,postal);
        assertTrue( patientList.addPatient(object));
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
