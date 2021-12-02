package DataBase;

import BankProducts.InvestmentsImpl;
import BankProductsModel.BankProducts;
import BankProductsModel.BankProductsAbst;
import Clients.Client;
import enums.CurrencyTypes;
import enums.ProductName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {

    private InvestmentsImpl investments;
    private DataBase dataBase;
    private Client client;



    public DataBaseTest() {
        this.client = new Client("Test", 0);
        this.investments = new InvestmentsImpl(CurrencyTypes.RUB, 2898900.096, ProductName.INVESTMENTS);
    }


    @Test
    void addAndGetFromToDataBaseTest() {
        DataBase.addToDataBase(client.getIdClientAndNameProduct(investments), investments);
        assertEquals(investments,(DataBase.getFromDataBase(client.getIdClientAndNameProduct(investments))));
    }


    @Test
    void closing() {
        DataBase.addToDataBase(client.getIdClientAndNameProduct(investments), investments);
        DataBase.getFromDataBase(client.getIdClientAndNameProduct(investments));
        investments.closing();
        assertNull(DataBase.getFromDataBase(client.getIdClientAndNameProduct(investments)));

    }
}