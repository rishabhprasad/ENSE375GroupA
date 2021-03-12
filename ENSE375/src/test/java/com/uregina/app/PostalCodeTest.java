package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.uregina.exception.*;

import org.junit.Test;

/**
 * Unit test for simple PostalCode.
 */
public class PostalCodeTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void postalCode_validFormat_True(){
        PostalCode postalCode = null;
        try{
        postalCode = new PostalCode("K1A-0B9");
        }
    	catch(InvalidPostalCodeException e){
    		System.out.println( "\tInvalid PostalCode" );
    	}
        int vertical = postalCode.getRegionVerticalIndex();
        boolean isValid = vertical == 'A';
        assertTrue(isValid);
    }
    @Test
    public void postalCode_invalidFormat_throwsInvalidPostalCodeException() {
        assertThrows(InvalidPostalCodeException.class, () -> {
            PostalCode postalCode = new PostalCode("K0B9");
        });
    }
    @Test
    public void postalCode_invalidFormatSeperator_throwsInvalidPostalCodeException() {
        assertThrows(InvalidPostalCodeException.class, () -> {
            PostalCode postalCode = new PostalCode("K1A_0B9");
        });
    }
    @Test
    public void postalCode_invalidPrefixSeperator_throwsInvalidPostalCodeException() {
        assertThrows(InvalidPostalCodeException.class, () -> {
            PostalCode postalCode = new PostalCode("A2A-1C4");
        });
    }
    @Test
    public void postalCode_invalidVerticalIndex_throwsInvalidPostalCodeException() {
        assertThrows(InvalidPostalCodeException.class, () -> {
            PostalCode postalCode = new PostalCode("K1Z-1C4");
        });
    }
    @Test
    public void postalCode_invalidHorizontalIndex_throwsInvalidPostalCodeException() {
        assertThrows(InvalidPostalCodeException.class, () -> {
            PostalCode postalCode = new PostalCode("K1T-ZC4");
        });
    }
    @Test
    public void postalCode_invalidLowerCase_throwsInvalidPostalCodeException() {
        assertThrows(InvalidPostalCodeException.class, () -> {
            PostalCode postalCode = new PostalCode("K1T-3z4");
        });
    }
    @Test
    public void postalCode_invalidLastDigit_throwsInvalidPostalCodeException() {
        assertThrows(InvalidPostalCodeException.class, () -> {
            PostalCode postalCode = new PostalCode("K1T-3YX");
        });
    }
}
