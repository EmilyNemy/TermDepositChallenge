package org.termdeposit;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java Main <principal> <interestRate> <term> <interestPeriod>");
            return;
        }

        double principal = Double.parseDouble(args[0]);
        double interest = Double.parseDouble(args[1]);
        int term = Integer.parseInt(args[2]);
        String interestPeriod = args[3].toUpperCase();

        List<String> validInterestPeriods = Arrays.asList("MONTHLY", "QUARTERLY", "ANNUALLY", "AT_MATURITY");

        if (!validInterestPeriods.contains(interestPeriod)) {
            System.out.println("Invalid interest period. Please enter one of the valid options: MONTHLY, QUARTERLY, ANNUALLY, AT_MATURITY");
            return;
        }

        TermDeposit termDeposit = new TermDeposit(principal, interest, term);
        double finalBalance = termDeposit.calculateCompoundInterest(InterestPeriod.valueOf(interestPeriod));

        System.out.println("Value will be " + finalBalance + " at the end of " + term + " years");

    }
}