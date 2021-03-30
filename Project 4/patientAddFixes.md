To postal code initalization invalid catch
`return false;`

to patient ititalization invalid id exception
`return false;`

to patient intialization
```java
catch(NullPointerException e){
    		System.out.println( "\tNull Pointer Exception" );
    		return false;
    	}
```


To RiskCodeMAp.java
Changed the functionaly of updateRiskInARegion from returning false if a change was not made and if an invalid input was given to only returning false on invalid inputs

To PostalCode.java
`if (postalCode == null) throw new InvalidPostalCodeException();`

Made changes so two patients with same ID cannot be added.

Added Horizontal and Vertical index (histogram) edge cases in addPatient.
```java
	int caseCount=histogram.getPatientsCountInRegion(VIndex,HIndex);
    	ArrayList<Integer> neighboursCaseCount= new ArrayList<Integer> ();
		
    	for (int i=-1;i<=1;i+=2){
			//Edge case if First vertical then neighbour is the end square. have to reroute it.
			if (VIndex == 65 && i== -1)
			{
			neighboursCaseCount.add(histogram.getPatientsCountInRegion(84,HIndex));
			}
			//Edge Case end, return back to A (65).
			else if(VIndex == 84 && i == 1)
			{
	
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(65,HIndex));
			}
			else{
				neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex+i,HIndex));
			}
		}
    	for (int i=-1;i<=1;i+=2){
			//Edge case if First horizontal then neighbour is the end square. have to reroute it.
			if (HIndex == 0 && i == -1)
			{
    		neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex,9));
			}
			//Edge Case end, return back to A (0).
			else if(HIndex == 9 && i == 1)
			{
				neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex,0));
			}
			else
			neighboursCaseCount.add(histogram.getPatientsCountInRegion(VIndex,HIndex+i));
		
		}

```
