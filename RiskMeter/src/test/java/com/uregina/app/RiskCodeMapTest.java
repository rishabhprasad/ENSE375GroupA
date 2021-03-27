package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import java.util.ArrayList;

/**
 * Unit test for RiskCodeMap.
 */
public class RiskCodeMapTest 
{
    @Test
    public void getRiskInARegion_invalidVIndex_throwsIndexOutOfBoundsException()
    {
        RiskCodeMap riskCodeMap = new RiskCodeMap();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            riskCodeMap.getRiskInARegion(21, 5);
        });
    }
    @Test
    public void getRiskInARegion_4_5_true()
    {
        RiskCodeMap riskCodeMap = new RiskCodeMap();
        char riskCode = riskCodeMap.getRiskInARegion(4, 5);
        boolean correctChar = (riskCode == 'N');
        assertTrue(correctChar);
    }
    @Test
    public void getRiskInARegion_4_5_false()
    {
        RiskCodeMap riskCodeMap = new RiskCodeMap();
        char riskCode = riskCodeMap.getRiskInARegion(4, 5);
        boolean wrongChar = (riskCode == 'K');
        assertFalse(wrongChar);
    }
    @Test
    public void updateRiskInARegion_2_0_true()
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
    public void updateRiskInARegion_2_0_true_twice()
    {
        RiskCodeMap riskCodeMap = new RiskCodeMap();
        ArrayList<Integer> neighboursCaseCount = new ArrayList<Integer>();
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        neighboursCaseCount.add(0);
        riskCodeMap.updateRiskInARegion(5, 4, 2, neighboursCaseCount);
        boolean update = riskCodeMap.updateRiskInARegion(5, 4, 2, neighboursCaseCount);
        assertTrue(update);
    }
    @Test
    public void getRiskInARegion_G_true()
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
    public void getRiskInARegion_O_true()
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
    @Test
    public void getRiskInARegion_O_neightbours_true()
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
    @Test
    public void getRiskInARegion_R_6_neightbours_true()
    {
        RiskCodeMap riskCodeMap = new RiskCodeMap();
        ArrayList<Integer> neighboursCaseCount = new ArrayList<Integer>();
        neighboursCaseCount.add(14);
        neighboursCaseCount.add(15);
        neighboursCaseCount.add(12);
        neighboursCaseCount.add(9);
        neighboursCaseCount.add(10);
        neighboursCaseCount.add(15);
        riskCodeMap.updateRiskInARegion(5, 4, 0, neighboursCaseCount);
        char riskCode = riskCodeMap.getRiskInARegion(5, 4);
        boolean correctChar = (riskCode == 'R');
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
