import java.math.BigInteger;

public class InvestmentsImpl extends BankProductsAbst implements Investments {

    public InvestmentsImpl(String currency, Double balance, String name) {
        super(currency, balance, name);
    }

    public void closing(BigInteger investmentAccountNumber) {

    }
}
