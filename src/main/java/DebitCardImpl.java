public class DebitCardImpl extends BankProductsAbst implements Cards{

    public DebitCardImpl(CurrencyTypes currency, Double balance, String name) {
        super(currency, balance, name);
    }



    @Override
    public void writeOff(Double amount, BankProductsAbst bankProductsAbst) {
        Double balance = bankProductsAbst.getBalance()-amount;
        if (balance>=0)
            bankProductsAbst.setBalance(balance);
        else System.out.println("запрещено списывать в минус на дебетовой карте!");


    }
}

