package org.termdeposit;


public class TermDeposit {
    private double principal;
    private double interest;
    private int term;


    public TermDeposit(double principal, double interest, int term) {
        this.principal = principal;
        this.interest = interest;
        this.term = term;
    }

    public double calculateCompoundInterest(InterestPeriod interestPeriod) {
        double interestValue = interest / 100;
        double value = 1 + interestValue/interestPeriod.getCompoundPeriod();

        return switch (interestPeriod) {
            case AT_MATURITY -> principal + (principal * interestValue * term);
            case ANNUALLY, QUARTERLY, MONTHLY->
                    principal + (principal * (Math.pow(value, (interestPeriod.getCompoundPeriod() * term)) - 1));
            default -> throw new UnsupportedOperationException("Invalid interest Period: " + interestPeriod);
        };

    }
}
