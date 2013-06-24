package ca.nait.dmit.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import util.JSFUtil;
import org.primefaces.model.chart.CartesianChartModel;  
import org.primefaces.model.chart.ChartSeries;  

import ca.nait.dmit.domain.Loan;
import ca.nait.dmit.domain.LoanSchedule;

@ManagedBean(name="loanBean")
@SessionScoped
public class LoanController {
	
	Loan currentLoan = new Loan();
	

	private CartesianChartModel loanModel = new CartesianChartModel();
	
	public CartesianChartModel getLoanModel(){
		return loanModel;
	}

	
	public Loan getCurrentLoan() {
		return currentLoan;
	}

	public void setCurrentLoan(Loan currentLoan) {
		this.currentLoan = currentLoan;
	}



	public LoanSchedule[] getLoanScheduleTable() {
		return loanScheduleTable;
	}



	public void setLoanScheduleTable(LoanSchedule[] loanScheduleTable) {
		this.loanScheduleTable = loanScheduleTable;
	}

	LoanSchedule[] loanScheduleTable = null;
   
	public void calculatePayment(){
        
		JSFUtil.addInfoMessage("Your monthly payment is: " + currentLoan.getMonthlyPayment());
		
		ChartSeries year = new ChartSeries();
        year.setLabel(currentLoan.getMortgageAmount() + " at " + currentLoan.getAnnualInterestRate() + "% for " + currentLoan.getAmortizationPeriod()
        		+ " years");
        
		loanScheduleTable = currentLoan.getLoanScheduleArray();
		
		for (int paymentNumber = 11; paymentNumber <= loanScheduleTable.length; paymentNumber += 12) {
			year.set((paymentNumber + 1)/12, loanScheduleTable[paymentNumber].getRemainingBalance());
		}
		
		loanModel.addSeries(year);
	}
	
}
