package Clients;

import BankProducts.Cards;
import BankProducts.CreditCard;
import BankProducts.Investments;
import BankProductsModel.BankProductsAbst;

public class Client {

    private String fullName;
    private static int id = 0;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }


    public static int getIncrementedId() {
        id++;
        return id;
    }

    public static void setId(int id) {
        Client.id = id;
    }


    public Client(String fullName, int id) {
        this.fullName = fullName;


    }

    public String getIdClientAndNameProduct(BankProductsAbst bankProductsAbst) {
        return getId() + " " + bankProductsAbst.getName();

    }


//    public Map<Integer, String> createClient(int id, String fullName) {
//        Map<Integer, String> client = new HashMap<>();
//        client.put(id, fullName);
//        return client;
//    }


    public String comesToTheBankFor(BankProductsAbst bankProductsAbst) {

        return ("Здравствуйте! Меня зовут " + fullName + " я хочу оформить " + bankProductsAbst.getName().getProductName());
    }

    public String checksBalance(BankProductsAbst bankProductsAbst) {

        return ("Ваш балланс: " + bankProductsAbst.getBalance() + " " + bankProductsAbst.getCurrency());
    }

    public String replenishBalance(BankProductsAbst bankProductsAbst, Double amount) {
        bankProductsAbst.replenish(amount);
        return ("Вы зачислили: " + amount + " " + bankProductsAbst.getCurrency());
    }

    public String writeOffMoneyFromAccount(Cards card, Double amount, BankProductsAbst bankProductsAbst) {
        card.writeOff(amount, bankProductsAbst);
        return ("Вы списали со счета: " + amount + bankProductsAbst.getCurrency());

    }

    public String closeInvestment(Investments investment) {
        investment.closing();
        return("Ваш  вклад был закрыт");

    }

    public String getsIndebtedness(CreditCard creditCard) {
        return "Ваш остаток по задолженности кредитной карты: " + creditCard.getIndebtedness();
    }


}


