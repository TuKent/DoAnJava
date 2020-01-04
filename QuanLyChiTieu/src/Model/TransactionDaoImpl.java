package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {

    public TransactionDaoImpl() {
        Database db = new Database();
        String SQL_CREATE_TRANSACTIONS_TABLE = "CREATE TABLE IF NOT EXISTS TransactionsTable (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    UserID text NOT NULL,\n"
                + "    CategoryName text NOT NULL,\n"
                + "    Description text NOT NULL,\n"
                + "    Amount integer NOT NULL,\n"
                + "    IsIncome integer NOT NULL,\n"
                + "    DateTime date NOT NULL \n"
                + ");";
        try {
            Statement statement = db.getConnection().createStatement();
            statement.execute(SQL_CREATE_TRANSACTIONS_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public List<User> getAllTransaction() {
        return null;
    }

    @Override
    public void InsertTransaction(Transaction transaction) {
        Database db = new Database();
        User user = new User();
        final String SQL_CREATE_USER = "INSERT INTO TransactionsTable(UserID,CategoryName,Description,Amount,IsIncome,DateTime)" +
                "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,user.getID());
            ps.setString(2, transaction.getCategoryName());
            ps.setString(3, transaction.getDescription());
            ps.setInt(4, transaction.getAmount());
            ps.setInt(5, transaction.getIsIncome());
            ps.setString(6,transaction.getDateTime());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                transaction.setID(id);
                System.out.println("Inserted id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();

    }

    @Override
    public void EditTransaction(Transaction transaction, int id) {

    }

    @Override
    public void DeleteTransaction(int id) {

    }
}
