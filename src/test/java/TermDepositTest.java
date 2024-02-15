import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TermDepositTest {
    @Test
    public void testInterestAtMaturity(){
        TermDeposit termdeposit = new TermDeposit(10000,1.10, 3);
        Assertions.assertEquals(10330.00, termdeposit.calculateCompoundInterest(1));
    }
}
