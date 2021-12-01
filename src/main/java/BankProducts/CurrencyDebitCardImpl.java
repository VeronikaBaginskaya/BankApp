package BankProducts;

import BankProductsModel.BankProductsAbst;
import enums.CurrencyTypes;

public class CurrencyDebitCardImpl extends BankProductsAbst implements Cards {

    public CurrencyDebitCardImpl(CurrencyTypes currency, Double balance, String name) {
        super(currency, balance, name);
    }

    @Override
    public void writeOff(Double amount, BankProductsAbst bankProductsAbst) {
        Double balance = bankProductsAbst.getBalance() - amount;
        if (balance >= 0)
            bankProductsAbst.setBalance(balance);
        else System.out.println("запрещено списывать в минус на валютной дебетовой карте!");
    }
}