import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class WithdrawTests {
    double withdrawAmount;
    Date currentDate;
    Withdraw checkingWithdraw;
    Withdraw savingsWithdraw;

    @Before
    public void setup() {
        withdrawAmount = 10;
        currentDate = new Date();
        checkingWithdraw = new Withdraw(withdrawAmount, currentDate, Customer.CHECKING);
        savingsWithdraw = new Withdraw(withdrawAmount, currentDate, Customer.SAVING);
    }

    @Test
    public void ToStringTest() {
        Assert.assertEquals(checkingWithdraw.toString(), "Withdrawal of: $" + withdrawAmount + ", Date: " + currentDate + ", Into account: " + Customer.CHECKING);
        Assert.assertEquals(savingsWithdraw.toString(), "Withdrawal of: $" + withdrawAmount + ", Date: " + currentDate + ", Into account: " + Customer.SAVING);
    }
}
