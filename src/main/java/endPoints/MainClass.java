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
        Client client1 = new Client("Анатольев Анатолий Анатольевич", Client.getIncrementedId());
        BankProductsAbst creditCard = new CreditCardImpl(CurrencyTypes.RUB, 200.00, ProductName.CREDIT_CARD, 15.00, 200.00);

        addToDataBase(client1.getIdClientAndNameProduct(creditCard), creditCard);

        System.out.println(client1.comesToTheBankFor(creditCard));

        System.out.println(client1.checksBalance(creditCard));
        System.out.println(client1.replenishBalance(creditCard, 150.00));
        System.out.println(client1.checksBalance(creditCard));
        System.out.println(client1.writeOffMoneyFromAccount((CreditCard) creditCard, 100.00, creditCard));
        System.out.println(client1.checksBalance(creditCard));
        System.out.println(client1.getsIndebtedness((CreditCard) creditCard));

        System.out.println("");

        //создаем вклад для  клиента  + добавляем в бд и провеяем, что продукт для клиента туда добавлен
        BankProductsAbst investment = new InvestmentsImpl(CurrencyTypes.RUB, 1000.00, ProductName.INVESTMENTS);
        System.out.println(client1.comesToTheBankFor(investment));

        addToDataBase(client1.getIdClientAndNameProduct(investment), investment);

        System.out.println(client1.checksBalance(investment));
        System.out.println(client1.replenishBalance(investment, 150.00));
        System.out.println(client1.checksBalance(investment));
        System.out.println("Проверяем записи в бд - " + DataBase.getFromDataBase(client1.getIdClientAndNameProduct(investment)));
        System.out.println("Закрываем вклад");
        System.out.println(client1.closeInvestment((InvestmentsImpl) investment));
        System.out.println("Проверяем удалилась ли запись из бд - запись " + DataBase.getFromDataBase(client1.getIdClientAndNameProduct(investment)));

        System.out.println("");

        //создаем валютную карту для  клиента  + добавляем в бд и провеяем, что продукт для клиента туда добавлен
        BankProductsAbst currencyCard = new CurrencyDebitCardImpl(CurrencyTypes.EUR, 1000.00, ProductName.CURRENCY_DEBIT_CARD);
        System.out.println(client1.comesToTheBankFor(currencyCard));

        addToDataBase(client1.getIdClientAndNameProduct(currencyCard), currencyCard);
        System.out.println(client1.checksBalance(currencyCard));
        System.out.println(client1.replenishBalance(currencyCard, 150.00));
        System.out.println(client1.checksBalance(currencyCard));
        System.out.println(client1.writeOffMoneyFromAccount((CurrencyDebitCardImpl) currencyCard, 100.00, currencyCard));
        System.out.println(client1.checksBalance(currencyCard));

        System.out.println("");

//        создаем дебетовую карту для нового клиента и самого клиента + добавляем в бд и провеяем, что продукт для клиента туда добавлен
        Client client2 = new Client("Иванов Петр Анатольевич", Client.getIncrementedId());
        BankProductsAbst debitCard = new DebitCardImpl(CurrencyTypes.RUB, 0.00, ProductName.DEBIT_CARD);

        addToDataBase(client2.getIdClientAndNameProduct(debitCard), debitCard);

        System.out.println(client2.comesToTheBankFor(debitCard));

        System.out.println(client2.checksBalance(debitCard));
        System.out.println(client2.replenishBalance(debitCard, 1500.00));
        System.out.println(client2.checksBalance(debitCard));
        System.out.println(client2.writeOffMoneyFromAccount((DebitCardImpl) debitCard, 10000.00, debitCard));
        System.out.println(client2.checksBalance(debitCard));


        System.out.println("");

        System.out.println("Вывод из бд: " + DataBase.clientsProducts);


    }
}
