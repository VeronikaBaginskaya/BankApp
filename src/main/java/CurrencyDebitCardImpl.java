public class CurrencyDebitCardImpl extends BankProductsAbst implements Cards {

    public CurrencyDebitCardImpl(String currency, Double balance, String name) {
        super(currency, balance, name);
    }

    public void write_off(Double amount) {

    }

}
