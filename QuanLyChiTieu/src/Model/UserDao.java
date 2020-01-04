package Model;

import java.util.List;

public interface UserDao {
    // Create
    void insertUser (User user);

//     Read
    User getUserById(int id);

    List<User> getAllUsers();

    // Update
    void updateUser(User user, int id);

    // Delete
    void deleteUser(int id);

    // Get Username and Password
    User getByUserandPassword(User user);
}
