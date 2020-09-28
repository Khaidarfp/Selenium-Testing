package selenium;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Facebook {
	public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");
		WebDriver driver;
		WebDriverWait wait;
		System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);

		String url = "https://www.facebook.com/r.php?locale=id_ID";
		driver.get(url);
		
		By btnDropdown1 = By.id("day");
		Select dropdown1 = new Select(driver.findElement(By.id("day")));
		dropdown1.selectByIndex(21);
		
		By btnDropdown2 = By.id("month");
		Select dropdown2 = new Select(driver.findElement(By.id("month")));
		dropdown2.selectByValue("2");
		
		By btnDropdown3 = By.id("year");
		Select dropdown3 = new Select(driver.findElement(By.id("year")));
		dropdown3.selectByVisibleText("1997");
		
//		driver.close();
	}
}
