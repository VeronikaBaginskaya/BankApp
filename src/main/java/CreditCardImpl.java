import java.math.BigInteger;

public class CreditCardImpl extends BankProductsAbst implements CreditCard {

    private Double interestRate;
    private Double indebtedness;


    public CreditCardImpl(CurrencyTypes currency, Double balance, String name, Double interestRate, Double indebtedness) {
        super(currency, balance, name);
        this.interestRate=interestRate;
        this.indebtedness = indebtedness;
    }

    public Double getIndebtedness() {
        return indebtedness;
    }


    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }


    public void writeOff(Double amount, BankProductsAbst bankProductsAbst) {
        bankProductsAbst.setBalance(bankProductsAbst.getBalance()-amount);

    }
}
