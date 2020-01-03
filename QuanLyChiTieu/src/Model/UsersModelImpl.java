package Model;

import java.util.List;
import java.util.Vector;

public class UsersModelImpl implements UsersModel {

    private List<TableObserver> tableObservers = new Vector<>();

    @Override
    public List<User> getAllUsers() {
        UserDao userDao = new UserDaoImpl();
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        UserDao userDao = new UserDaoImpl();
        userDao.insertUser(user);
        notifyObservers();
    }

    @Override
    public void deleteUser(int id) {
        UserDao userDao = new UserDaoImpl();
        userDao.deleteUser(id);
        notifyObservers();

    }

    @Override
    public void updateUser(User user, int id) {
        UserDao userDao = new UserDaoImpl();
        userDao.updateUser(user,id);
        notifyObservers();
    }

    @Override
    public void registerObserver(TableObserver observer) {
        if (!tableObservers.contains(observer))
            tableObservers.add(observer);
    }

    @Override
    public void unregisterObserver(TableObserver observer) {
        tableObservers.remove(observer);
    }

    private void notifyObservers() {
        List<User> users = getAllUsers();
        for (TableObserver observer: tableObservers) {
            observer.updateObserver(users);
        }
    }
}
