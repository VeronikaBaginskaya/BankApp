package BankProducts;

import BankProductsModel.BankProducts;
import BankProductsModel.BankProductsAbst;

public interface Cards extends BankProducts {


    void writeOff(Double amount, BankProductsAbst bankProductsAbst);


}
