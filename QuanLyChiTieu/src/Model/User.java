package Model;

public class  User {
    private int ID;
    private String FullName;
    private String Password;

    private int Income;
    private int Expensive;
    private int Total;

    public int getIncome() {
        return Income;
    }

    public void setIncome(int income) {
        Income = income;
    }

    public int getExpensive() {
        return Expensive;
    }

    public void setExpensive(int expensive) {
        Expensive = expensive;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public User(int ID, String fullname, String password) {
        this.ID = ID;
        this.FullName = fullname;
        this.Password = password;
    }

    public User() {
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullname) {
        FullName = fullname;
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
