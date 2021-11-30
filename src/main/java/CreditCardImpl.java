import java.math.BigInteger;

public class CreditCardImpl extends BankProductsAbst implements CreditCard {

    private Double interestRate;


    public CreditCardImpl(String currency, Double balance, String name, Double interestRate) {
        super(currency, balance, name);
        this.interestRate=interestRate;
    }

    public void write_off(Double amount) {

    }

    public Double getIndebtedness(BigInteger cardAccountNumber) {
        return null;
    }


    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }


}
