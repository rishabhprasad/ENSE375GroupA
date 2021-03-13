<h2 align="center">Project 3 - Continuous Integration Summary</h2>
<h3 align="center">Roxanne Harrison</h3>
<p align="center">200 333 074</p>

---
**Installation**  
I began working on this project by installing Jenkins on my local machine.  After several hours of tutorials and over 50 test builds I was able to get a working pipeline connected to our Github using ssh keys and java commands.  This would be the initial script the team used to build upon for creating the final Maven based Jenkinsfile seen in our current repository.  

**Implementation**    
The class I chose to implement was:  
```javascript
PatientHistogram
```
After reviewing the app code and requirements I determined the following considerations for implementation: 
1. The region is a rectangle with bounds [20][10]  
2. The Vertical and Horizontal indices should consider character integer input due to the PostalCode.java class  

The constructor creates a simple 2D array with the required boundaries: 

```javascript
private int MAX_VINDEX = 20;
private int MAX_HINDEX = 10;
public PatientHistogram() 
{
this.patientCount = new int[MAX_VINDEX][MAX_HINDEX];
}
```
Because there are no input to this function it was not tested in the PatientHistogramTest.java class.  

Next the add patient function was implemented with Vertical and Horizontal char input considerations.  
The patient count for risk factor can go to infinity so there is no maximum count to consider.
Both VIndex and HIndex cannot be less than 0, therefore a patient is not added to that region.  
Note that since the PostalCode.java VIndex function returns integer values of chars, they must be converted here by subtracting 65. 
```javascript
public boolean addAPatientToRegion(int VIndex,int HIndex)
{
...
}
```
The following test table was used to verify all variables:  
| Function           | Description      | Input  | Expected Output | Actual Output | Confirmation |
| -------------------|------------------|--------| ----------------| --------------|--------------|
| addPatientToRegion | validIndex       | 15,5   | True            | True          | Pass         |
| addPatientToRegion | validCharIndex   | 'A', 5 | True            | True          | Pass         |
| addPatientToRegion | invalidCharIndex | 'Z', 5 | False           | False         | Pass         |
| addPatientToRegion | invalidVIndex    | 20, 1  | False           | False         | Pass         |
| addPatientToRegion | invalidHIndex    | 1, 10  | False           | False         | Pass         |  


The delete patient function implements the same index checking logic as the add patient function, with 0 min and maximum bound values.  As explained above, the VIndex must be converted from an ascii value coming from PostalCode.java  

<details>
<summary>Click to see: \`deleteAPatientFromRegion\`</summary>
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

The difference with the decrement function is that the count of patients cannot go below zero.  Unless there are patients to be decremented, trying to decrement 0 will return false.  

The following test table was used to verify all variables:  
| Function                 | Description      | Input  | Expected Output | Actual Output | Confirmation |
| -------------------------|------------------|--------| ----------------| --------------|--------------|
| deleteAPatientFromRegion | validDecrement   | 15,5   | True            | True          | Pass         |
| deleteAPatientFromRegion | invalidDecrement | 15,5   | False           | False         | Pass         |
| deleteAPatientFromRegion | invalidCharIndex | 'Z', 5 | False           | False         | Pass         |
| deleteAPatientFromRegion | invalidVIndex    | 20, 1  | False           | False         | Pass         |
| deleteAPatientFromRegion | invalidHIndex    | 1, 10  | False           | False         | Pass         |  