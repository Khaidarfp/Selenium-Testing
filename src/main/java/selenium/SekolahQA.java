package selenium;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SekolahQA {
	public static void main(String[] args) {
		
		String projectLocation = System.getProperty("user.dir");
		WebDriver driver;
		WebDriverWait wait;
		System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);

		String url = "https://www.sekolahqa.com/";
		driver.get(url);

		String title = driver.getTitle();
		int titleLength = driver.getTitle().length();
		System.out.println("Title of the page is : " + title);
		System.out.println("Length of the title is : " + titleLength);

		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(url, actualUrl);

		String PageSource = driver.getPageSource();
		int pageSourceLength = driver.getPageSource().length();
		System.out.println("Length of the page source is : " + pageSourceLength);

		driver.close();
	}
}
