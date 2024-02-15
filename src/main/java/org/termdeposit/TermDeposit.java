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
        double value = 1 + interestValue/1;
        if (interestPeriod == 1){
           return principal + (principal * (Math.pow(value, (interestPeriod * term)) - 1));
        }
        return  principal + (principal * interestValue * term);
    }
}
