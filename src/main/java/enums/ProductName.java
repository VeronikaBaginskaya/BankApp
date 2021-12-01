package enums;

public enum ProductName {
    CREDIT_CARD,
    DEBIT_CARD,
    CURRENCY_DEBIT_CARD,
    INVESTMENTS;


    public String getProductName() {
        switch (this) {
            case DEBIT_CARD:
                return "дебетовая карта";
            case CREDIT_CARD:
                return "кредитная карта";
            case CURRENCY_DEBIT_CARD:
                return "валютная дебетовая карта";
            case INVESTMENTS:
                return "вклад";
            default:
                return "Такого продукта не существует";
        }
    }
}

