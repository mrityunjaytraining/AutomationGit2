package demandableAutomationEngineerWithCroreSalary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunching
{
	public static void main(String[] args) throws Exception
	{
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();  
		driver.get("https://www.amazon.in");
		
		Thread.sleep(2000);
		
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();  
		driver.get("https://www.amazon.in");
		
		Thread.sleep(2000);
		
		WebDriverManager.edgedriver().setup();   //not supported 3.8.1 but supported latest version 5.3.2
		 driver = new EdgeDriver();  
		driver.get("https://www.amazon.in");
		
		Thread.sleep(2000);  
		
		WebDriverManager.iedriver().setup();
		 driver = new InternetExplorerDriver();  
		driver.get("https://www.amazon.in");  
		
	}

}
