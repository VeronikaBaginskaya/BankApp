package BankProductsModel;

import BankProducts.CreditCardImpl;
import BankProducts.DebitCardImpl;
import BankProducts.InvestmentsImpl;
import BankProducts.CurrencyDebitCardImpl;
import enums.CurrencyTypes;
import enums.ProductName;
import org.junit.jupiter.api.Test;

import static enums.CurrencyTypes.EUR;
import static enums.CurrencyTypes.RUB;
import static org.junit.jupiter.api.Assertions.assertEquals;


class BankProductsAbstTest {

    private CreditCardImpl creditCard;
    private DebitCardImpl debitCard;
    private InvestmentsImpl investments;
    private CurrencyDebitCardImpl currencyDebitCard;


    public BankProductsAbstTest() {
        this.creditCard = new CreditCardImpl(RUB, 1000.00, ProductName.CREDIT_CARD, 12.00, 15.00);
        this.debitCard = new DebitCardImpl(RUB, 0.00, ProductName.DEBIT_CARD);
        this.investments = new InvestmentsImpl(RUB, 2000.00, ProductName.INVESTMENTS);
        this.currencyDebitCard = new CurrencyDebitCardImpl(CurrencyTypes.EUR, 500.00, ProductName.CURRENCY_DEBIT_CARD);
    }

    @Test
    void replenishAndGetBalanceTest() {
        creditCard.replenish(200.00);
        debitCard.replenish(200.00);
        investments.replenish(200.00);
        currencyDebitCard.replenish(200.00);

        assertEquals(1200.0, creditCard.getBalance());
        assertEquals(200.0, debitCard.getBalance());
        assertEquals(2200.0, investments.getBalance());
        assertEquals(700.0, currencyDebitCard.getBalance());


    }

    @Test
    void getCurrencyTest() {
        assertEquals(RUB, creditCard.getCurrency());
        assertEquals(RUB, debitCard.getCurrency());
        assertEquals(RUB, investments.getCurrency());
        assertEquals(EUR, currencyDebitCard.getCurrency());

    }


}