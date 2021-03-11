package com.uregina.app;
import com.uregina.exception.*;
import java.util.ArrayList;

//ENSE 375 - March 12th, 2021
//Project Step 3 CI - Part 2
//GROUP A
//Roxanne Harrison - 200333074
//
public class PatientHistogram 
{
	private int[][] patientCount;
    	public PatientHistogram() 
    	{
			// THE CITY SHAPE IS ASSUMED TO BE A RECTANGLE WHICH IS DIVIDED INTO
			// 		20x10 REGIONS
			this.patientCount = new int[20][10];
    	}
    /**
	*
	* @return boolean: true if the a patient can be added from that region 
	*/
    	public boolean addAPatientToRegion(int VIndex,int HIndex)
    	{
			// CHECK BOUNDS ON INDEX
			if(VIndex <0 || VIndex>= 20) return false;
			if(HIndex <0 || HIndex>= 10)return false;
			
			// INCREMENT THE COUNT IN THAT REGION
			int count = patientCount[VIndex][HIndex];
			count++;
			patientCount[VIndex][HIndex] = count;
    		return true;
    	}
	/**
	*
	* @return boolean: true if the a patient can be removed from that region 
	*/
    	public boolean deleteAPatientFromRegion(int VIndex,int HIndex)
    	{
    		// DECREMENT THE COUNT IN THAT REGION
			int count = patientCount[VIndex][HIndex];
			count--;
			patientCount[VIndex][HIndex] = count;
    		
    		return true;
    	}
    	public int getPatientsCountInRegion(int VIndex,int HIndex) throws IndexOutOfBoundsException
    	{
    		return patientCount[VIndex][HIndex];
    	}
}
