import java.util.Date;

public class Deposit {
    private final double amount;
    private final Date date;
    private final String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Deposit of: $" + amount +
                ", Date: " + date +
                ", Into account: " + account;
    }
}
