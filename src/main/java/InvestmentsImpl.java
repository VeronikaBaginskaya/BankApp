import java.math.BigInteger;

public class InvestmentsImpl extends BankProductsAbst implements Investments {

    public InvestmentsImpl(CurrencyTypes currency, Double balance, String name) {
        super(currency, balance, name);
    }

    public void closing(int id) {
        DataBase dataBase = new DataBase();
        BankProductsAbst investment = dataBase.clientsProducts.get(id);
        if (investment instanceof Investments) {
            try {
                dataBase.clientsProducts.remove(id);
            }
            catch(Exception e){
                System.out.println("Такого клиента не существует в БД");
            }
        }
    }

}

