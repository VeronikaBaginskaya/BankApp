package Clients;

import BankProducts.CreditCardImpl;
import BankProducts.DebitCardImpl;
import BankProducts.InvestmentsImpl;
import BankProducts.CurrencyDebitCardImpl;
import enums.CurrencyTypes;
import enums.ProductName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ClientTest {


    private CreditCardImpl creditCard;
    private DebitCardImpl debitCard;
    private InvestmentsImpl investments;
    private CurrencyDebitCardImpl currencyDebitCard;
    private Client client;


    public ClientTest() {
        this.client = new Client("Test", 0);
        this.creditCard = new CreditCardImpl(CurrencyTypes.RUB, 1000.00, ProductName.CREDIT_CARD, 12.00, 15.00);
        this.debitCard = new DebitCardImpl(CurrencyTypes.RUB, 0.00, ProductName.DEBIT_CARD);
        this.investments = new InvestmentsImpl(CurrencyTypes.RUB, 2000.00, ProductName.INVESTMENTS);
        this.currencyDebitCard = new CurrencyDebitCardImpl(CurrencyTypes.EUR, 500.00, ProductName.CURRENCY_DEBIT_CARD);
    }

    public Client createTestClient() {
        return client = new Client("Test", 0);
    }


    @Test
    void getFullNameTest() {
        assertEquals("Test", client.getFullName());
    }

    @Test
    void setFullNameTest() {
        client.setFullName("Test2");
        assertEquals("Test2", client.getFullName());
    }

    @Test
    void getIdTest() {
        assertEquals(0, createTestClient().getId());
    }

    @Test
    void getIncrementedIdTest() {
        Client.getIncrementedId();
        assertEquals(1, client.getId());
        Client.getIncrementedId();
        assertEquals(2, client.getId());
        Client.getIncrementedId();
        assertEquals(3, client.getId());
        Client.setId(0);

    }


    @Test
    void getIdClientAndNameProductCreditTest() {
        assertEquals("0 CREDIT_CARD", client.getIdClientAndNameProduct(creditCard));

    }

    @Test
    void getIdClientAndNameCurrencyDebitTest() {
        assertEquals("0 CURRENCY_DEBIT_CARD", client.getIdClientAndNameProduct(currencyDebitCard));

    }

    @Test
    void getIdClientAndNameInvestmentTest() {
        assertEquals("0 INVESTMENTS", client.getIdClientAndNameProduct(investments));

    }

    @Test
    void getIdClientAndNameDebitTest() {
        assertEquals("0 DEBIT_CARD", client.getIdClientAndNameProduct(debitCard));
    }


    @Test
    void comesToTheBankForTest()  {
        assertEquals("Здравствуйте! Меня зовут Test я хочу оформить кредитная карта", client.comesToTheBankFor(creditCard));
;
    }

    @Test
    void checksBalanceTest() {
        assertEquals("Ваш балланс: 1000.0 RUB", client.checksBalance(creditCard));

    }

    @Test
    void replenishBalanceTest() {
        assertEquals("Вы зачислили: 100.0 RUB", client.replenishBalance(creditCard, 100.00));

    }

    @Test
    void writeOffMoneyFromAccountTest() {
        assertEquals("Вы списали со счета: 1000.0RUB", client.writeOffMoneyFromAccount(creditCard, 1000.00, creditCard));
    }

    @Test
    void closeInvestmentTest() {
        assertEquals("Ваш  вклад был закрыт", client.closeInvestment(investments));

    }

    @Test
    void getsIndebtednessTest() {
        assertEquals("Ваш остаток по задолженности кредитной карты: 15.0", client.getsIndebtedness(creditCard));

    }




}