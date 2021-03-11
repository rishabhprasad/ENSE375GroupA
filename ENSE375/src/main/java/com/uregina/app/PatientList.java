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
        Integer Age = patient.getAge();

        //The patient ID is a 9-digit string with a non-zero digit. 
        String ID = patient.getID();
        String IDCheck = "/([0-9]{9})/";
        Boolean IDFormat = Pattern.matches(IDCheck,ID);

        //Patient name can only contain alphabetic letters as well as spaces and dots. 
        String Name = patient.getName();
        //Check if name is correct in format
        String nameCheck = "/^[a-z\\d\\-_\\s]+$/i";
        boolean isCorrectName = Pattern.matches(nameCheck, Name);

        //The Postal code is given in the following format "K1a-bxy" as: 
        //"K1" is a fixed prefix, 
        //"a" is any letter from 'A' to 'T' to indicate the vertical index of the region, 
        //"b" is a digit from '0' to '9' to indicate the horizontal index of the region, 
        //"x" is any uppercase letter and 
        //"y" is any digit. 
        String PostalCode = patient.getPostalCode().getPostalCode();
        //check if postal code is correct in format.
        String postalCheck = "/(K1)([A-T])(-)([0-9])([A-Z])([0-9])/";
        boolean isValidPostal = Pattern.matches(postalCheck, PostalCode);

        //ToDo: add you code here
        if (isCorrectName && isValidPostal) {
            if (IDFormat && (!(ID.equals("000000000")))) {
                patientList.add(patient);
                return true;
            }
        }
        return false;
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