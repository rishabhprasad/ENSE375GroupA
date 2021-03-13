# Project Step 3- Continuous Integration
Bryden Trakalo 200393397 - March 13

Implementation and Test Cases
----
My class file for this project was RiskCodeMap

  To begin I made the test getRiskInARegion_4_5_true, and wrote the code for RiskCodeMap() and getRiskInARegion(int VIndex,int HIndex) to pass that test.
  After that i built the rest of my tests and finished the class to pass each test. The tests I wrote for RiskCodeMap are:

- **getRiskInARegion_invalidVIndex_throwsIndexOutOfBoundsException** ->input a VIndex that is too large fro the size of the map, throws an execption
- **getRiskInARegion_4_5_true** -> Get the unset value in position 4, 5 which is 'N'
- **getRiskInARegion_4_5_false** -> Get the unset value in position 4, 5 which should not be 'K'
- **updateRiskInARegion_2_0_true** -> Set the caseCount to 2 and the neighbourCaseCount list to 4 0s, should return true
- **updateRiskInARegion_2_0_false** -> Perfrm the steps in updateRiskInARegion_2_0_true and then try to update the map again with the same inputs, should return false
- **getRiskInARegion_G_true** Set caseCount to 4, update the map and then get the risk code from the updated region, should be 'G'
- **getRiskInARegion_O_true** Set caseCount to 9, update the map and then get the risk code from the updated region, should be 'O'
- **getRiskInARegion_O_neightbours_true** Set neighbourscaseaseCount to 4 9s, update the map and then get the risk code from the updated region, should be 'O'
- **getRiskInARegion_R_6_neightbours_true** Set neighbourscaseaseCount to 6 ints averaging above 10, update the map and then get the risk code from the updated region, should be 'R'
----
Some assumptions made:
- The map is 20 tall and 10 wide (instead of 10 tall and 20 wide)
- The map should be intialized to N for not-set instead of G for no risk

Review of Histogram Test Class
----
The Histogram class tests look very good, the many tests cover a great amount of cases. The tests are simple and easily understood.
I could not think of any other tests to add to cover more cases.