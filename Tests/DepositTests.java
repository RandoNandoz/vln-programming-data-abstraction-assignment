import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class DepositTests {
    double depositAmount;
    Date currentDate;
    Deposit checkingDeposit;
    Deposit savingsDeposit;

    @Before
    public void setup() {
        depositAmount = 10;
        currentDate = new Date();
        checkingDeposit = new Deposit(depositAmount, currentDate, Customer.CHECKING);
        savingsDeposit = new Deposit(depositAmount, currentDate, Customer.SAVING);
    }

    @Test
    public void ToStringTest() {
        Assert.assertEquals(checkingDeposit.toString(), "Deposit of: $" + depositAmount + ", Date: " + currentDate + ", Into account: " + Customer.CHECKING);
        Assert.assertEquals(savingsDeposit.toString(), "Deposit of: $" + depositAmount + ", Date: " + currentDate + ", Into account: " + Customer.SAVING);
    }
}
