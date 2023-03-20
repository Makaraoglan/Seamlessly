package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.DashboardPage;
import net.seamlessly.pages.LoginPage;
import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Logout_Step_Definitions {

	LoginPage loginPage=new LoginPage();
	DashboardPage dashboardPage=new DashboardPage();

	@Given("User login the app successfully")
	public void userLoginTheAppSuccessfully() {
		loginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
	}

	@When("user click on the avatar icon dropdown")
	public void userClickOnTheAvatarIconDropdown() {
		dashboardPage.avatarIcon.click();
	}

	@And("user click on the Log out button")
	public void userClickOnTheLogOutButton() {
		dashboardPage.logoutButton.click();
	}

	@Then("user can go back to the login page")
	public void userCanGoBackToTheLoginPage() {
		Assert.assertTrue(Driver.getDriver().getTitle().equals("Seamlessly"));
	}

	@When("user successfully logged out")
	public void userSuccessfullyLoggedOut() {
		dashboardPage.logout();
	}

	@And("user click on step back button")
	public void userClickOnStepBackButton() {
		Actions actions = new Actions(Driver.getDriver());
		actions.sendKeys(Keys.BACK_SPACE);
	}

	@Then("can not go to home page")
	public void canNotGoToHomePage() {
		Assert.assertTrue(Driver.getDriver().getTitle().equals("Seamlessly"));

	}
}
