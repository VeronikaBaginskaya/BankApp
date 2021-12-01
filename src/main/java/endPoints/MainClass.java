package endPoints;

import BankProducts.*;
import BankProductsModel.BankProductsAbst;
import Clients.Client;
import DataBase.DataBase;
import enums.CurrencyTypes;
import enums.ProductName;
import static DataBase.DataBase.addToDataBase;

public class MainClass {
    public static void main(String[] args) {
        //создаем кредитную карту для нового клиента и самого клиента + добавляем в бд и провеяем, что продукт для клиента туда добавлен
        Client client1= new Client("Анатольев Анатолий Анатольевич", Client.setID());
        BankProductsAbst creditCard = new CreditCardImpl(CurrencyTypes.RUB, 200.00, ProductName.CREDIT_CARD.getProductName(), 15.00, 200.00);

        addToDataBase(client1.getIdClientAndNameProduct(creditCard), creditCard);

        client1.comesToTheBankFor(creditCard);

        client1.checksBalance(creditCard);
        client1.replenishBalance(creditCard, 150.00);
        client1.checksBalance(creditCard);
        client1.writeOffMoneyFromAccount((CreditCard) creditCard, 100.00, creditCard);
        client1.checksBalance(creditCard);
        client1.getsIndebtedness((CreditCard) creditCard);

        System.out.println("");

        //создаем вклад для  клиента  + добавляем в бд и провеяем, что продукт для клиента туда добавлен
        BankProductsAbst investment = new InvestmentsImpl(CurrencyTypes.RUB, 1000.00, ProductName.INVESTMENTS.getProductName());
        client1.comesToTheBankFor(investment);

        addToDataBase(client1.getIdClientAndNameProduct(investment), investment);

        client1.checksBalance(investment);
        client1.replenishBalance(investment, 150.00);
        client1.checksBalance(investment);
        System.out.println("Проверяем записи в бд - " + DataBase.getFromDataBase(client1.getIdClientAndNameProduct(investment)));
        System.out.println("Закрываем вклад");
        client1.closeInvestment((InvestmentsImpl) investment, client1.getId());
        System.out.println("Проверяем удалилась ли запись из бд - запись " + DataBase.getFromDataBase(client1.getIdClientAndNameProduct(investment)));

        System.out.println("");

        //создаем валютную карту для  клиента  + добавляем в бд и провеяем, что продукт для клиента туда добавлен

        BankProductsAbst currencyCard = new CurrencyDebitCardImpl(CurrencyTypes.EUR, 1000.00, ProductName.CURRENCY_DEBIT_CARD.getProductName());
        client1.comesToTheBankFor(currencyCard);

        addToDataBase(client1.getIdClientAndNameProduct(currencyCard), currencyCard);

        client1.checksBalance(currencyCard);
        client1.replenishBalance(currencyCard, 150.00);
        client1.checksBalance(currencyCard);
        client1.writeOffMoneyFromAccount((CurrencyDebitCardImpl) currencyCard, 100.00, currencyCard);
        client1.checksBalance(currencyCard);

        System.out.println("");

//        создаем дебетовую карту для нового клиента и самого клиента + добавляем в бд и провеяем, что продукт для клиента туда добавлен

        Client client2 = new Client("Иванов Петр Анатольевич", Client.setID());
        BankProductsAbst debitCard = new DebitCardImpl(CurrencyTypes.RUB, 0.00, ProductName.DEBIT_CARD.getProductName());

        addToDataBase(client2.getIdClientAndNameProduct(debitCard), debitCard);

        client2.comesToTheBankFor(debitCard);

        client2.checksBalance(debitCard);
        client2.replenishBalance(debitCard, 1500.00);
        client2.checksBalance(debitCard);
        client2.writeOffMoneyFromAccount((DebitCardImpl) debitCard, 10000.00, debitCard);
        client2.checksBalance(debitCard);


        System.out.println("");

        System.out.println("Вывод из бд: " + DataBase.clientsProducts);



    }
}
