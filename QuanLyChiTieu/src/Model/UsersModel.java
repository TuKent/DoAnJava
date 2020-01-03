package Model;

import java.util.List;

public interface UsersModel {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(int id);

    void updateUser(User user, int id);

    void registerObserver(TableObserver observer);

    void unregisterObserver(TableObserver observer);
}
