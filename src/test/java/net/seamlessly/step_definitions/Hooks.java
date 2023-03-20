package net.seamlessly.step_definitions;

/*
In the class we will be able to pass pre and post conditions to each scenario and each step
 */


import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import net.seamlessly.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

	//@Before
	public void setupScenario(){

	}

	@After
	public void tearDownScenario(Scenario scenario){

		if (scenario.isFailed()){

		byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());

		}

		Driver.closeDriver();
	}

	//@BeforeStep
	public void setupStep(){

	}
	//@AfterStep
	public void afterStep(){

	}
}
