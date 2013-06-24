package ca.nait.dmit.domain;
//current time spent on lab 1: 5hrs

/**
 * This class is used to calculate a person's body mass index (BMI) and their
 * BMI category using the BMI formula with a weight and height(in inches).
 * 
 * @author rmurray14
 * @version 2013.06.21
 */

public class BMI {

	/**
	 * The input value for weight in pounds.
	 */
	private int weight;
	
	/**
	 * The input value for the feet measurement in a height.
	 */
	private int heightFeet;
	
	/**
	 * The input value for the inches measurement in a height.
	 */
	private double heightInches;

	/**
	 * Simple default constructor. This will create an empty object.
	 */
	public BMI() {

	}

	/**
	 * A constructor that creates an object with input parameters
	 * 
	 * @param weight
	 * @param heightFeet
	 * @param heightInches
	 */
	public BMI(int weight, int heightFeet, double heightInches) {
		super();
		this.weight = weight;
		this.heightFeet = heightFeet;
		this.heightInches = heightInches;
	}

	/**
	 * auto-generated getter
	 * 
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * auto-generated setter
	 * 
	 * @return weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * auto-generated getter
	 * 
	 * @return height
	 */
	public int getHeightFeet() {
		return heightFeet;
	}

	/**
	 * auto-generated setter
	 * 
	 * @return weight
	 */
	public void setHeightFeet(int heightFeet) {
		this.heightFeet = heightFeet;
	}
	/**
	 * auto-generated getter
	 * 
	 * @return heightInches
	 */
	public double getHeightInches() {
		return heightInches;
	}

	/**
	 * auto-generated setter
	 * 
	 * @return heightInches
	 */
	public void setHeightInches(double heightInches) {
		this.heightInches = heightInches;
	}

	/**
	 * This method calculates the height in feet and inches to height only in inches.
	 * @return heightInches
	 */
	public double getHeightInInches() {
		
		return (heightFeet * 12) + heightInches;
	}

	/**
	 * Calculate the body mass index (BMI) using the weight and height of the
	 * person. The BIM of a person is calculated using the formula: BMI = 700 *
	 * Weight /(height * height)
	 * 
	 * @return double, the body mass index(BMI) value of the person
	 */
	public double getBMI() {
		double BMI = (703 * weight) / (Math.pow(getHeightInInches(), 2));
		return BMI;
	}

	/**
	 * This method gets the string value that represents a category based on the
	 * calculations in the getBMI() method.
	 * 
	 * @return String, one of the following: underweight, normal, overweight,
	 *         obese.
	 */
	public String getBMICategory() {
		String category = "";
		double BMI = getBMI();

		if (BMI < 18.5) {
			category = "underweight";
		} else if (BMI >= 18.5 && BMI < 25) {
			category = "normal";
		} else if (BMI >= 25 && BMI < 30) {
			category = "overweight";
		} else if (BMI >= 30) {
			category = "obese";
		}

		return category;

	}
}
