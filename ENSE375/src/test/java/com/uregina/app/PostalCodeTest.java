package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;


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
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void postalCodeLength_True() {
        PostalCode postalCode = new PostalCode("K1A-0B9");

        assertTrue(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }
    
    @Test
    public void postalCodeLength_False() {
        PostalCode postalCode = new PostalCode("K1A0B9");

        assertFalse(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }

    
    @Test
    public void postalCode_Separator_False() {
        PostalCode postalCode = new PostalCode("K1A_0B9");

        assertFalse(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }

    @Test
    public void postalCode_Separator_True() {
        PostalCode postalCode = new PostalCode("K1A-1C4");

        assertTrue(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }

    @Test
    public void postalCode_FixedPrefix_True() {
        PostalCode postalCode = new PostalCode("K1B-1C4");

        assertTrue(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }

    @Test
    public void postalCode_FixedPrefix_False() {
        PostalCode postalCode = new PostalCode("A2A-1C4");

        assertFalse(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }

    @Test
    public void postalCode_VerticalIndex_False() {
        PostalCode postalCode = new PostalCode("K1Z-1C4");

        assertFalse(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }

    @Test
    public void postalCode_VerticalIndex_True() {
        PostalCode postalCode = new PostalCode("K1T-1C4");

        assertTrue(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }

    
    @Test
    public void postalCode_HorizontalIndex_True() {
        PostalCode postalCode = new PostalCode("K1T-2C4");

        assertTrue(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }

    
    @Test
    public void postalCode_HorizontalIndex_False() {
        PostalCode postalCode = new PostalCode("K1T-ZC4");

        assertFalse(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }

    @Test
    public void postalCode_UpperCaseLetter_False() {
        PostalCode postalCode = new PostalCode("K1T-3z4");

        assertFalse(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }

    @Test
    public void postalCode_UpperCaseLetter_True() {
        PostalCode postalCode = new PostalCode("K1T-3Y4");

        assertTrue(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }

    @Test
    public void postalCode_LastDigit_True() {
        PostalCode postalCode = new PostalCode("K1T-3Y9");

        assertTrue(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }

    @Test
    public void postalCode_LastDigit_False() {
        PostalCode postalCode = new PostalCode("K1T-3YX");

        assertFalse(postalCode.isValidPostalCode(postalCode.getPostalCode()));
    }
    
    @Test
    public void postalCode_GetVerticalIndex_True() {
        PostalCode postalCode = new PostalCode("K1A-0B9");

        assertEquals(postalCode.getRegionVerticalIndex(), 'A');
        
    }

    @Test
    public void postalCode_GetHorizontalIndex_True() {
        PostalCode postalCode = new PostalCode("K1A-0B9");

        assertEquals(postalCode.getRegionHorizontalIndex(), '0');
        
    }

    @Test
    public void postalCode_GetPostalCode_True() {
        PostalCode postalCode = new PostalCode("K1A-0B9");

        assertEquals(postalCode.getPostalCode(), "K1A-0B9");
        
    }
}
