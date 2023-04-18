/*	In this program we are having classes that use The interface LoanConstants
 *  Where we have a business and a personal class. Both using The Classes to 
 *  create loan instances.  We create 5 loans add them all in the arrayList and then
 *  use a calculate method to get the interest rate depending on the Term
 *  
 * 
 * 
 *	Assignment : Chapter 9
 * 	Date:3/27/2023
 * 
 * 
 * @author Manny Villegas
 *
 */

package application;

import java.util.ArrayList;
import java.util.Scanner;
public class CreateLoans {

	public static void main(String[] args) {
		double primeInterest,loanAmount;
		int choice ,number,loanTerm;
		String name;
		// Creaing an Arraylist ot hold the Loans 
		ArrayList<Object> loans = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		// Enter PrimeIntrest 
		System.out.print("Enter Prime Interest Rate:");
		primeInterest = input.nextDouble();
		
		
		for(int i = 0;  i < 1;i++) {
			System.out.print("Business Loan Enter 1 : Personal Loan Enter 2 :" );
			choice = input.nextInt();
			if(choice == 1  ) {
				// If Selected 1 will ask the user for Loan Information
				System.out.print("Enter Loan Number:");
				number = input.nextInt();
				System.out.print("Enter Last Name");
				name = input.next();
				System.out.print("Enter Loan Amount Without exceeding 500000:");
				loanAmount = input.nextDouble();
				System.out.print("Enter Loan Term:");
				loanTerm=input.nextInt();
				if(loanTerm == 3) {
					loanTerm=LoanConstants.mediumTerm;
				}
				else if(loanTerm == 5 ) {
					loanTerm = LoanConstants.longTerm;
				}
				else {
					loanTerm = LoanConstants.shortTerm;
				}
				// Will then create an instance of BusinessLoan with the information above and add it to the arrayList 
				loans.add(new BusinessLoan(number,name,loanAmount,loanTerm,primeInterest));
				
				
			}
			else if (choice == 2 ) {
				// If selected 2 will ask the user for Loan information 
				System.out.print("Enter Loan Number:");
				number = input.nextInt();
				System.out.print("Enter Last Name");
				name = input.next();
				System.out.print("Enter Loan Amount Without exceeding 500000:");
				loanAmount = input.nextDouble();
				System.out.print("Enter Loan Term:");
				loanTerm=input.nextInt();
				if(loanTerm == 3) {
					loanTerm=LoanConstants.mediumTerm;
				}
				else if(loanTerm == 5 ) {
					loanTerm = LoanConstants.longTerm;
				}
				else {
					loanTerm = LoanConstants.shortTerm;
				}
				// Create an instance of Personal loan and add it to the arrayList
				loans.add(new PersonalLoan(number,name,loanAmount,loanTerm,primeInterest));
				
			}
		

		}
		// Printing everything in the Loans arrayList 
		for(Object o : loans) {
			System.out.println(o);
		}

	}
}
