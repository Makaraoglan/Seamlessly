package net.seamlessly.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

	@FindBy(css = "div.avatardiv.popovermenu-wrapper")
	public WebElement avatarIcon;

	@FindBy(xpath = "//img[@src='/core/img/actions/logout.svg?v=c77e0e80']")
	public WebElement logoutButton;

	public void logout(){
		avatarIcon.click();
		logoutButton.click();
	}
}
