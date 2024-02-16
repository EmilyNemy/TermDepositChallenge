import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.termdeposit.InterestPeriod;
import org.termdeposit.TermDeposit;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TermDepositTest {
    @Test
    public void testInterestAtMaturity(){
        TermDeposit termdeposit = new TermDeposit(10000,1.10, 3);
        Assertions.assertEquals(10330.00, Math.round(termdeposit.calculateCompoundInterest(InterestPeriod.AT_MATURITY)));
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

    @Test
    public void testInterestMonthly(){
        TermDeposit termDeposit = new TermDeposit(10000, 1.10, 3);
        Assertions.assertEquals(10335, Math.round(termDeposit.calculateCompoundInterest(InterestPeriod.MONTHLY)));
    }

    @Test
    public void testInvalidInterestPeriod(){
        TermDeposit termDeposit = new TermDeposit(10000, 1.10, 3);
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> termDeposit.calculateCompoundInterest(InterestPeriod.INVALID));
        Assertions.assertEquals("Invalid interest Period: INVALID", exception.getMessage());
    }

    @Test
    public void testNegativePrincipal(){
        TermDeposit termDeposit = new TermDeposit(-10000, 1.10, 3);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> termDeposit.calculateCompoundInterest(InterestPeriod.MONTHLY));
        Assertions.assertEquals("The principal, investment term, or interest cannot be negative", exception.getMessage());
    }

    @Test
    public void testNegativeInvestmentTerm(){
        TermDeposit termDeposit = new TermDeposit(10000, -1.10, -3);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> termDeposit.calculateCompoundInterest(InterestPeriod.MONTHLY));
        Assertions.assertEquals("The principal, investment term, or interest cannot be negative", exception.getMessage());
    }
}
