package cashRegister;

public class CashRegister
{

	private double transaction;
	
    /**
     * Constructs a CashRegister with an active transaction.
     */
    public CashRegister()
    {
        transaction = 0;
    }
    
    /**
     * Adds the item with the specified price to the active transaction.
     * 
     * @param price the item's price
     * Precondition: price >= 0
     */
    public void addItem(double price)
    {
    	transaction += price;
    	
        // TODO: implement addItem
    }
    
    /**
     * Returns the total for the active transaction.
     * 
     * @return the total for the active transaction
     */
    public double getTotal()
    {
        return transaction; // TODO: implement getTotal
    }
    
    /**
     * Accepts payment for the active transaction.
     * Resets for a new transaction.
     * 
     * @param amount the amount the customer paid
     * Precondition: amount >= getTotal()
     * 
     * @return the amount of change
     */
    public double acceptPayment(double amount)
    {
    	double change = 0;
    	
    	change = amount - transaction;
    	
    	transaction = 0;
    	
        return change; // TODO: implement acceptPayment
    }
    
    public double getTax()
    {
    	return transaction * 0.07;
    }
    
    public double getTotalWithTax()
    {
    	return transaction * 1.07;
    }
    
    public void getQuarters()
    {
    	int numOfQuarters = 0;
    	while(transaction >= .25)
    	{
    		numOfQuarters++;
    		transaction-= .25;
    	}
    }
    
    public void getDimes()
    {
    	int numOfDimes = 0;
    	while(transaction >= .10)
    	{
    		numOfDimes++;
    		transaction-= .10;
    	}
    }
    
    public void getNickels()
    {
    	int numOfNickels = 0;
    	while(transaction >= .05)
    	{
    		numOfNickels++;
    		transaction -= .05;
    	}
    }
    
    public void getPennies()
    {
    	
    }
}