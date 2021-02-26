package cashRegister;

public class CashRegisterUITest
{
    public static void main(String[] args)
    {
    	
        CashRegisterUI registerUI = new CashRegisterUI();
        
        registerUI.conductTransaction();

        /*
         * tested with:
         * 6
         * blank line
         * -6 then -1 then blank line
         * -6 then -1 then 5
         */
//        System.out.println(registerUI.acceptValidPrice());
        
        /*
         * tested with:
         * 6 then 5.95 then 7.95 then blank line (expected total: 19.90)
         * blank line then -4.99 then 1 then blank line (expected total: 1)
         */
//        registerUI.acceptAllItemsAndDisplayTotal();
        
        /*
         * tested with first and second examples from sample run in instructions
         */
//        registerUI.conductTransaction();
//        registerUI.conductTransaction();
    }
}