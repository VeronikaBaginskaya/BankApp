package BankProducts;

import BankProductsModel.BankProductsAbst;
import enums.CurrencyTypes;
import enums.ProductName;

public class DebitCardImpl extends BankProductsAbst implements Cards {

    public DebitCardImpl(CurrencyTypes currency, Double balance, ProductName name) {
        super(currency, balance, name);
    }


    @Override
    public void writeOff(Double amount, BankProductsAbst bankProductsAbst) {
        Double balance = bankProductsAbst.getBalance() - amount;
        if (balance >= 0)
            bankProductsAbst.setBalance(balance);
        else System.out.println("запрещено списывать в минус на дебетовой карте!");


    }
}

