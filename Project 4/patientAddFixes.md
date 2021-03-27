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
Changed the functionaly of updateRiskInARegion to return true in all cases expect invalid inputs. 
(used to return false if the risk code map was not updated in a call)

To PostalCode.java
`if (postalCode == null) throw new InvalidPostalCodeException();`

TODO:
should adding two patients with the same ID be illegal?