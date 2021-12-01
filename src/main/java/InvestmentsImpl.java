import java.math.BigInteger;
import java.util.Map;

public class InvestmentsImpl extends BankProductsAbst implements Investments {

    public InvestmentsImpl(CurrencyTypes currency, Double balance, String name) {
        super(currency, balance, name);
    }

    public void closing(int id) {
        BankProductsAbst investment = DataBase.clientsProducts.get(id);
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

