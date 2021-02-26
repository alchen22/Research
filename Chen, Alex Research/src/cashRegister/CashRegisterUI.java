package cashRegister;

import java.util.Scanner;
import java.text.NumberFormat;

public class CashRegisterUI

{    
	NumberFormat nf1 = NumberFormat.getCurrencyInstance();
	private Scanner fromKeyboard;
	private CashRegister register;

    /**
     * Constructs a CashRegisterUI ready to start a transaction.
     */
    public CashRegisterUI()
    {
    	register = new CashRegister();
    	fromKeyboard = new Scanner(System.in);
    }
    /**
     * Accepts a valid price from the user
     * or a blank line for no more items.
     * @return a valid price or -1 if no more items
     */

    double acceptValidPrice() 
    {
    	System.out.println("Please enter the price of your item (blank to terminate): ");
    	String input = fromKeyboard.nextLine();

	    while((isDouble(input) == false || Double.parseDouble(input) < 0) && input.isEmpty() == false)
	   	{
	    	System.out.println("ERROR, enter valid price: "); 		
		   	input = fromKeyboard.nextLine();	
	   	}

    	if(input.isEmpty() == true)
    	{
    		return -1;
    	}

    	return Double.parseDouble(input);

    }

    

    /**
     * Accepts all items from the user.
     * Displays total when finished accepting items
     */
    void acceptAllItemsAndDisplayTotal() // package access for testing
    {
    	int itemCounter = 0;
    	double price = acceptValidPrice();
    	
    	while (itemCounter == 0 && price == -1)
    	{
    		System.out.println("You must at least input 1 item");
    		price = acceptValidPrice();
    		if(price != -1)
    		{
    			register.addItem(price);
    			price = 0;
    		}
    	}

    	itemCounter++;

    	while(itemCounter == 1 && price != -1)
    	{
			register.addItem(price);
			price = 0;
    		price = acceptValidPrice();
    	}

    	System.out.println("Your cost is: $" + register.getTotal());
    	System.out.println("Your tax is: " + nf1.format(register.getTax()));
    	System.out.println("Your total cost is: " + nf1.format(register.getTotalWithTax()));
    }


    void acceptValidPaymentAndDisplayChange() // package access for testing
    {
    	System.out.println("Input valid Payment: $");
    	String payment = fromKeyboard.nextLine();

    	 while((isDouble(payment) == false || Double.parseDouble(payment) < register.getTotalWithTax()))
 	   	{
 	    	System.out.println("ERROR, enter valid payment"); 		
 		   	payment = fromKeyboard.nextLine();	
 	   	}
    	 
    	 while((isDouble(payment) == false || Double.parseDouble(payment) < register.getTotal()))
 	   	{
 	    	System.out.println("ERROR, enter valid payment"); 		
 		   	payment = fromKeyboard.nextLine();	
 	   	}

    	 System.out.println("Your change is " + nf1.format(register.acceptPayment(Double.parseDouble(payment) - register.getTax())));

    }



    /**
     * Conducts a single transaction including accepting
     * items, accepting payment and making change.
     */

    public void conductTransaction()
    {
    	acceptAllItemsAndDisplayTotal();
    	acceptValidPaymentAndDisplayChange();
    }

    /**
     * Returns true if value can be parsed to a double, false otherwise.
     * @param value the value to check
     * @return true if value can be parsed to a double, false otherwise.
     */

    private static boolean isDouble(String value)
    {
        try
        {
            Double.parseDouble(value);
        }

        catch(NumberFormatException e)
        {
            return false;
        }
        
        return true;
    }
    
}