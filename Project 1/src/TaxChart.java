// Author: Joseph Whitten
// Date: 6/11/2014
// Purpose: To produce a graph and table of income, tax and remaining income

import java.awt.Color;

public class TaxChart {

	// Declared an empty array of type integer that will be used to store the incomes 
	public static double[] inputSet; 
	
	// The constructor for the class, instances of this class will require an integer array as a parameter in order to be created 
	public TaxChart(double[] inputSet)   
	{
		// Assigned the value of input set to a new property of the class 'taxChart.inputset"
		TaxChart.inputSet = inputSet; 
	}
	
	// Constants that will dictate the look, position and size of the graph
	static final int BAR_WIDTH = 3;
	static final int AXIS_WIDTH = 1;
	static final int VERTICAL_XAXIS_SHIFT = 200;
	static final int SCALER = 4;
	
	// This method will draw the graph of the incomes and taxes on those incomes
	public static void draw() 
	{
		
		//To start i create the axis of the graph
		//Creates and sets the properties of the xAxis then draws it
		Bar xAxis = new Bar();
		xAxis.makeVisible();
		xAxis.changeColor(Color.BLACK);
		xAxis.changeSize(220, AXIS_WIDTH);
		xAxis.moveVertical(200);
		xAxis.moveHorizontal(-20);
		
		//Creates and sets the properties of the y axis then draws it  
		Bar yAxis = new Bar();
		yAxis.makeVisible();
		yAxis.changeColor(Color.BLACK);
		yAxis.changeSize(AXIS_WIDTH, 220);
		
		//This for loop will iterate through a number of times equal to the length of the input set, allowing for input sets of different sizes to be drawn onto the graph
		for(int i = 0; i < inputSet.length; i++)
		{
			if(inputSet[i] >= 0) // Checks to make sure income is not negative
			{
				// Declared two integers that will be used to set the height of the bars, the for loop will allow for all integers in the input set to be drawn into bars
				// The income bars height will be proportional to the value of the current value in the input set 
				int incomeBarHeight = (int) (TaxCalculator.remainingIncome(inputSet[i]) / SCALER); 
				// The tax bars height will be proportional to the value of the tax payable on the current integer in the input set
				int taxBarHeight = (TaxCalculator.taxPayable(inputSet[i]) / SCALER);  
				
				//Create a new bar for each value in the input set 
				Bar incomeBar = new Bar();
				incomeBar.makeVisible();
				// Move the bar along the x axis an amount proportional to the value of the input set (the income) 
				incomeBar.moveHorizontal((int) (inputSet[i] / SCALER)); 
				// Change the colour of the income bar to yellow 
				incomeBar.changeColor(Color.YELLOW);  
				// Make the width of the bar 3 and the height equal to the income height 
				incomeBar.changeSize(BAR_WIDTH, incomeBarHeight); 
				// Place the bar on the x axis
				incomeBar.moveVertical(VERTICAL_XAXIS_SHIFT - incomeBarHeight); 
				
				// Create a new bar for the value of the tax payable on each value of the input set 
				Bar taxBar = new Bar();
				taxBar.makeVisible();
				// Move the bar an amount proportional to the value of the input set (the income) 
				taxBar.moveHorizontal((int) (inputSet[i] / SCALER)); 
				 // Change the colour of the tax bar to red to distinguish it from the income 
				taxBar.changeColor(Color.RED);  
				// Change the width of the bar to be 3 and the height equal to the tax height
				taxBar.changeSize(BAR_WIDTH, taxBarHeight); 
				//Place the tax bar at the top of its respective income bar
				taxBar.moveVertical((VERTICAL_XAXIS_SHIFT - incomeBarHeight - taxBarHeight));  
			}
			else
			{
				// Do nothing with this value (skip)
			}
		}
		
	}
	
	// This method prints a table of incomes from the input set and tax payable on those incomes 
	public static void printTable() 
	{
		// Array storing the headers of each of the columns in the table
		String[] tableHeaders = new String[] {"Income", "Tax", "Remaining Income"};
		// Format and print these headers
		System.out.format("%-11s %-8s %-20s %n", tableHeaders[0], tableHeaders[1], tableHeaders[2]);
		
		//This for loop will loop through the input set
		for(int i = 0; i < inputSet.length; i++)
		{
			// Checks to make sure income is not negative
			if(inputSet[i] >= 0) 
			{
				// Take current value from the input set and assign it to "income" 
				double income = inputSet[i]; 
				// Calculate tax on current value and from the input set
				int tax = TaxCalculator.taxPayable(inputSet[i]); 
				// Calculate remaining income on current value from the input set
				double remainingIncome = TaxCalculator.remainingIncome(inputSet[i]);
				 // Print and format the table
				System.out.format("£%-10.2f £%-7d £%-20.2f %n", income, tax, remainingIncome);
			} 
			else 
			{
				// Print error message if income is negative
				System.out.println("Error at position " + i + " in income set: Income can not be negative"); 
			}
		}
	}
		
}
