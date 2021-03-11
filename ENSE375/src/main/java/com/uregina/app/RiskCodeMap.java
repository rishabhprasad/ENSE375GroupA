package com.uregina.app;
//import com.uregina.exception.*;
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
		boolean updateRisk= false;
		char currentRisk = this.riskCode[VIndex][HIndex];
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

		switch (currentRisk){
			case 'N':
				updateRisk = true;
			break;
			case 'G':
				if (greatestCount > 0){
					updateRisk = true;
				}
			break;
			case 'B':
				if ((greatestCount < 1) || (greatestCount > 3)){
					updateRisk = true;
				}
			break;
			case 'Y':
				if ((greatestCount < 4) || (greatestCount > 7)){
					updateRisk = true;
				}
			break;
			case 'O':
				if ((greatestCount < 8) || (greatestCount > 10)){
					updateRisk = true;
				}
			break;
			case 'R':
			if (greatestCount < 10){
				updateRisk = true;
			}
			break;
			default:
				//Shouldnt ever go here
			break;
		}
		if(updateRisk){
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
		}
		return updateRisk;
	}

	public char getRiskInARegion(int VIndex,int HIndex) throws IndexOutOfBoundsException
	{
		return riskCode[VIndex][HIndex];
	}
}
