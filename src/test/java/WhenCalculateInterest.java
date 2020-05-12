import org.example.model.entity.CreditAccount;
import org.example.model.entity.CreditBuilder;
import org.example.model.entity.DepositAccount;
import org.example.model.entity.DepositBuilder;
import org.example.model.service.Calculator;


import static junit.framework.TestCase.assertEquals;

public class WhenCalculateInterest {
    @org.junit.Test
    public void testCalculateCreditInterest(){
        CreditAccount account = new CreditBuilder()
                .balance(-1000)
                .creditRate(45)
                .accrued(0)
                .debt(1000)
                .build();
        Calculator calculator = new Calculator();
        calculator.calculateCreditInterest(account);
        assertEquals(37, account.getAccrued());
        assertEquals(1037, account.getDebt());
    }
    @org.junit.Test
    public void testCalculateDepositInterest(){
        DepositAccount account = new DepositBuilder()
                .balance(0)
                .depositAmount(100000)
                .depositRate(5)
                .build();
        System.out.println(5000/12);
        new Calculator().calculateDepositInterest(account);
        assertEquals(416, account.getBalance());
    }
}
