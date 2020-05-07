import org.example.model.entity.CreditAccount;
import org.example.model.entity.CreditBuilder;
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
        assertEquals(450, account.getAccrued());
        assertEquals(1450, account.getDebt());
    }
}
