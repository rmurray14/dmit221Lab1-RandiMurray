package ca.nait.dmit.domain;


/**
 * This class will produce a loan schedule that will 
 * output the loans interest paid, principal paid, and balance remaining.
 * It will also keep track of the total payments to be made and the number of payments that have been made. 
 * @author Randi Murray
 * @Version 2013.05.23
 *
 */
public class LoanSchedule {
/**
 * paymentNumber - the number of the payment for a given monthly payment out of a total number of payments calculated
 * from the amortization period. 	
 */
	private int paymentNumber;
/**
 * interestPaid - the interest portion of a monthly payment. Interest is calculated using a yearly rate and adjusted
 * for monthly payments.
 */
	private double interestPaid;
/**
 * prinicpalPaid - the principal portion of a monthly payment. Principal is value of the loan before interest is applied.
 * Principal is the money that goes directly towards paying down the loan and is does not count towards interest accrued
 * on the loan.
 */
	private double principalPaid;
/**
 * remainingBalance - the value of what's left on the loan after a monthly payment has been deducted from it. 
 */
	private double remainingBalance;
	

	public int getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(int paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	public double getInterestPaid() {
		return interestPaid;
	}
	public void setInterestPaid(double interestPaid) {
		this.interestPaid = interestPaid;
	}
	public double getPrincipalPaid() {
		return principalPaid;
	}
	public void setPrincipalPaid(double principalPaid) {
		this.principalPaid = principalPaid;
	}
	public double getRemainingBalance() {
		return remainingBalance;
	}
	public void setRemainingBalance(double remainingBalance) {
		this.remainingBalance = remainingBalance;
	}
	
/**
* This simple default constructor. This will create an empty object.
*/
	public LoanSchedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	
/**
 * This constructor creates an object with parameters it takes in. 
 * @param paymentNumber
 * @param interestPaid
 * @param principalPaid
 * @param remainingBalance
 */
	public LoanSchedule(int paymentNumber, double interestPaid,
			double principalPaid, double remainingBalance) {
		super();
		this.paymentNumber = paymentNumber;
		this.interestPaid = interestPaid;
		this.principalPaid = principalPaid;
		this.remainingBalance = remainingBalance;
	}
	
	

}
