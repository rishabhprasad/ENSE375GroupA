package com.uregina.app;
import com.uregina.exception.*;
import java.util.ArrayList;

public class RiskCodeMap 
{
	private char[][] riskCode;
	public RiskCodeMap() 
	{
		riskCode = new char[20][10];
		for (int i=0;i<20;i++){
			for(int j=0;j<10;j++){
				this.riskCode[i][j]='N';		//N for not set, could intialize to G
			}
		}
	}
    
	/**
	*
	* @return boolean: true if the function could update the risk code in that region 
	*/
	public boolean updateRiskInARegion(int VIndex,int HIndex,int caseCount,ArrayList<Integer> neighboursCaseCount)
	{
		// CHECK BOUNDS ON INDEX
		if(VIndex <0)return false;
		if(HIndex <0 || HIndex>= 10)return false;
		// CHANGE ASCII CHAR VALUES FROM POSTAL CODE
		if(VIndex >= 65 && VIndex <= 84) VIndex = VIndex - 65;
		// CHECK MINIMUM VALUE BEFORE DECREMENTING

		if (caseCount<0){
			return false;
		}
		for (int i=0;i<neighboursCaseCount.size();i++){
			if (neighboursCaseCount.get(i)<0){
				return false;
			}
		}
		
		//char currentRisk = this.riskCode[VIndex][HIndex];
		int avgNeighbourCount;
		int totalNeighboursCaseCount = 0;
		int greatestCount;
		for (int i=0;i<neighboursCaseCount.size();i++){
			totalNeighboursCaseCount += neighboursCaseCount.get(i);
		}
		avgNeighbourCount = totalNeighboursCaseCount / neighboursCaseCount.size();	//integer division, some inforamtion may be lost
		if (avgNeighbourCount > caseCount){
			greatestCount = avgNeighbourCount;
		}
		else {
			greatestCount = caseCount;
		}
		
		if (greatestCount == 0){
			this.riskCode[VIndex][HIndex] = 'G';
		}
		if ((greatestCount > 0) && (greatestCount < 4)){
			this.riskCode[VIndex][HIndex] = 'B';
		}
		if ((greatestCount > 3) && (greatestCount < 8)){
			this.riskCode[VIndex][HIndex] = 'Y';
		}
		if ((greatestCount > 7) && (greatestCount < 11)){
			this.riskCode[VIndex][HIndex] = 'O';
		}
		if (greatestCount > 10){
			this.riskCode[VIndex][HIndex] = 'R';
		}
		
		return true;
	}

	public char getRiskInARegion(int VIndex,int HIndex) throws IndexOutOfBoundsException
	{
			// CHECK BOUNDS ON INDEX
			if(VIndex <0)return '\0';
			if(HIndex <0 || HIndex>= 10)return '\0';
			// CHANGE ASCII CHAR VALUES FROM POSTAL CODE
			if(VIndex >= 65 && VIndex <= 84) VIndex = VIndex - 65;
			// CHECK MINIMUM VALUE BEFORE DECREMENTING
		return riskCode[VIndex][HIndex];
	}
}
