package application;

public class PersonalLoan extends Loan {

	// Constructor and having interest increase by 2 percent 
	public PersonalLoan(int loanNumber, String lastName, double loanAmount, double term,double primalIntrest) {
		super(loanNumber, lastName, loanAmount, term);
		this.interestRate = primalIntrest+2;
	}

	@Override
	public double calculateRate() {
		loanAmount += (loanAmount *(interestRate/100) )* term;
		return loanAmount ;
	}

}
