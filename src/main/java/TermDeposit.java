public class TermDeposit {
    private double principal;
    private double interest;
    private int term;


    public TermDeposit(double prinicipal, double interest, int term) {
        this.principal = prinicipal;
        this.interest = interest;
        this.term = term;
    }

    public double calculateCompoundInterest(int interestPeriod) {
        double interestValue = interest / 100;
        return  principal + (principal * interestValue * term);
    }
}
