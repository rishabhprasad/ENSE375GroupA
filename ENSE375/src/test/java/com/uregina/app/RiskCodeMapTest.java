package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for RiskCodeMap.
 */
public class RiskCodeMapTest 
{
    @Before
    public void setUpRiskCodeMapTests() {
        
    }

    @Test
    public void getRisk_4_5_true()
    {
        char riskCode = riskCodeMap.getRiskInARegion(4, 5);
        bool correctChar = (riskCode == 'N');
        assertTrue(correctChar);
    }
    @Test
    public void getRisk_4_5_false()
    {
        char riskCode = riskCodeMap.getRiskInARegion(4, 5);
        bool worngChar = (riskCode == 'K');
        assertFalse(wrongChar);
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
