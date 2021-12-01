package DataBase;

import BankProductsModel.BankProductsAbst;

import java.util.HashMap;
import java.util.Map;

public class DataBase {

    public  static Map <String, BankProductsAbst> clientsProducts = new HashMap<>();

    public static void addToDataBase(String client, BankProductsAbst bankProductsAbst){
        clientsProducts.put(client, bankProductsAbst);
    }
    public static BankProductsAbst getFromDataBase(String client){
        return clientsProducts.get(client);
    }




}