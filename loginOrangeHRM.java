package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginOrangeHRM {
    static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		String expectedTitle="OrangeHRM";
		String actualTitle=driver.getTitle();
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Title is correct");
			}
		else {
			System.out.println("Title is not correct");
		}
		
		WebElement displayedheader = driver.findElement(By.xpath("//h5"));
		
		String login = displayedheader.getText();
		System.out.println("Header is: "+login);
		
		System.out.println(driver.findElement(By.partialLinkText("Inc")).isDisplayed());
		
			//driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		//driver.findElement(By.xpath("//button[contains(@class,\"login\")]")).click();
		
		//by the style of the submit button
		//#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button
		
		driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")).click();
		
		
		
		driver.close();
	}

}
