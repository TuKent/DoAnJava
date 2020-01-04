package Model;

import java.util.List;

public interface TransactionDao {

    //Read
    List<User> getAllTransaction();

    //    Insert Transaction
    void InsertTransaction(Transaction transaction);

    // Edit Transaction
    void EditTransaction(Transaction transaction,int id);

    //Delete Transaction
    void DeleteTransaction(int id);


}
