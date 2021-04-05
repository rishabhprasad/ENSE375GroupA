package com.uregina.exception;
import java.io.*;

public class DuplicateIDException extends Exception{

    /**
    * This exception is thrown when a duplicate patient ID is entered
    *
    */
        private String ID;
        
        public DuplicateIDException(String ID){
            super("\""+ID+"\" already exists on the PatientList.");
            this.ID=ID;
        }
        public String getTheDuplicateID(){
            return ID;
        }
    }   

