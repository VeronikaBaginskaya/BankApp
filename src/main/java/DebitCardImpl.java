public class DebitCardImpl extends BankProductsAbst implements Cards{

    public DebitCardImpl(String currency, Double balance, String name) {
        super(currency, balance, name);
    }

    public void write_off(Double amount) {

    }
}
