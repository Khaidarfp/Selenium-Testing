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

public class OrangeHRM {
	public static void main(String[] args) {
		
		String projectLocation = System.getProperty("user.dir");
		WebDriver driver;
		WebDriverWait wait;
		System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);

		String url = "https://opensource-demo.orangehrmlive.com/";
		driver.get(url);

		By inputUsername = By.id("txtUsername");
		By inputPassword = By.id("txtPassword");
		By btnLogin = By.id("btnLogin");
		driver.findElement(inputUsername).sendKeys("Admin");
		driver.findElement(inputPassword).sendKeys("admin123");
		driver.findElement(btnLogin).click();

		String actualResult = driver.findElement(By.id("welcome")).getText();
		String expecctedResult = "Welcome";
		Assert.assertEquals(expecctedResult, actualResult);
		
		By btnAdmin = By.id("menu_admin_viewAdminModule");
		driver.findElement(btnAdmin).click();
		
		By btnDropdown = By.id("searchSystemUser_userType");
		Select dropdown1 = new Select(driver.findElement(By.id("searchSystemUser_userType")));
		dropdown1.selectByValue("2");
		By btnCari = By.id("searchBtn");
		driver.findElement(btnCari).click();
		By btnReset = By.id("resetBtn");
		driver.findElement(btnReset).click();
		
		By txtUsername = By.id("searchSystemUser_userName");
		driver.findElement(txtUsername).sendKeys("hannah.flores");
		driver.findElement(txtUsername).clear();
		
		driver.close();
	}
}
