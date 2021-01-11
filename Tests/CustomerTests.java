import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class CustomerTests {
    Customer customer;
    Date currentDate;

    @Before
    public void setup() {
        customer = new Customer(0, 0, 0, "");
        currentDate = new Date();
    }

    @Test
    public void depositTests() {
        double previousCheckingBalance = customer.getCheckingBalance();
        double previousSavingsBalance = customer.getSavingsBalance();
        Assert.assertEquals(customer.deposit(100, currentDate, Customer.CHECKING), previousCheckingBalance + 100, 0);
        Assert.assertEquals(customer.deposit(50, currentDate, Customer.SAVING), previousSavingsBalance + 50, 0);
    }

    @Test
    public void depositInvalidTests() {
        Assert.assertEquals(customer.deposit(0, currentDate, Customer.CHECKING), -1, 0);
        Assert.assertEquals(customer.deposit(0, currentDate, Customer.SAVING), -1, 0);
        Assert.assertEquals(customer.deposit(-1, currentDate, Customer.CHECKING), -1, 0);
        Assert.assertEquals(customer.deposit(-1, currentDate, Customer.SAVING), -1, 0);
        Assert.assertEquals(customer.deposit(100, currentDate, "I'm above your rules!"), -1, 0);
    }

    @Test
    public void withdrawInvalidTests() {
        Assert.assertEquals(customer.withdraw(0, currentDate, Customer.CHECKING), -1, 0);
        Assert.assertEquals(customer.withdraw(0, currentDate, Customer.SAVING), -1, 0);
        Assert.assertEquals(customer.withdraw(-1, currentDate, Customer.CHECKING), -1, 0);
        Assert.assertEquals(customer.withdraw(-1, currentDate, Customer.SAVING), -1, 0);
        Assert.assertEquals(customer.withdraw(50, currentDate, "I'm above your rules!"), -1, 0);
    }

    @Test
    public void withdrawOverdraftErrorTests() {
        Assert.assertEquals(customer.withdraw(Double.MAX_VALUE, currentDate, Customer.CHECKING),-1, 0);
        Assert.assertEquals(customer.withdraw(Double.MAX_VALUE, currentDate, Customer.CHECKING), -1, 0);
        Assert.assertEquals(customer.withdraw(101, currentDate, Customer.CHECKING), -1, 0);
        Assert.assertEquals(customer.withdraw(101, currentDate, Customer.CHECKING), -1, 0);
    }

    @Test
    public void withdrawTests() {
        customer.deposit(200, currentDate, Customer.CHECKING);
        customer.deposit(200, currentDate, Customer.SAVING);
        double previousCheckingBalance = customer.getCheckingBalance();
        double previousSavingsBalance = customer.getSavingsBalance();

        Assert.assertEquals(customer.withdraw(100, currentDate, Customer.CHECKING), previousCheckingBalance - 100, 0);
        Assert.assertEquals(customer.withdraw(50, currentDate, Customer.SAVING), previousSavingsBalance - 50, 0);
    }
}
