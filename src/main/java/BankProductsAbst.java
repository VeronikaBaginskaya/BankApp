public abstract class BankProductsAbst implements BankProducts {

    private String currency;
    private Double balance;
    private String name;


    public BankProductsAbst(String currency, Double balance, String name) {
        this.currency = currency;
        this.balance = balance;
        this.name = name;
    }


    public void replenish(Double amount){
        this.balance=getBalanceForAccount()+amount;
    }

    //хз надо ли , или только геттер обычный - может сделать стрингом и возвращать красивое сообщение
    public Double getBalanceForAccount(){
        return getBalance();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
