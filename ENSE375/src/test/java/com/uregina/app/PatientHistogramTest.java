package com.uregina.app;

import static org.junit.Assert.assertTrue;

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
    public void patientHistogram_invalidIndex_false(){
        PatientHistogram patientHistogram = new PatientHistogram();
        assertTrue(patientHistogram.addAPatientToRegion(20,10));
    }


}
