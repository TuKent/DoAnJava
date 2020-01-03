package Model;

public class  User {
    private int ID;
    private String Fullname;
    private String Password;

    public User(int ID, String fullname, String password) {
        this.ID = ID;
        Fullname = fullname;
        Password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
//    private int Income;
//    private int Expense;
//    private int Total;

}
