package BankProductsModel;

import enums.CurrencyTypes;
import enums.ProductName;

public abstract class BankProductsAbst implements BankProducts {

    private CurrencyTypes currency;
    private Double balance;
    private ProductName name;


    public BankProductsAbst(CurrencyTypes currency, Double balance, ProductName name) {
        this.currency = currency;
        this.balance = balance;
        this.name = name;
    }


    public void replenish(Double amount) {
        setBalance(getBalance() + amount);
    }

    public CurrencyTypes getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyTypes currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public ProductName getName() {
        return name;
    }

    public void setName(String name) {
        this.name = ProductName.valueOf(name);
    }


}
