package Model;

public class Transaction {
    private int ID;
    private int UserID;
    private String CatagoryName;
    private String Description;
    private int Amount;
    private int IsIncome;
    private String DateTime;

    public Transaction()
    {
    }

    public Transaction(int ID, int userID, String catagoryName, String description, int amount, int isIncome, String dateTime) {
        this.ID = ID;
        UserID = userID;
        CatagoryName = catagoryName;
        Description = description;
        Amount = amount;
        IsIncome = isIncome;
        DateTime = dateTime;
    }

    public int getID() {
        return ID;
    }


    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getCategoryName() {
        return CatagoryName;
    }

    public void setCategoryName(String catagoryName) {
        CatagoryName = catagoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getIsIncome() {
        return IsIncome;
    }

    public void setIncome(int income) {
        IsIncome = income;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }
}
