package conceptualSelenium;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

//GO TO DEVELOPER WINDOWS THEN EVENTLISTENER THEN BLUR AND CLICK REMOVE ONE BY ONE.
public class A_HandleHiddenDropDownValuesAutoSuggestion 
{
	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception 
	{
		
		WebDriverManager.chromedriver().setup();
		
		driver  = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("macbook pro");
		
		Thread.sleep(3000);
		
		List<WebElement> suggestionList = driver.findElements(By.xpath("//div[contains(@class,'lrtEPN')]"));
		
		for(WebElement e :suggestionList )
		{
			System.out.println(e.getText());
		}
		
		
		
	}

}
