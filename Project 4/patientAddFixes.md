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

TODO:
should adding two patients with the same ID be illegal?