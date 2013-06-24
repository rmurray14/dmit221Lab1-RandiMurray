package ca.nait.dmit.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Min;
import javax.validation.constraints.DecimalMax;

import util.JSFUtil;


import ca.nait.dmit.domain.BMI;

@ManagedBean(name="bmiController")
@SessionScoped
public class BMIController {

	@Min(value=40, message = "Weight must be at least 40lbs.")
	public int weight;
	
	@Min(value=3, message = "Height feet must be at least 3ft.")
	public int heightFeet;
	
	@DecimalMax(value="11.99", message="Height inches must be less than 12 inches.")
	public double heightInches;
	
	
	
	public int getWeight() {
		return weight;
	}



	public void setWeight(int weight) {
		this.weight = weight;
	}



	public int getHeightFeet() {
		return heightFeet;
	}



	public void setHeightFeet(int heightFeet) {
		this.heightFeet = heightFeet;
	}



	public double getHeightInches() {
		return heightInches;
	}



	public void setHeightInches(double heightInches) {
		this.heightInches = heightInches;
	}



	public void calculateBMI()
	{
		BMI bmi = new BMI(weight, heightFeet, heightInches);
		
		if(bmi.getBMI() < 18.5)
			JSFUtil.addWarningMessage("Warning! Your BMI is " + bmi.getBMI() + ", you are " + bmi.getBMICategory());
		
		else if(bmi.getBMI() >= 18.5 && bmi.getBMI() < 25)
			JSFUtil.addInfoMessage("Your BMI is " + bmi.getBMI() + ", you are " + bmi.getBMICategory());
		
		else if(bmi.getBMI() >= 25 && bmi.getBMI() < 30)
			JSFUtil.addWarningMessage("Your BMI is " + bmi.getBMI() + ", you are " + bmi.getBMICategory());
		
		else if(bmi.getBMI() >= 30)
			JSFUtil.addErrorMessage("Warning! Your BMI is " + bmi.getBMI() + ", you are risk of developing heart disease, please see your family doctor.");
	}
	
	
}
