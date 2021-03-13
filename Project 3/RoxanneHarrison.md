<h2 align="center">Project 3 - Continuous Integration Summary</h2>
<h3 align="center">Roxanne Harrison</h3>
<p align="center">200 333 074</p>

---
**Installation**  
I began working on this project by installing Jenkins on my local machine.  After several hours of tutorials and over 50 test builds I was able to get a working pipeline connected to our Github using ssh keys and java commands.  This would be the initial script the team used to build upon for creating the final Maven based Jenkinsfile seen in our current repository.  

<details>
<summary>Click to see my branch pipeline script</summary>

```javascript
pipeline {

    agent any
    stages {

        stage('Checkout Codebase'){
            steps{
                cleanWs()
                checkout scm: [$class: 'GitSCM', branches: [[name: '*/roxanne']],userRemoteConfigs:
                [[credentialsId: 'github-ssh-key', url: 'git@github.com:rishabhprasad/ENSE375GroupA.git']]]
            }
        }

        stage('Build'){
            steps{
                sh 'mvn compile -f RiskMeter/pom.xml'
            } 
        }

        stage('Test'){
            steps{
                sh 'mvn test -f RiskMeter/pom.xml'
                
               
        }
       }
    }

}
```
</details>

**Implementation**    
The class I chose to implement was:  
```javascript
PatientHistogram
```
After reviewing the app code and requirements I determined the following considerations for implementation: 
1. The region is a rectangle with bounds [20][10]  
2. The Vertical and Horizontal indices should consider character integer input due to the `PostalCode.java` class  

The constructor creates a simple 2D array with the required boundaries: 

```javascript
private int MAX_VINDEX = 20;
private int MAX_HINDEX = 10;
public PatientHistogram() 
{
this.patientCount = new int[MAX_VINDEX][MAX_HINDEX];
}
```
Because there are no input to this function it was not tested in the `PatientHistogramTest.java` class.  

Next the `addAPatientToRegion` function was implemented with Vertical and Horizontal char input considerations.  
The patient count for risk factor can go to infinity so there is no maximum count to consider.
Both VIndex and HIndex cannot be less than 0, therefore a patient is not added to that region.  
Note that since the `PostalCode.java` VIndex function returns integer values of chars, they must be converted here by subtracting 65. 
```javascript
public boolean addAPatientToRegion(int VIndex,int HIndex)
{
...
}
```
<details>
<summary>Click to see the entire function</summary>

```javascript
public boolean addAPatientToRegion(int VIndex,int HIndex)
{
    // CHECK BOUNDS ON INDEX
    if(HIndex <0 || HIndex>= MAX_HINDEX)return false;
    if(VIndex <0)return false;
    if(VIndex >= MAX_VINDEX && VIndex < 65)return false;
    if(VIndex > 84)return false;
    // CHANGE ASCII CHAR VALUES FROM POSTAL CODE
    if(VIndex >= 65 && VIndex <= 84) VIndex = VIndex - 65;
    // INCREMENT THE COUNT IN THAT REGION
    int count = patientCount[VIndex][HIndex];
    count++;
    patientCount[VIndex][HIndex] = count;
    // NO MAX TO CONSIDER THEREFORE RETURN TRUE
    return true;
}
```
</details>

The following test table was used to verify all variables:  
| Function           | Description      | Input  | Expected Output | Actual Output | Confirmation |
| -------------------|------------------|--------| ----------------| --------------|--------------|
| addPatientToRegion | validIndex       | 15,5   | True            | True          | Pass         |
| addPatientToRegion | validCharIndex   | 'A', 5 | True            | True          | Pass         |
| addPatientToRegion | invalidCharIndex | 'Z', 5 | False           | False         | Pass         |
| addPatientToRegion | invalidVIndex    | 20, 1  | False           | False         | Pass         |
| addPatientToRegion | invalidHIndex    | 1, 10  | False           | False         | Pass         |  

The `deleteAPatientFromRegion` function implements the same index checking logic as the add patient function, with 0 min and maximum bound values.  As explained above, the VIndex must be converted from an ascii value coming from `PostalCode.java`  

```javascript
public boolean deleteAPatientFromRegion(int VIndex,int HIndex)
{
...
}
```
<details>
<summary>Click to see the entire function</summary>

```javascript
public boolean deleteAPatientFromRegion(int VIndex,int HIndex)
{
	 // CHECK BOUNDS ON INDEX
	 if(HIndex <0 || HIndex>= MAX_HINDEX)return false;
	 if(VIndex <0)return false;
	 if(VIndex >= MAX_VINDEX && VIndex < 65)return false;
	 if(VIndex > 84)return false;
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
```
</details>
The difference with this function is with the decrement. The count of patients cannot go below zero.  Unless there are patients to be decremented, trying to decrement 0 will return false.  

The following test table was used to verify all variables:  
| Function                 | Description      | Input  | Expected Output | Actual Output | Confirmation |
| -------------------------|------------------|--------| ----------------| --------------|--------------|
| deleteAPatientFromRegion | validDecrement   | 15,5   | True            | True          | Pass         |
| deleteAPatientFromRegion | invalidDecrement | 15,5   | False           | False         | Pass         |
| deleteAPatientFromRegion | invalidCharIndex | 'Z', 5 | False           | False         | Pass         |
| deleteAPatientFromRegion | invalidVIndex    | 20, 1  | False           | False         | Pass         |
| deleteAPatientFromRegion | invalidHIndex    | 1, 10  | False           | False         | Pass         |  


The `getPatientsCountInRegion` function differs from the previous ones because it is able to throw an `IndexOutOfBoundsException`. The bounds checking contains the same logic as the previous functions only instead of returning false upon error, it will throw an exception. 

```javascript
public int getPatientsCountInRegion(int VIndex,int HIndex) throws IndexOutOfBoundsException
{
...
}
```
<details>
<summary>Click to see the entire function</summary>

```javascript
public int getPatientsCountInRegion(int VIndex,int HIndex) throws IndexOutOfBoundsException
{
    // CHECK BOUNDS ON INDEX
    if(HIndex <0 || HIndex>= MAX_HINDEX) throw new IndexOutOfBoundsException();
    if(VIndex <0)throw new IndexOutOfBoundsException();
    if(VIndex >= MAX_VINDEX && VIndex < 65)throw new IndexOutOfBoundsException();
    if(VIndex > 84)throw new IndexOutOfBoundsException();
    // CHANGE ASCII CHAR VALUES FROM POSTAL CODE
    if(VIndex >= 65 && VIndex <= 84) VIndex = VIndex - 65;
    int count = patientCount[VIndex][HIndex];
    return count;
}
```
</details>

The following test table was used to verify all variables:  
| Function                 | Description      | Input  | Expected Output           | Actual Output             | Confirmation |
| -------------------------|------------------|--------| --------------------------| --------------------------|--------------|
| getPatientsCountInRegion | validCount       | 15,5   | 1                         | 1                         | Pass         |
| getPatientsCountInRegion | invalidCharIndex | 'Z', 5 | IndexOutOfBoundsException | IndexOutOfBoundsException | Pass         |
| getPatientsCountInRegion | invalidVIndex    | 20, 1  | IndexOutOfBoundsException | IndexOutOfBoundsException | Pass         |
| getPatientsCountInRegion | invalidHIndex    | 1, 10  | IndexOutOfBoundsException | IndexOutOfBoundsException | Pass         | 

All 14 tests pass when running the Jenkinsfile. 

**Review**    
The class I chose to review was:  
```javascript
Patient
```
We did some pair programming on the test file for `Patient.java` so I didn't feel the need to create an additional test file since I was part of the intitial testing process here.  
This class is a little more complicated because in order to create a patient, you first need to create a postal code which requires a try/catch block. Some of the duplicated code for creating a postal code object could be moved to a @BeforeAll class as a potential improvement.  
Test names may be improved by more strictly following the **MethodName_StateUnderTest_ExpectedBehavior** convention.  For instance: 

```javascript
    @Test
    public void patient_ID_Valid()
    {
        try
        {
        PostalCode postalCode = new PostalCode("K1A-0B9");
        Patient patient = new Patient("Kaden","123456789",12,postalCode);
        assertTrue(true);
        }
        catch (InvalidPostalCodeException | InvalidNameException | InvalidAgeException | InvalidIDException e)
        {}
    }
```
Could be improved by changing the name to PatientConstructor_validInput_True.  
There are a variety of test cases for the constructor that individually test first the name, then id, then age, and finally postal code in seperate classes.  This makes the tests easy to read and understand and ensures that each input variable is checked for validity. There are no test cases for setAge and setPostalCode so this is another potential improvement. 