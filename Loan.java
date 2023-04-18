package application;
public abstract class Loan implements LoanConstants {
	int loanNumber;
	String lastName;
	double loanAmount;
	double interestRate;
	double term;
	public Loan(int loanNumber, String lastName, double loanAmount, double term) {
		super();
		this.loanNumber = loanNumber;
		this.lastName = lastName;
		// Loan Amount Can't be more than 500k
		if(loanAmount > LoanConstants.maxLoan) {
			this.loanAmount=500000;
		}
		else {
		this.loanAmount = loanAmount;
		}
		// Checking if the term is medium long or short 
		if(term == 3) {
			term=LoanConstants.mediumTerm;
		}
		else if(term == 5 ) {
			term = LoanConstants.longTerm;
		}
		else {
			term = LoanConstants.shortTerm;
		}
		this.term=term;
	}
	@Override
	public String toString() {
		return "Loan [loanNumber=" + loanNumber + ", lastName=" + lastName + ", loanAmount=" + loanAmount
				+ ", interestRate=" + interestRate + ", term=" + term + ", Total:"+calculateRate() + "]";
	}
	

}
