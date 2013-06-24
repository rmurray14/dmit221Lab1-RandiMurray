package ca.nait.dmit.domain;

import java.util.Set;

import javax.validation.ConstraintViolation;
import static org.junit.Assert.*;
import org.junit.Test;



public class BMITest {

	
	@Test
	  public void testBMIUnderweight()
	  {
		BMI bmi = new BMI(100, 5,6);
		assertEquals(16.1, bmi.getBMI(), 0.05);
		assertTrue(bmi.getBMICategory().equalsIgnoreCase("underweight"));
	  }
	
	@Test
	  public void testBMINormal()
	  {
		BMI bmi = new BMI(140, 5 ,6);
		assertEquals(22.6, bmi.getBMI(), 0.05);
		assertTrue(bmi.getBMICategory().equalsIgnoreCase("normal"));

	  }

	  @Test
	  public void testBMIOverweight()
	  {
		BMI bmi = new BMI(175, 5, 6);
		assertEquals(28.2, bmi.getBMI(), 0.05);
		assertTrue(bmi.getBMICategory().equalsIgnoreCase("overweight"));
	  }

	  @Test
	  public void testBMIObese()
	  {
		BMI bmi = new BMI(200, 5, 6);
		assertEquals(32.3, bmi.getBMI(), 0.05);
		assertTrue(bmi.getBMICategory().equalsIgnoreCase("obese"));
	  }
	  
	  @Test
	  public void testWeightConstraint()
	  {
		  javax.validation.ValidatorFactory factory = javax.validation.Validation.buildDefaultValidatorFactory(); 
		  javax.validation.Validator validator = factory.getValidator();
				
			BMI bmi =new BMI();
			
			Set<ConstraintViolation<BMI>>constraintViolations
			= validator.validateProperty(bmi, "weight");
			
		  assertEquals(1,constraintViolations.size()); 
		  assertEquals("Weight must be at least 40lbs.", constraintViolations.iterator().next().getMessage());
	  }
	  
	  @Test
	  public void testHeightFeetConstraint()
	  {
		  javax.validation.ValidatorFactory factory = javax.validation.Validation.buildDefaultValidatorFactory(); 
		  javax.validation.Validator validator = factory.getValidator();
				
			BMI bmi =new BMI();
			
			Set<ConstraintViolation<BMI>>constraintViolations
			= validator.validateProperty(bmi, "heightFeet");
			
		  assertEquals(1,constraintViolations.size()); 
		  assertEquals("Height feet must be at least 3ft.", constraintViolations.iterator().next().getMessage());
	  }
	  
	  @Test
	  public void testHeightInchesConstraint()
	  {
		  javax.validation.ValidatorFactory factory = javax.validation.Validation.buildDefaultValidatorFactory(); 
		  javax.validation.Validator validator = factory.getValidator();
				
			BMI bmi =new BMI();
			
			Set<ConstraintViolation<BMI>>constraintViolations
			= validator.validateProperty(bmi, "heightInches");
			
		  assertEquals(1,constraintViolations.size()); 
		  assertEquals("Height inches must be less than 12 inches.", constraintViolations.iterator().next().getMessage());
	  }
}
