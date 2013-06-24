package ca.nait.dmit.domain;

/**
 * This class calculates the monthly payment for a mortgage loan.
 * All calculations for the loan schedule are also in this class. 
 * 
 * @author rmurray14
 * @Version 2013.05.23
 *
 */

public class Loan {
/**
 * mortgageAmount - the initial loan amount	
 */
	private double mortgageAmount; 
/**
 * AannualInterestRate - is used to calculate the monthly payments. 
 */
	private double 	annualInterestRate; 
/**
 * amortizationPeriod - is the total length of the loan in years 
 */
	private int	amortizationPeriod; 
	

	public double getMortgageAmount() {
		return mortgageAmount;
	}

	public void setMortgageAmount(double mortgageAmount) {
		this.mortgageAmount = mortgageAmount;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public int getAmortizationPeriod() {
		return amortizationPeriod;
	}

	public void setAmortizationPeriod(int amortizationPeriod) {
		this.amortizationPeriod = amortizationPeriod;
	}

	
/**
 * Simple default constructor. This will create an empty object.	
 */
	public Loan() {
		
	}
	
	
/**
 * This constructor creates an object with parameters it takes in.
	 * @param mortgageAmount
	 * @param annualInterestRate
	 * @param amortizationPeriod
	 */
	public Loan(double mortgageAmount, double annualInterestRate,
			int amortizationPeriod) {
		super();
		this.mortgageAmount = mortgageAmount;
		this.annualInterestRate = annualInterestRate;
		this.amortizationPeriod = amortizationPeriod;
	}

/**
* Rounds a double value to 2 decimal places
* @param valueToRound the value to round
* @return the value rounded to 2 decimal places
*/
	 public static double roundTo2Decimals(double valueToRound)
	 {
	  return Math.round( valueToRound * 100.0 ) / 100.0;
	 }
	
/**
* This method will calculate the monthly payment of a mortgage loan.
* @return double monthlyPayment
*/
	public double getMonthlyPayment(){
		
		double monthlyPaymentCalculationSegment = Math.pow(1.0 + (annualInterestRate/200.0), 1.0/6.0);
		
		
		double monthlyPayment = mortgageAmount * ((monthlyPaymentCalculationSegment - 1) /
				(1 - Math.pow(monthlyPaymentCalculationSegment, (-12 * amortizationPeriod))));

		monthlyPayment = roundTo2Decimals(monthlyPayment);
				
			return monthlyPayment;
	}
	
/**
 * This method returns an array of LoanSchedule objects. The values for monthlyPercentageRate, interestPaid and principalPaid 
 * are calculated in this method. The remaining balance is is is declared and re-adjusted after each monthly payment. 
 * @return LoanSchedule[] loanSchedulArray
 */
	public LoanSchedule[] getLoanScheduleArray()
	{
		
		double interestPaid; 
		double principalPaid;
		// number of payments is the loan term (in years) multiply by the number of months per year (12)
		int numberOfPayments = amortizationPeriod * 12;
		
		LoanSchedule[] loanScheduleArray = new LoanSchedule[ numberOfPayments ];
		// set the initial remaining balance equal to amount borrowed
		double remainingBalance = mortgageAmount;
		
		// calculate monthlyPercentageRate
		double monthlyPercentageRate = Math.pow(1.0 +(annualInterestRate/200.0), 1.0/6.0) - 1.0;
		
		for( int paymentNumber = 1; paymentNumber <= numberOfPayments;  paymentNumber++ )
		{
			
				// calculate interestPaid and round to 2 decimal places
				interestPaid = roundTo2Decimals(monthlyPercentageRate * remainingBalance);
			
				// calculate principalPaid and round to 2 decimal places
				principalPaid = roundTo2Decimals(getMonthlyPayment() - interestPaid);
			
				// update remainingBalance and round to 2 decimal places
				remainingBalance = roundTo2Decimals(remainingBalance - principalPaid);
				
				if(paymentNumber == numberOfPayments)
				{
						principalPaid = (principalPaid + remainingBalance);
				}
				
				// set remainingBalance to zero if it is calculated to be less than zero//
				//Must be less than 1, a decimal is not smaller than zero. A negative decimal is smaller than zero.
				//The balance will not be negative so a variable tested to be less than zero will always be false.
				if(remainingBalance < 1)
				{
					
					remainingBalance = 0.00;
				}
				
				
				// arrays in Java are 0-index based
				loanScheduleArray[ paymentNumber - 1 ] = 
						new LoanSchedule(paymentNumber, interestPaid, principalPaid, remainingBalance);

			}
			 
		return loanScheduleArray;
	}
	
}
