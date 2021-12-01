public class Client {

    private String fullName;
    private static int id = 0;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    int getId() {
        return id;
    }


    public static int setID() {
        id++;
        return id;
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


    public void comesToTheBankFor(BankProductsAbst bankProductsAbst) {

        System.out.println("Здравствуйте! Меня зовут " + fullName + " я хочу оформить " + bankProductsAbst.getName());
    }

    public void checksBalance(BankProductsAbst bankProductsAbst) {

        System.out.println("Ваш балланс: " + bankProductsAbst.getBalance() + " " + bankProductsAbst.getCurrency());
    }

    public void replenishBalance(BankProductsAbst bankProductsAbst, Double amount) {
        bankProductsAbst.replenish(amount);
        System.out.println("Вы зачислили: " + amount + " " + bankProductsAbst.getCurrency());
    }

    public void writeOffMoneyFromAccount(Cards card, Double amount, BankProductsAbst bankProductsAbst) {
        card.writeOff(amount, bankProductsAbst);
        System.out.println("Вы списали со счета: " + amount + bankProductsAbst.getCurrency());

    }

    public void closeInvestment(Investments investment, int idClient) {
        investment.closing(idClient);
        System.out.println("Ваш  вклад был закрыт");

    }

    public void getsIndebtedness(CreditCard creditCard) {
        System.out.println("Ваш остаток по задолженности кредитной карты: " + creditCard.getIndebtedness());
    }


}


