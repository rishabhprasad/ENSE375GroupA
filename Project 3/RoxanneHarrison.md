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

Next the addPatient function was implemented with Vertical and Horizontal char input considerations.  
The patient count for risk factor can go to infinity so there is no maximum count to consider.
Both VIndex and HIndex cannot be less than 0, therefore a patient is not added to that region.  
Note that since the PostalCode.java VIndex function returns integer values of chars, they must be converted here by subtracting 65. 
```javascript
public boolean addAPatientToRegion(int VIndex,int HIndex)
{
if(VIndex <0)return false;
if(HIndex <0 || HIndex>= MAX_HINDEX)return false;
// CHAR CONSIDERATION
if(VIndex >= 65 && VIndex <= 84) VIndex = VIndex - 65;
// INCREMENT PATIENT COUNT
int count = patientCount[VIndex][HIndex];
count++;
patientCount[VIndex][HIndex] = count;
return true;
}
```