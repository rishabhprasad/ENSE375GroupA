<h1 align="center">Project Group A</h1>
<p align="center">ENSE 375 - Winter 2021</p>

---
**Members**
- [Zhuo Chen](Project%203/ZhuoChen.md)   
```javascript
// IMPLEMENTED
Patient
// REVIEWED
RiskCodeMap
```
- [Kaden Goski](Project%203/KadenGoski.md)
```javascript
// IMPLEMENTED
PatientList
// REVIEWED
PostalCode
```
- [Roxanne Harrison](Project%203/RoxanneHarrison.md) 
```javascript
// IMPLEMENTED
PatientHistogram
// REVIEWED
Patient
```
- [Rishabh Prasad](Project%203/RishabhPrasad.md)
```javascript
// IMPLEMENTED
PostalCode
// REVIEWED
PatientList
```  
- [Bryden Trakalo](Project%203/BrydenTrakalo.md)
```javascript
// IMPLEMENTED
RiskCodeMap
// REVIEWED
PatientHistogram
```

**Installation**  
We started off the project with getting Jenkins installed on our local machines.  Once this was completed we had a group meeting to properly set up an initial pipeline using java commands and an ssh key to connect to Github.  After lots of struggles with the repository paths we updated the pipeline script to function with maven commands.  Many team members had local machine troubles after this with installing mvn in the correct path or getting their Docker container to work.  These problems were solved and our group ultimately had a working pipeline with stages: 
1. Code checkout
2. Build
3. Test  

There was research and discussion over port forwarding or running a single instance of Jenkins for our team to log in to but in the end due to firewall restrictions we decided to individually run our pipeline locally.  This worked fine for the purposes of this activity.  Our groups final pipeline can be seen in:  
[Jenkinsfile](Jenkinsfile)  
**Implementation**  
Each group member implemented their respective classes, created appropriate test cases and ran their pipeline.  During group meetings we would discuss different implementation and test ideas and did a bit of pair programming when necessary.  After over 400 cumulative Jenkins pipeline builds, our groups files were successfully integrated into the __master__ branch of our repository.  