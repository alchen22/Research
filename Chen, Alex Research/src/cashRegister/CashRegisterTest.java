package cashRegister;

import junit.framework.TestCase;

public class CashRegisterTest extends TestCase
{
    private static boolean closeEnough(double a, double b)
    {
        return Math.abs(a - b) <= 0.001;
    }
    
    public void testSingleItemTransactionNoChange()
    {
        CashRegister register = new CashRegister();
        
        register.addItem(1.99);
                
        double expectedTotal = 1.99;
        double actualTotal = register.getTotal();
        assertTrue(closeEnough(expectedTotal, actualTotal));
        
        double expectedChange = 0;
        double actualChange = register.acceptPayment(1.99);
        assertTrue(closeEnough(expectedChange, actualChange));
        
        double expectedNewTotal = 0;
        double actualNewTotal = register.getTotal();
        assertTrue(closeEnough(expectedNewTotal, actualNewTotal));
    }
    
    public void testMultipleItemTransactionWithChange()
    {
        CashRegister register = new CashRegister();
        
        register.addItem(6);
        register.addItem(5.95);
        register.addItem(7.95);
        
        double expectedTotal = 19.90;
        double actualTotal = register.getTotal();
        assertTrue(closeEnough(expectedTotal, actualTotal));
        
        double expectedChange = 30.10;
        double actualChange = register.acceptPayment(50);
        assertTrue(closeEnough(expectedChange, actualChange));
        
        double expectedNewTotal = 0;
        double actualNewTotal = register.getTotal();
        assertTrue(closeEnough(expectedNewTotal, actualNewTotal));
    }
    
    public void testMultipleTransactions()
    {
        CashRegister register = new CashRegister();
        
        register.addItem(6);
        register.addItem(5.95);
        register.addItem(7.95);
        
        double expectedTotal = 19.90;
        double actualTotal = register.getTotal();
        assertTrue(closeEnough(expectedTotal, actualTotal));
        
        double expectedChange = 30.10;
        double actualChange = register.acceptPayment(50);
        assertTrue(closeEnough(expectedChange, actualChange));
        
        double expectedNewTotal = 0;
        double actualNewTotal = register.getTotal();
        assertTrue(closeEnough(expectedNewTotal, actualNewTotal));
        
        register.addItem(1);
        
        expectedTotal = 1;
        actualTotal = register.getTotal();
        assertTrue(closeEnough(expectedTotal, actualTotal));
        
        expectedChange = 0;
        actualChange = register.acceptPayment(1);
        assertTrue(closeEnough(expectedChange, actualChange));
    }
}