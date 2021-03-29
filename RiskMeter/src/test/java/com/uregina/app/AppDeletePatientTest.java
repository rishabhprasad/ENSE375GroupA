  
package com.uregina.app;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.*;
import java.io.*;


import java.util.Arrays;
import java.util.Collection;
import org.junit.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.junit.Test; 
import org.junit.Before;


@RunWith(Parameterized.class)
public class AppDeletePatientTest {
    private String patientID;
    private boolean expected_output;
    private App app;

    @Before
    public void initialize() {
        app = new App();
        app.addPatient("Julie Doe", "123456789", "K1A-1B7", 31);
        app.addPatient("Julie Do", "123498765", "K1A-0B2", 31);
        app.addPatient("Juliec", "987654321", "K1A-0B9", 31);
        app.addPatient("Juliea", "123453769", "K1T-1B7", 33);
        app.addPatient("Julieb", "123452769", "K1T-0B2", 33);
        app.addPatient("Julied", "123451769", "K1T-0B9", 33);
    }

    public AppDeletePatientTest(String patientID, boolean output)
    {
        this.patientID=patientID;
        this.expected_output=output;
    }

    @Parameterized.Parameters(name="{index}: DeletePatient({0})={1}")
    public static Collection<Object[]> data() {
       return Arrays.asList(new Object[][] {
          {"123456789",true},{"123498765",true},{"987654321",true},{"123453769",true},{"123452769",true}
          ,{"123451769",true},{"88888888",false},{"",false}
       });
    }

    @Test
    public void checker() {
    assertEquals(expected_output, app.deletePatient(patientID));
    }
}
