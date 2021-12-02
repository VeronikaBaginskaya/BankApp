package BankProducts;

import enums.CurrencyTypes;
import enums.ProductName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



class CreditCardImplTest {


    private CreditCardImpl creditCard;


    public CreditCardImplTest() {
        this.creditCard = new CreditCardImpl(CurrencyTypes.RUB, 1010.00, ProductName.CREDIT_CARD, 16.00, 1500.00);
    }

    @Test
    void getIndebtednessTest() {
        assertEquals(1500.0, creditCard.getIndebtedness());
    }

    @Test
    void setIndebtednessTest() {
        creditCard.setIndebtedness(200.6);
        assertEquals(200.6, creditCard.getIndebtedness());
        creditCard.setIndebtedness(1500.0);
    }

    @Test
    void getInterestRateTest() {
        assertEquals(16.00, creditCard.getInterestRate());
    }

    @Test
    void setInterestRateTest() {
        creditCard.setInterestRate(56.9);
        assertEquals(56.9, creditCard.getInterestRate());
        creditCard.setInterestRate(16.0);
    }

}