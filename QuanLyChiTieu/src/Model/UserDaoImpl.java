package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl()
    {
        Database db = new Database();
        String SQL_CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS UsersTable (\n"
                + "    ID integer PRIMARY KEY,\n"
                + "    FullName text NOT NULL,\n"
                + "    Password text NOT NULL \n"
                + ");";
        try {
            Statement statement = db.getConnection().createStatement();
            statement.execute(SQL_CREATE_USERS_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }
    @Override
    public void insertUser(User user) {
        Database db = new Database();
        final String SQL_CREATE_USER = "INSERT INTO MembersTable(FullName, Password)" +
                "VALUES(?,?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                user.setID(id);
                System.out.println("Inserted id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public User getUserById(int id) {
        User user = null;

        Database db = new Database();

        final String SQL_SELECT_USER_BY_ID = "SELECT * FROM MembersTable WHERE id=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT_USER_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int userID = rs.getInt(1);
                String FullName = rs.getString(2);
                String passWord = rs.getString(3);
                user = new User(userID, FullName, passWord);
                System.out.println("ID: " + userID + ", Full Name: " + FullName + ",  Password: " + passWord);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return user;
    }


    @Override
    public List<User> getAllUsers() {
        List<User> users = new Vector<>();

        Database db = new Database();

        final String SQL_SELECT_ALL_USERS = "SELECT * FROM MembersTable";
        try {
            Statement statement = db.getConnection().createStatement();

            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {

                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                String passWord = rs.getString(3);

                User user = new User(id, fullName, passWord);

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();

        return users;
    }

    @Override
    public void updateUser(User user, int id) {
        Database db = new Database();
        final String SQL_UPDATE_USER_BY_ID = "UPDATE MembersTable SET FullName = ?, Gender = ? WHERE ID = ?";
        PreparedStatement ps;
        try {
            ps = db.getConnection().prepareStatement(SQL_UPDATE_USER_BY_ID);
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getPassword());
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void deleteUser(int id) {
        Database db = new Database();
        final String SQL_DELETE_USER_BY_ID = "DELETE FROM MembersTable WHERE ID = ?";
        PreparedStatement ps = null;
        try {
            ps = db.getConnection().prepareStatement(SQL_DELETE_USER_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }
}
