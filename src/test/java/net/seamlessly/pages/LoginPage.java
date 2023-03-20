package net.seamlessly.pages;

import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	@FindBy(id = "user")
	public WebElement usernameBox;

	@FindBy(id = "password")
	public WebElement passwordBox;

	@FindBy(id = "submit-form")
	public WebElement loginButton;

	@FindBy(xpath ="//p[@class='warning wrongPasswordMsg']")
	public WebElement wrongPasswordMsg;

	@FindBy(className ="toggle-password")
	public WebElement togglePassword;

	@FindBy(xpath ="//input[@placeholder='Password']")
	public WebElement passwordPlaceholder;

	@FindBy(xpath ="//input[@placeholder='Username or email']")
	public WebElement usernamePlaceholder;

	@FindBy(id ="lost-password")
	public WebElement forgotPassword;

	@FindBy(id ="reset-password-submit")
	public WebElement resetPassword;



	public void login(String username, String password ){
		Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
		usernameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		loginButton.click();
	}


}
