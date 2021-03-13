package com.uregina.app;
import com.uregina.exception.*;
import java.util.ArrayList;

//ENSE 375 - March 12th, 2021
//Project Step 3 CI - Part 2
//GROUP A
//Roxanne Harrison - 200333074

public class PatientHistogram 
{
	private int[][] patientCount;
	private int MAX_VINDEX = 20;
	private int MAX_HINDEX = 10;
    	public PatientHistogram() 
    	{
			// THE CITY SHAPE IS ASSUMED TO BE A RECTANGLE WHICH IS DIVIDED INTO
			// 		20x10 REGIONS
			this.patientCount = new int[MAX_VINDEX][MAX_HINDEX];
    	}
    /**
	*
	* @return boolean: true if the a patient can be added from that region 
	*/
    	public boolean addAPatientToRegion(int VIndex,int HIndex)
    	{
			// CHECK BOUNDS ON INDEX
			if(HIndex <0 || HIndex>= MAX_HINDEX)return false;
			if(VIndex <0)return false;
			if(VIndex >= MAX_VINDEX && VIndex < 65)return false;
			// CHANGE ASCII CHAR VALUES FROM POSTAL CODE
			if(VIndex >= 65 && VIndex <= 84) VIndex = VIndex - 65;
			// INCREMENT THE COUNT IN THAT REGION
			int count = patientCount[VIndex][HIndex];
			count++;
			patientCount[VIndex][HIndex] = count;
			// NO MAX TO CONSIDER THEREFORE RETURN TRUE
    		return true;
    	}
	/**
	*
	* @return boolean: true if the a patient can be removed from that region 
	*/
    	public boolean deleteAPatientFromRegion(int VIndex,int HIndex)
    	{
			// CHECK BOUNDS ON INDEX
			if(VIndex <0)return false;
			if(HIndex <0 || HIndex>= MAX_HINDEX)return false;
			// CHANGE ASCII CHAR VALUES FROM POSTAL CODE
			if(VIndex >= 65 && VIndex <= 84) VIndex = VIndex - 65;
			// CHECK MINIMUM VALUE BEFORE DECREMENTING
			int count = patientCount[VIndex][HIndex];
			if(count == 0) return false;
    		// DECREMENT THE COUNT IN THAT REGION
			count--;
			patientCount[VIndex][HIndex] = count;
    		return true;
    	}
	
    	public int getPatientsCountInRegion(int VIndex,int HIndex) throws IndexOutOfBoundsException
    	{
			// CHECK BOUNDS ON INDEX
			if(VIndex <0) throw new IndexOutOfBoundsException();
			if(HIndex <0 || HIndex>= MAX_HINDEX) throw new IndexOutOfBoundsException();
			// CHANGE ASCII CHAR VALUES FROM POSTAL CODE
			if(VIndex >= 65 && VIndex <= 84) VIndex = VIndex - 65;
			int count = patientCount[VIndex][HIndex];
    		return count;
    	}
}
