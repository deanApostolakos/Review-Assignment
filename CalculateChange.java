



public class CalculateChange {


    // getChange method calculates the change of a transaction by taking the product price and the input money
	// This method also calls the error message pop-up if an error occurs
	public static double getChange(double productPrice, String userMoneyInput)
	{

		// 
		String message = "";
		double moneyIn = 0.0;

		// Checks if the input is a number with no letters
		try
		{
			moneyIn = Double.parseDouble(userMoneyInput);
		}
		// If there is a letter in the input
		catch (NumberFormatException e)
		{
			message = "You didn't put any money.";
			GameMessage.display(message);

			return -100;
		}

		// If the user enters a negative value
		if (moneyIn < 0)
		{
			message = "This is not a Bank.\nYou can't take out money";
			GameMessage.display(message);

			return -100;
		}
		else
		{
			double change = 0.00;
			// Calculate change
			change = moneyIn - productPrice;
			
			// If the change is between 0 and the negative product price the user didnt put enough money
			if (change > - productPrice && change < 0)
			{
				message = "You didn't put enough money.";
				GameMessage.display(message);

				return -100;
			}
			// If the change is equal to the negative product price, the user didnt put any money
			else if (change == - productPrice)
			{
				message = "You didn't put any money.";
				GameMessage.display(message);

				return -100;
			}
			// Else the money entered is valid and the change amount is returned
			else
			{
				return change;
			}
			

		}
	}
}
