## ENSE 370 Project 3 - Continuous Integration
---
Zhuo Chen 200352092

## Implementation and Test Cases
---
The class that I implemented is Patient

Firstly, I implemented Constructor for Patient patient(name,id,name,postalcode), then a number of get() functions to get each values. Lastly, I implemented two set() functions to modify the patient's age and postcode. 

The test casees I built are:
- ** patient_Name_Valid()**: In this case, all the parameters are correct and it retuens true.
- ** patient_Invalid_Name_Exception()**: If the input name contains special symbols, throw to Exception.
- ** patient_Invalid_Name_Null()**: If the input name is null, throw to Exception.
- ** patient_ID_Valid()**: The input id is correct, and return true.
- ** patient_Invalid_ID_Exception()**: The input id contains "0", throw to Exception.
- ** patient_Invalid_ID_Character_Exception()**: The input id contains non-numerical charater, throw to Exception.
- ** patient_Invalid_ID_Null()**: The input id is null, throw to Exception.
- ** patient_Invalid_Age_Exception()**: The input age is over 110, throw to Exception.

---
Assumptions:
- Allow the operator to modify the age and postcode even if new inputs are the same as stored information.

## RiskCodeMapTest Test Cases
---
The RiskCodeMapTest Test Cases overall are good. The main test case that Bryden focused on is the getRiskInARegion function. He contains all the cases that I could think of. For both true and false test cases, he tends to use the same inputs to verify each test case. 