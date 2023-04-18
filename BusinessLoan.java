package application;

public class BusinessLoan extends Loan {

	// Constructor and having interest increase by 1 percent 
	public BusinessLoan(int loanNumber, String lastName, double loanAmount, double term,double primalIntrest) {
		super(loanNumber, lastName, loanAmount, term);
		this.interestRate=primalIntrest+1;
	}

	@Override
	public double calculateRate() {
			loanAmount += (loanAmount *(interestRate/100) )* term;
		
		return loanAmount ;
	}
	
	

}
