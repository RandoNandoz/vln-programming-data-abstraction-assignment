import java.util.Date;

public class Withdraw {
    private final double amount;
    private final Date date;
    private final String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Withdrawal of: $" + amount +
                ", Date: " + date +
                ", Into account: " + account;
    }
}
