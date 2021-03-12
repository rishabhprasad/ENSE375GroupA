package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import java.util.ArrayList;

// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Unit test for RiskCodeMap.
 */
public class RiskCodeMapTest 
{
    @Test
    public void getRisk_4_5_true()
    {
        RiskCodeMap riskCodeMap = new RiskCodeMap();
        char riskCode = riskCodeMap.getRiskInARegion(4, 5);
        boolean correctChar = (riskCode == 'N');
        assertTrue(correctChar);
    }
    @Test
    public void getRisk_4_5_false()
    {
        RiskCodeMap riskCodeMap = new RiskCodeMap();
        char riskCode = riskCodeMap.getRiskInARegion(4, 5);
        boolean wrongChar = (riskCode == 'K');
        assertFalse(wrongChar);
    }
    @Test
    public void updateRisk_2_0_true()
    {
        RiskCodeMap riskCodeMap = new RiskCodeMap();
        ArrayList<Integer> neighboursCaseCount = new ArrayList<Integer>();
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        boolean update = riskCodeMap.updateRiskInARegion(5, 4, 2, neighboursCaseCount);
        assertTrue(update);
    }
    @Test
    public void updateRisk_2_0_false()
    {
        RiskCodeMap riskCodeMap = new RiskCodeMap();
        ArrayList<Integer> neighboursCaseCount = new ArrayList<Integer>();
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        riskCodeMap.updateRiskInARegion(5, 4, 2, neighboursCaseCount);
        boolean update = riskCodeMap.updateRiskInARegion(5, 4, 2, neighboursCaseCount);
        assertFalse(update);
    }
    @Test
    public void getRisk_G_true()
    {
        RiskCodeMap riskCodeMap = new RiskCodeMap();
        ArrayList<Integer> neighboursCaseCount = new ArrayList<Integer>();
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        riskCodeMap.updateRiskInARegion(5, 4, 0, neighboursCaseCount);
        char riskCode = riskCodeMap.getRiskInARegion(5, 4);
        boolean correctChar = (riskCode == 'G');
        assertTrue(correctChar);
    }
    @Test
    public void getRisk_O_true()
    {
        RiskCodeMap riskCodeMap = new RiskCodeMap();
        ArrayList<Integer> neighboursCaseCount = new ArrayList<Integer>();
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        riskCodeMap.updateRiskInARegion(5, 4, 9, neighboursCaseCount);
        char riskCode = riskCodeMap.getRiskInARegion(5, 4);
        boolean correctChar = (riskCode == 'O');
        assertTrue(correctChar);
    }
    public void getRisk_O_neightbours_true()
    {
        RiskCodeMap riskCodeMap = new RiskCodeMap();
        ArrayList<Integer> neighboursCaseCount = new ArrayList<Integer>();
        neighboursCaseCount.add(9);
        neighboursCaseCount.add(9);
        neighboursCaseCount.add(9);
        neighboursCaseCount.add(9);
        riskCodeMap.updateRiskInARegion(5, 4, 0, neighboursCaseCount);
        char riskCode = riskCodeMap.getRiskInARegion(5, 4);
        boolean correctChar = (riskCode == 'O');
        assertTrue(correctChar);
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
