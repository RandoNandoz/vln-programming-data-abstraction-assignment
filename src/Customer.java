import java.util.ArrayList;
import java.util.Date;

public class Customer {
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<>();
    private ArrayList<Withdraw> withdraws = new ArrayList<>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;

    Customer() {
        //create default constructor
    }

    public Customer(int accountNumber, double checkBalance, double savingBalance, String name) {
        this.accountNumber = accountNumber;
        this.checkBalance = checkBalance;
        this.savingBalance = savingBalance;
        this.name = name;
    }

    public double deposit(double amt, Date date, String account) {
        double returnValue = -1;
        if (amt > 0) {
            this.deposits.add(new Deposit(amt, date, account));
            if (account.equals(CHECKING)) {
                this.checkBalance += amt;
                returnValue = this.checkBalance;
            } else if (account.equals(SAVING)) {
                this.savingBalance += amt;
                returnValue = this.savingBalance;
            }
        }
        return returnValue;
    }

    public double withdraw(double amt, Date date, String account) {
        double returnValue = -1;
        if (checkOverdraft(amt, account) && amt > 0) {
            this.withdraws.add(new Withdraw(amt, date, account));
            if (account.equals(CHECKING)) {
                this.checkBalance -= amt;
                returnValue = this.checkBalance;
            } else if (account.equals(SAVING)) {
                this.savingBalance -= amt;
                returnValue = this.savingBalance;
            }
        }
        return returnValue;
    }

    private boolean checkOverdraft(double amt, String account) {
        boolean returnValue = false;
        if (account.equals(CHECKING)) {
            returnValue = (this.checkBalance - amt > OVERDRAFT);
        }
        if (account.equals(SAVING)) {
            returnValue = (this.savingBalance - amt > OVERDRAFT);
        }
        return returnValue;
    }

    // Do not modify
    public void displayDeposits() {
        for (Deposit d : deposits) {
            System.out.println(d);
        }
    }

    // Do not modify
    public void displayWithdraws() {
        for (Withdraw w : withdraws) {
            System.out.println(w);
        }
    }

    public double getCheckingBalance() {
        return checkBalance;
    }

    public double getSavingsBalance() {
        return savingBalance;
    }
}
