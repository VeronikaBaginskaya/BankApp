package Clients;

import BankProducts.CreditCardImpl;
import enums.CurrencyTypes;
import enums.ProductName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class ClientTest {

    public Client createTestClient() {
        Client client = new Client("Test", 0);
        return client;
    }

    @Test
    void getFullNameTest() {
        assertEquals("Test", createTestClient().getFullName());
    }

    @Test
    void setFullNameTest() {
        Client client = createTestClient();
        client.setFullName("Test2");
        assertEquals("Test2", client.getFullName());
    }

    @Test
    void getIdTest() {
        assertEquals(0, createTestClient().getId());
    }

    @Test
    void setIDTest() {
        Client client = createTestClient();
        Client.setID();
        assertEquals(1, client.getId());
        Client.setID();
        assertEquals(2, client.getId());
        Client.setID();
        assertEquals(3, client.getId());
    }


    @Test
    void getIdClientAndNameProductCreditTest() {
        Client client = createTestClient();
        CreditCardImpl creditCard = new CreditCardImpl(CurrencyTypes.RUB, 1000.00, ProductName.CREDIT_CARD.getProductName(), 12.00, 15.00);
        assertEquals("0 кредитная карта", client.getIdClientAndNameProduct(creditCard));

    }

    @Test
    void comesToTheBankForTest() {
    }

    @Test
    void checksBalanceTest() {
    }

    @Test
    void replenishBalanceTest() {
    }

    @Test
    void writeOffMoneyFromAccountTest() {
    }

    @Test
    void closeInvestmentTest() {
    }

    @Test
    void getsIndebtednessTest() {
    }
}