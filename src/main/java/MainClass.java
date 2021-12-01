public class MainClass {
    public static void main(String[] args) {
        //создаем кредитную карту для нового клиента и самого клиента + добавляем в бд и провеяем, что продукт для клиента туда добавлен
        Client client1 = new Client("Анатольев Анатолий Анатольевич", 1);
        BankProductsAbst creditCard = new CreditCardImpl(CurrencyTypes.RUB, 0.00, ProductName.CREDIT_CARD.getProductName(), 15.00, 200.00);

        DataBase.addToDataBase(client1.getIdAndName(), creditCard);
        System.out.println(DataBase.getFromDataBase(client1.getIdAndName()));

        client1.comesToTheBankFor(creditCard);

        client1.checksBalance(creditCard);
        client1.replenishBalance(creditCard, 150.00);
        client1.checksBalance(creditCard);
        client1.writeOffMoneyFromAccount((CreditCard) creditCard, 100.00, creditCard);
        client1.checksBalance(creditCard);
        client1.getsIndebtedness((CreditCard) creditCard);

        creditCard.getName();

        //создаем вклад для  клиента  + добавляем в бд и провеяем, что продукт для клиента туда добавлен

        BankProductsAbst investment = new InvestmentsImpl(CurrencyTypes.RUB, 1000.00, ProductName.INVESTMENTS.getProductName());
        client1.comesToTheBankFor(investment);

        DataBase.addToDataBase(client1.getIdAndName(), investment);
        System.out.println(DataBase.getFromDataBase(client1.getIdAndName()));

        client1.comesToTheBankFor(investment);

        client1.checksBalance(investment);
        client1.replenishBalance(investment, 150.00);
        client1.checksBalance(investment);
        client1.checksBalance(investment);
        client1.closeInvestment((InvestmentsImpl) investment, client1.getId());

        DataBase.getFromDataBase(client1.getIdAndName());

        investment.getName();


        //создаем валютную карту для  клиента  + добавляем в бд и провеяем, что продукт для клиента туда добавлен

        BankProductsAbst currencyCard = new CurrencyDebitCardImpl(CurrencyTypes.EUR, 1000.00, ProductName.CURRENCY_DEBIT_CARD.getProductName());
        client1.comesToTheBankFor(currencyCard);

        DataBase.addToDataBase(client1.getIdAndName(), currencyCard);
        System.out.println(DataBase.getFromDataBase(client1.getIdAndName()));
        System.out.println(DataBase.getFromDataBase(client1.getIdAndName()));


        client1.comesToTheBankFor(currencyCard);

        client1.checksBalance(currencyCard);
        client1.replenishBalance(currencyCard, 150.00);
        client1.checksBalance(currencyCard);
        client1.writeOffMoneyFromAccount((CurrencyDebitCardImpl) currencyCard, 100.00, currencyCard);
        client1.checksBalance(currencyCard);

    }
}
