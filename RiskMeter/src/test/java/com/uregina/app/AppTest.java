package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.Test;


public class AppTest
{

    @Test
    public void patientAdd_valid_spaces_in_name()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie Doe", "123456789", "K1A-0B9", 31);
        assertTrue( valid );
    }

    @Test
    public void patientAdd_valid_dot_in_name()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie.Doe", "123456789", "K1A-0B9", 31);
        assertTrue( valid );
    }
    
    @Test
    public void patientAdd_valid()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie", "123456789", "K1A-0B9", 31);
        assertTrue( valid );
    }

    //******************************POSTAL CODE TESTS ******************************/
    @Test
    public void patientAdd_postalCode_invalidFormat()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie", "123456789", "K1A0B9", 31);
        assertFalse( valid );
    }

    @Test
    public void patientAdd_postalCode_invalidFormat_Seperator()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie", "123456789", "K1A_0B9", 31);
        assertFalse( valid );
    }

    @Test
    public void patientAdd_postalCode_invalidPrefixSeperator()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie", "123456789", "A2A-1C4", 31);
        assertFalse( valid );
    }

    @Test
    public void patientAdd_postalCode_invalidVerticalIndex()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie", "123456789", "K1Z-1C4", 31);
        assertFalse( valid );
    }

    @Test
    public void patientAdd_postalCode_invalidLowerCase()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie", "123456789", "K1T-3z4", 31);
        assertFalse( valid );
    }

    @Test
    public void patientAdd_postalCode_null()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie", "123456789", null, 31);
        assertFalse( valid );
    }

    //******************************PATIENT TESTS ******************************/
    @Test
    public void patientAdd_Invalid_Name()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie@", "123456789", "K1A-0B9", 31);
        assertFalse( valid );
    } 

    @Test
    public void patientAdd_Invalid_Name_With_Spaces()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie    @", "123456789", "K1A-0B9", 31);
        assertFalse( valid );
    }


    @Test
    public void patientAdd_Invalid_Name_null()
    {
        App app = new App();
        boolean valid = app.addPatient(null, "123456789", "K1A-0B9", 31);
        assertFalse( valid );
    }

    @Test
    public void patientAdd_Invalid_ID_null()
    {
        App app = new App();
        boolean valid = app.addPatient("Charlie", null, "K1A-0B9", 31);
        assertFalse( valid );
    }

    @Test
    public void patientAdd_Invalid_ID()
    {
        App app = new App();
        boolean valid = app.addPatient("Charlie", "000000000", "K1A-0B9", 31);
        assertFalse( valid );
    }

    @Test
    public void patientAdd_Invalid_ID_Character()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie", "780 00000", "K1A-0B9", 31);
        assertFalse( valid );
    }

    @Test
    public void patientAdd_Invalid_Age()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie", "123456789", "K1A-0B9", 120);
        assertFalse( valid );
    }

    @Test
    public void patientAdd_Invalid_Age2()
    {
        App app = new App();
        boolean valid = app.addPatient("Julie", "123456789", "K1A-0B9", -1);
        assertFalse( valid );
    }

    //******************************PATIENT LIST TESTS ******************************/
    @Test
    public void patientAdd_2_patients()
    {
        App app = new App();
        app.addPatient("Julie", "123456789", "K1A-0B9", 31);
        boolean valid = app.addPatient("George", "987654321", "K1A-1B9", 44);
        assertTrue( valid );
    }

     @Test
     public void patientAdd_2_identical_IDs()
    {
     App app = new App();
        app.addPatient("Julie", "123456789", "K1A-0B9", 31);
         boolean valid = app.addPatient("Julie", "123456789", "K1A-0B9", 31);
        assertFalse( valid );
    }


    //******************************PatientHistogram TESTS ******************************/

    //******************************RiskCode map TESTS ******************************/
    @Test
    public void patientAdd_2_patients_same_region()
    {
        App app = new App();
        app.addPatient("Julie", "123456789", "K1A-0B9", 31);
        boolean valid = app.addPatient("George", "987654321", "K1A-0B9", 44);
        assertTrue( valid );
    }
}