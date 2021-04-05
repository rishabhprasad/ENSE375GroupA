package com.uregina.app;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import com.uregina.exception.*;

import org.junit.Test;
import org.junit.BeforeClass;
import jdk.jfr.Timestamp;

/**
 * Unit test for PatientList.
 */




public class PatientListTest 
{
//Ended up scrapping because it was giving null pointer errors.
  private static  PostalCode postal;
  private static PostalCode postal2;
  private static  Patient patient;
  private static Patient patient2;

   @BeforeClass
   public static  void setup() throws Exception 
    {
     try{
        String id = "123456789";
        int age = 12;
        String name = "Kaden";
        postal = new PostalCode("K1A-0B9");
        patient = new Patient(name,id,age,postal);

        age = 14;
        id = "123456781";
        name = "KadenG";
        postal2 = new PostalCode("K1A-1B9");
        patient2 = new Patient(name,id,age,postal2);

    }
    //need to catch exceptions. This wont fail unless other classes do.
    catch(InvalidNameException e){
        System.out.println( "\tInvalid patient name" );
    }
    catch(InvalidAgeException e){
        System.out.println( "\tInvalid patient age" );
    }
    catch(InvalidIDException e){
        System.out.println( "\tInvalid patient ID" );
    }
    catch(InvalidPostalCodeException e){
        System.out.println( "\tInvalid patient ID" );
    }
    }  
 //   }




    @Test
    public void patientList_Succesful_Add() 
    {          
        PatientList patientList = new PatientList();
       try {
        assertTrue(patientList.addPatient(patient));
       }
       catch(DuplicateIDException e){
        System.out.println( "\tDuplicate Patient ID. Patient ID already exists on list" );
    }
    
    }
    
    @Test
    public void deletePatient_ValidIndex()
    {
        PatientList patientList = new PatientList();
        try {
        patientList.addPatient(patient);
         }
        catch(DuplicateIDException e){
         System.out.println( "\tDuplicate Patient ID. Patient ID already exists on list" );
        }

        assertTrue(patientList.deletePatient(0));
    }


    @Test
    public void deletePatient_InvalidIndex()
    {                   
        PatientList patientList = new PatientList();
        try {
            patientList.addPatient(patient);
             }
            catch(DuplicateIDException e){
             System.out.println( "\tDuplicate Patient ID. Patient ID already exists on list" );
            }
        assertFalse(patientList.deletePatient(2));
    }

    @Test
    public void getPatient_Invalid_ID()
    {   
        PatientList patientList = new PatientList();
        boolean result = false;

        try {
            patientList.addPatient(patient);
             }
            catch(DuplicateIDException e){
             System.out.println( "\tDuplicate Patient ID. Patient ID already exists on list" );
            }

        if (patientList.getPatient("000000000") == null)
        {
         result = true;
        }

         assertTrue(result);
    }
    

    @Test
    //No patient with ID fail..
    public void getPatient_Invalid_ID2() 
    {  
    boolean result = false;
    PatientList patientList = new PatientList();      
    try {
        patientList.addPatient(patient);
         }
        catch(DuplicateIDException e){
         System.out.println( "\tDuplicate Patient ID. Patient ID already exists on list" );
        }

    if (patientList.getPatient("000000022") == null)
    {
        result = true;
    }
    
    assertTrue(result);
    }
   


    @Test
    //No patient with ID fail..
    public void getPatient_Valid_Existing_ID()
    {      
    PatientList patientList = new PatientList();
    boolean result = true;
    try {
        patientList.addPatient(patient);
         }
        catch(DuplicateIDException e){
         System.out.println( "\tDuplicate Patient ID. Patient ID already exists on list" );
        }
    
    Patient patientX = patientList.getPatient("123456789");
    if (patientX.getID() == null)
    {
        result = false;
    }
    
    assertTrue(result);
    }
    
    

    //2
    @Test
    public void getNumOfPatients_Size2()
    {
        
        PatientList patientList = new PatientList();
        

        try {
            patientList.addPatient(patient);
            patientList.addPatient(patient2);
             }
            catch(DuplicateIDException e){
             System.out.println( "\tDuplicate Patient ID. Patient ID already exists on list" );
            }
        


        int number = patientList.getNumberofPatients();

        if(number == 2)
        {
            assertTrue(true);
        }
        else
        {
        assertTrue(false);
        }
    }
    

    @Test
    public void getNumOfPatients_Empty()
    {
        PatientList patientList = new PatientList();

        int number = patientList.getNumberofPatients();

        if(number == 0)
        {
            assertTrue(true);
        }
        else{
        assertTrue(false);
        }
    }


}