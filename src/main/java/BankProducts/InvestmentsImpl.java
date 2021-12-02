package BankProducts;

import BankProductsModel.BankProductsAbst;
import DataBase.DataBase;
import enums.CurrencyTypes;

import java.util.Map;

public class InvestmentsImpl extends BankProductsAbst implements Investments {

    public InvestmentsImpl(CurrencyTypes currency, Double balance, String name) {
        super(currency, balance, name);
    }

    public void closing() {
        Map<String, BankProductsAbst> map = DataBase.clientsProducts;
        for (Map.Entry<String, BankProductsAbst> entry : map.entrySet()) {
            if (entry.getValue() instanceof Investments) {
                try {
                    DataBase.clientsProducts.remove(entry.getKey());
                } catch (Exception e) {
                    System.out.println("Такого клиента не существует в БД");
                }
            }
        }
    }
}

