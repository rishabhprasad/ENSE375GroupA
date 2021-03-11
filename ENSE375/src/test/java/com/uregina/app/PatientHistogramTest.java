package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import jdk.jfr.Timestamp;

/**
 * Unit test for PatientHistogram.
 */
public class PatientHistogramTest
{
    @Test
    public void patientHistogram_validIndex_true(){
        PatientHistogram patientHistogram = new PatientHistogram();
        assertTrue(patientHistogram.addAPatientToRegion(15,5));
    }
    @Test
    public void patientHistogram_invalidVIndex_false(){
        PatientHistogram patientHistogram = new PatientHistogram();
        assertFalse(patientHistogram.addAPatientToRegion(20,1));
    }
    @Test
    public void patientHistogram_invalidHIndex_false(){
        PatientHistogram patientHistogram = new PatientHistogram();
        assertFalse(patientHistogram.addAPatientToRegion(1,10));
    }


}
