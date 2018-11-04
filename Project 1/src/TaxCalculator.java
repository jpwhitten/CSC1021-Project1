// Author: Joseph Whitten
// Date: 6/11/2014
// Purpose: To calculate the tax on a given income, and the remaining income on a given income after tax

public class TaxCalculator {
		
	/* I have declared a multidimensional array to store information on each tax bracket (tax bracket for values under £101 has been ignored as there is no tax on this bracket)
	 * Each row represents a tax bracket and the columns are arranged such that {lower bound of tax bracket, tax rate per pound for this bracket}
	 * I have made the array of type double in order to store values with decimals 
	 * I Have also made the array private so that it can not be tampered with by external classes and have given it the keyword final so that its values can not be changed from within the class 
	 */
	private static final double[][] taxBracketsAndRates = 
	{
		{401, 1.2}, 
		{301, 0.6}, 
		{201, 0.4},
		{151, 0.2},
		{101, 0.1}
	}; 
	
	// This method takes in an integer for the input and calculates the exact tax payable on the input, it then rounds the exact tax to the nearest integer and returns that integer
	public static int taxPayable(double inputIncome)
	{
		// Declared an integer equal to the input in order to perform calculations on
		double income = inputIncome; 
		// Declared a double to store the exact tax on the input
		double tax = 0; 
		//A for loop that will iterate a number of times equal to the length of the taxBracketsAndRates array (all tax bands)
		for(int i = 0; i < taxBracketsAndRates.length; i++) 
		{
			// Checks to see if the income is above the lower bound of the current tax bracket "i"
			if(income > taxBracketsAndRates[i][0]) 
			{
				//Calculates the amount by which the income is over the current tax bracket and charges the appropriate tax, then adds that tax to the total for that income   
				tax += (income - taxBracketsAndRates[i][0] + 1) * taxBracketsAndRates[i][1]; 
				// Subtracts the income that has been taxed thereby moving the income into the next (one lower) tax bracket ready to be taxed again
				income -= (income - taxBracketsAndRates[i][0] + 1); 
			}
		}
		// Once all sections of the income have been taxed the exact tax is rounded to the nearest integer and assigned to "roundedTax"
		int roundedTax = (int) Math.round(tax); 
		if(roundedTax > inputIncome)
			// Makes sure tax does not exceed income 
			roundedTax = (int) inputIncome; 
		//returns the rounded tax
		return roundedTax; 
	}	
	
	// This method takes the input as the income and then uses the "taxPayable" method to calculate the income remaining after tax then returns this value
	public static double remainingIncome(double inputIncome)
	{
		// Declared a integer equal to the input to perform calculations on, and gave it the final keyword to make sure it can't be changed
		final double INCOME = inputIncome; 
		//Used the "taxPayable" method to calculate the tax on the input and subtracted it from the input to calculate the remaining income, assigned it to a new integer with the final keyword so it can be changed
		final double REMAINING_INCOME = (INCOME - taxPayable(INCOME)); 
		// Return the remaining income 
		return REMAINING_INCOME; 
	}
}