import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.termdeposit.InterestPeriod;
import org.termdeposit.TermDeposit;

public class TermDepositTest {
    @Test
    public void testInterestAtMaturity(){
        TermDeposit termdeposit = new TermDeposit(10000,1.10, 3);
        Assertions.assertEquals(10330.00, termdeposit.calculateCompoundInterest(InterestPeriod.AT_MATURITY));
    }

    @Test
    public void testInterestAnnually(){
        TermDeposit termdeposit = new TermDeposit(10000, 1.10, 3);
        Assertions.assertEquals(10334.00, Math.round(termdeposit.calculateCompoundInterest(InterestPeriod.ANNUALLY)));
    }

    @Test
    public void testInterestQuarterly(){
        TermDeposit termdeposit = new TermDeposit(10000, 1.10, 3);
        Assertions.assertEquals(10335.00, Math.round(termdeposit.calculateCompoundInterest(InterestPeriod.QUARTERLY)));
    }

}
