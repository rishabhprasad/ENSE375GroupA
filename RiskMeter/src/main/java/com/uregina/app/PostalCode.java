package com.uregina.app;
import com.uregina.exception.*;

public class PostalCode 
{
	private String postalCode;
    	public static boolean isValidPostalCode(String postalCode)
    	{
			int postalCodeLength = 7;

		
			if (postalCode.length() != postalCodeLength) {
				return false;
			}
  
			String fixedPrefix = postalCode.substring(0, 2);
			char verticalIndex = postalCode.charAt(2);
			char separator = postalCode.charAt(3);
			int horizontalIndex = postalCode.charAt(4);
			char upperCaseLetter = postalCode.charAt(5);
			int digit = postalCode.charAt(6);
  
			if (!fixedPrefix.contains("K1")) {
				return false;
			}
  
			if (verticalIndex < 'A' || verticalIndex > 'T') {
				  return false;
			}
  
			if (separator != '-') {
				return false;
			}
  
			if (horizontalIndex < '0' || horizontalIndex > '9') {
				return false;
			}
  
			if (upperCaseLetter < 'A' || upperCaseLetter > 'Z') {
				return false;
			}
  
			if (digit < '0' || digit > '9') {
				return false;
			}
  
			 return true;
    	}
    	public PostalCode(String postalCode) throws InvalidPostalCodeException
    	{	
			this.postalCode = postalCode;
			if(!isValidPostalCode(postalCode)) throw new InvalidPostalCodeException();
    	}
    	public int getRegionVerticalIndex()
    	{
	    	return this.postalCode.charAt(2);
    	}
    	public int getRegionHorizontalIndex()
    	{
    		return Integer.parseInt(this.postalCode.substring(4,5));
    	}
    	public String getPostalCode()
    	{
    		return this.postalCode;
    	}
}

