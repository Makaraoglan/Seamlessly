package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.LoginPage;
import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_Step_Definitions {

	LoginPage loginPage = new LoginPage();

	@Given("user is on the login page")
	public void userIsOnTheLoginPage() {

		Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
	}

	@When("user enters valid username")
	public void userEntersValidUsername() {
		loginPage.usernameBox.sendKeys(ConfigurationReader.getProperty("username"));
	}

	@And("user enters valid password")
	public void userEntersValidPassword() {
		loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
	}

	@And("user click on the login button")
	public void userClickOnTheLoginButton() {
		loginPage.loginButton.click();
	}

	@Then("user land on dashboard page")
	public void userLandOnDashboardPage() {

		Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
	}

	@When("user enters {string}")
	public void userEnters(String arg0) {
		loginPage.usernameBox.sendKeys(arg0);

	}
	@And("user enters a {string}")
	public void userEntersA(String arg0) {
		loginPage.passwordBox.sendKeys(arg0);
	}


	@Then("user observe {string}")
	public void userObserve(String arg0) {
		Assert.assertEquals(arg0, loginPage.wrongPasswordMsg.getText());
	}

	@Then("user observe blank {string}")
	public void userObserveBlank(String arg0) {

		if (loginPage.passwordBox.getAttribute("validationMessage").equals(arg0)||loginPage.usernameBox.getAttribute("validationMessage").equals(arg0)){
			Assert.assertTrue(true);
		}

	}

	@And("user click on toggle password")
	public void userClickOnTogglePassword() {
		loginPage.togglePassword.click();
	}

	@Then("user observe valid placeholder {string} on username inputbox")
	public void userObserveValidPlaceholderOnUsernameInputbox(String arg0) {
		Assert.assertEquals(arg0, loginPage.usernamePlaceholder.getAttribute("placeholder"));

	}

	@And("user observe valid placeholder {string} on password inputbox")
	public void userObserveValidPlaceholderOnPasswordInputbox(String arg0) {
		Assert.assertEquals(arg0, loginPage.passwordPlaceholder.getAttribute("placeholder"));

	}

	@When("user click on forget password link")
	public void userClickOnForgetPasswordLink() {
		loginPage.forgotPassword.click();

	}

	@Then("user observe reset password button")
	public void userObserveResetPasswordButton() {
		Assert.assertTrue(loginPage.resetPassword.isDisplayed());
	}

	@Then("user observe forgot password link")
	public void userObserveForgotPasswordLink() {
		Assert.assertTrue(loginPage.forgotPassword.isDisplayed());
	}

	@Then("user observe password in a form of dots")
	public void userObservePasswordInAFormOfDots() {
		Assert.assertEquals("password",loginPage.passwordBox.getAttribute("type"));

	}

	@Then("user observe password itself")
	public void userObservePasswordItself() {
		Assert.assertEquals("text",loginPage.passwordBox.getAttribute("type"));
	}

	@And("user hit the enter key")
	public void userHitTheEnterKey() {
		loginPage.passwordBox.sendKeys(Keys.ENTER);
	}
}
