package ua.com.alevel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class Balance {

    private Optional<BigDecimal> price;
    private Optional<List<Transaction>> transactions;

    public Optional<BigDecimal> getPrice() {
        return price;
    }

    public void setPrice(Optional<BigDecimal> price) {
        this.price = price;
    }

    public Optional<List<Transaction>> getTransactions() {
        return transactions;
    }

    public void setTransactions(Optional<List<Transaction>> transactions) {
        this.transactions = transactions;
    }
}
