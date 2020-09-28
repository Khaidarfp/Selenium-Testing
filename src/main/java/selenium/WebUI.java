package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUI {
	public static void main(String[] args) {

		String projectLocation = System.getProperty("user.dir");
		WebDriver driver;
		WebDriverWait wait;
		System.setProperty("webdriver.chrome.driver", projectLocation + "\\lib\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);

		String url = "https://demo.opensourcepos.org/login/";
		driver.get(url);
		
		By inputUsername = By.xpath("//input[@name='username']");
		By inputPassword = By.xpath("//input[@name='password']");
		By btnLogin = By.xpath("//input[@name='loginButton']");
		driver.findElement(inputUsername).sendKeys("admin");
		driver.findElement(inputPassword).sendKeys("password");
		driver.findElement(btnLogin).click();
		
		String actualResult = driver.findElement(By.xpath("//div[@class='error']")).getText();
		String expecctedResult = "Usuario o Contraseña no válidos.";
		Assert.assertEquals(expecctedResult, actualResult);
	}
}
