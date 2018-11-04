// Author: Joseph Whitten
// Date: 6/11/2014
// Purpose: To initialise the variables and call the methods necessary to run the program correctly 

public class BogOff {

	public static void main(String[] args) 
	{
		// Call the tax tables method
		taxTables(); 
	}
	
	/* This method initialises a new double array "incomeArray" that will be used to store the incomes that will be used to calculate tax and draw the graphs
	 * It then declares a new instance of the TaxChart class using the "incomeArray" as an input parameter, and calls the two methods in TaxChart (draw() & printTable()) using this new instance 
	 */
	public static void taxTables() 
	{
		// This array stored the values that will be taxed and graphed (The inputSet)
		double[] incomeArray = {25, 50, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 500, 550}; 
		// Create a New instance of the TaxChart object using the incomeArray as the parameter
		TaxChart taxes = new TaxChart(incomeArray); 
		// Print the table
		taxes.printTable();
		// Draw the graph
		taxes.draw(); 
	}	
}