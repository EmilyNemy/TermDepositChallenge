
## Prerequisites
- Java
- Install [gradle](https://gradle.org/install/)

### Run tests
use command

`gradle test`

### How to run the program

Using gradle to run the program. Enter the following values.

`gradle run --args="10000 1.10 3 AT_MATURITY"`  

The first argument is the principal or deposit, the second is the interest rate, the third is the investment term, and the fourth
is the interest period one might be interested in e.g Annually, quarterly, monthly, and at maturity.
Other examples include

`gradle run --args="13000 3.2 3 MONTHLY"`

### Design decisions

- Term Deposit is an account with a principal amount, interest for the investment, and investment term
- For simplicity the money is taken as a double
- Use an enum for the interest period and also allocate each interest period with a compound period which indicates the
number of times the interest is calculated. (Information got from https://www.investopedia.com/articles/investing/020614/learn-simple-and-compound-interest.asp)
_________________________________________________
| Compounding frequency | No. compounding periods|
_________________________________________________
|  Annually             | 1                      |
__________________________________________________
| Quarterly              | 4                      |
_________________________________________________
| Monthly               | 12                     |
_________________________________________________

### Improvements
- Use BigDecimal to store money