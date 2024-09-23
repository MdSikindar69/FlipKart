package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchAProduct {
	WebDriver driver;

	public SearchAProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@title='Search for Products, Brands and More']")
	WebElement searchBox;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;
	@FindBy(xpath = "//*[contains(text(),'Apple iPhone 16 (Pink')]")
	WebElement selectItem;
	@FindBy(xpath = "//span[contains(text(),'Apple iPhone 16 (Pink, 128 GB)')]")
	WebElement itemSearched;

	public void itemSearch() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		searchBox.sendKeys("apple");
		searchButton.click();
		selectItem.click();
		Set<String> windowCount = driver.getWindowHandles();
		Iterator<String> it = windowCount.iterator();
		it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Apple iPhone 16 (Pink, 128 GB)')]")));
		System.out.println(itemSearched.isDisplayed());

	}

	public void quit() {
		driver.quit();
	}

}
