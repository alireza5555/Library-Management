package management;

import library.Book;
import library.Member;
import library.Transaction;

import java.util.ArrayList;
import java.util.Date;

public class TransactionManager {
    ArrayList <Transaction>transactionArr ;

    public TransactionManager() {
        transactionArr = new ArrayList<>();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {

        Transaction transaction = new Transaction(
                "TXN-" + new Date().getTime(),
                bookTitle,
                memberName,
                type
        );

        transactionArr.add(transaction);
        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        return transactionArr.get(index);
    }
}
