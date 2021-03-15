**ENSE 375 - Project Step 3- Continuous Integration**
Kaden Goski - 200392031 - March 15, 2021

By far the most stressful and difficult part of this project step was getting Jenkins setup with a Maven Pipeline. **We ran into major syntax issues with the pipeline script syntax and code. It turns out that this was rather simple to solve and it was all down to our lack of experience. Once we understood how to write the scripts it was smooth sailing.**
 
Implementation and Test Cases
--------------------------------------------------------
My class file for this project was **PatientList.** 

  First, I implemented it to just do the basic tasks, i.e; In the addPatient method: "patientList.add(patient) return true;" and that is all. 
  
   After that, I implemented tests with what should fail for each method and what should pass once everything was working correctly.  **These tests were:**
   
--------------------------------------------------------
 - **PatientList_Successful_Add -**> Succesfully add a patient to the list. Also inherently handles the case if it fails. I couldn't get it to fail since Patient class was handling all the possible errors I could pass along to this.
 - **DeletePatient_True** -> Add a patient to the list and then delete the patient at index 0.
 - **DeletePatient_Fail** -> Add a patient to list and then try to delete at index 2.
 - **getPatient_InvalidID_Fail** -> Add a patient to list, try to search for patient in getPatient using an invalid ID (000000000).
 - **getPatient_ID_Fail** -> Add a patient to list, try to search for them using a valid but not existing ID.
 - **getPatient_ID_Success** -> Add a patient to list, search and get the patient using their ID.
 - **getNumOfPatients_Success** -> Add two patients to list, call getNumberOfPatients, output should be 2.
 - **getNumOfPatients_Empty** -> Call getNumberOfPatients on an empty list. Ouput should be 0.
-----------------------------------------------------------------------------
  

   Something like getPatient(ID) I decided should be able to handle incorrect ID entries and just return null right away rather than wasting resources. Unfortunately, my first couple rounds of code, everything would fail as I had a null pointer issue somewhere along the line. 

Slowly, but surely, I added and implemented more and more logic into my methods, with format checking and null checks being the main issues in getPatient and deletePatient.

Once most of my tests were passing, I realized that I could clean them up by creating and running a @BeforeClass to instantiate the patients and postal codes as well as handle all the exception catches that were needed.

----------------------------------------------------------------------

## **Review of PostalCode Test Class**
This test class was created by Risabh Prasad. Looking at it, I can understand what each test case does and why it passes/fails. I like how he used assertThrows to take advantage of the original implementation that had the constructor throwing exceptions and implemented these throws with formatting logic.

His tests overall are very good. I couldn't find a big gap in them or anything that would cause the class to fail. However, he could add a test that has an input that is too long for a postal code. (This error looks to be already handled in the code.)
