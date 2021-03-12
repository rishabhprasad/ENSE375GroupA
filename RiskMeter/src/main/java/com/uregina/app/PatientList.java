package com.uregina.app;
import com.uregina.exception.*;
import java.util.ArrayList;
import java.util.regex.*;
//ENSE 375 - March 12th, 2021
//Project Step 3 CI - Part 2
//GROUP A
//Kaden Goski - 200392031
//


public class PatientList
{
    private ArrayList<Patient> patientList;
    public PatientList()
    {
        //ToDo: add you code here
        this.patientList = new ArrayList<>();
    }
    /**
     *
     * @return boolean: true if the patient can be added to the list
     */
    public boolean addPatient(Patient patient) {
        if (patient == null)
        {
            return false;
        }
        patientList.add(patient);
                return true;  
    }
    /**
     *
     * @return boolean: true if the patient is removed from the list
     */
    public boolean deletePatient(int index)
    {
        //ToDo: add you code here
        //index starts at 0, size starts at 1. minus 1 from size.
        if (patientList.size()-1 <= index)
        {
            patientList.remove(index);
            return true;
        }
        return false;
    }
    public Patient getPatient(String ID)
    {
        //ToDo: add you code here
        //ID must be 9 long and have atleast 1 non zero digit, cant be all zeroes.
 
        String IDCheck = "/([0-9]{9})/";
        Boolean IDFormat = Pattern.matches(IDCheck,ID);
        
        
        if ((ID.length() == 9) && (!(ID.equals("000000000"))) && IDFormat) {
            //Go through the list
            for (int i = 0; i < patientList.size(); i++) {
                //If ID equals the patient id from the patient at the index position in the list
                if (ID.equals(patientList.get(i).getID())) {
                    //return the patient that matches.
                    return (patientList.get(i));
                }
            }
        }
        return null;
    }
    public int getNumberofPatients()
    {
        //ToDo: add you code here (you can update the return statement)
        return patientList.size();
    }
}