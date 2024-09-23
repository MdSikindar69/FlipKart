package Pages;

import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogin {
	WebDriver driver;

	public UserLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@title='Login']/parent::div)[2]")
	WebElement login;

	@FindBy(xpath = "//span[text()='Enter Email/Mobile number']/parent::label/parent::div/input")
	WebElement enterUserName;

	@FindBy(xpath = "//button[contains(text(),'OTP')]")
	WebElement requestOTP;

	public void applicationLogin(String email) {
		login.click();
		enterUserName.sendKeys(email);
		requestOTP.click();
	}

}
