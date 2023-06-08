package demandableAutomationEngineerWithCroreSalary;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest
{
	public static WebDriver driver;
	public static FileInputStream fis;
	public static String projectPath = System.getProperty("user.dir")+"//src//test//resources//";
	public static Properties p;
	public static Properties mainProp ;
	public static Properties childProp;
	public static Properties orProp;
	public static ExtentReports rep;
	
	public static void init() throws Exception
	{
		 fis = new FileInputStream(projectPath+"environment.properties");
		 mainProp = new Properties();
		 mainProp.load(fis);
		String e = mainProp.getProperty("env");
	//	System.out.println(e);
		
		 fis = new FileInputStream(projectPath+e+".properties");
		 childProp = new Properties();
		 childProp.load(fis);
		
		 fis = new FileInputStream(projectPath+"data.properties");
		 p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectPath+"or.properties");
		orProp =new Properties();
		orProp.load(fis);
		
		fis = new FileInputStream(projectPath+"log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		rep = ExtentManagerReport.getInstance();
		
	}
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
	 //	options.addArguments("--remote-allow-origins=*");
			options.addArguments("user-data-dir=C:\\Users\\Computer\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 4");
			options.addArguments("--start-maximized");
		//	options.addArguments("--proxy-server=https://192.168.10.1:9090");
			options.addArguments("--disable-notifications");
			options.addArguments("--ignore-certificate-errors-spki-list");
			options.addArguments("--disable-popup-blocking");
		//	options.addArguments("--incognito");
			
			driver = new ChromeDriver(options);
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	public static void navigateUrl(String url)
	{
	//	driver.get(childProp.getProperty(url));
		driver.navigate().to(childProp.getProperty(url));
	}
	
	
	public static void clickElement(String locatorkey) 
	{
		
	//	driver.findElement(By.xpath(orProp.getProperty(locatorkey))).click();
		getElement(locatorkey).click();
	}

	public static void typeText(String locatorkey, String text) 
	{
		//driver.findElement(By.name(orProp.getProperty(locatorkey))).sendKeys(text);
		getElement(locatorkey).sendKeys(text);
	}

	public static void selectOption(String locatorkey, String option)
	{
		//driver.findElement(By.id(orProp.getProperty(locatorkey))).sendKeys(option);
		getElement(locatorkey).sendKeys(option);
		
	}
	
	public static WebElement getElement(String locatorkey) {
		
		WebElement element = null; 
		
		//Check for Element Presence
		if(!isElementPresent(locatorkey))
			//Report as a failure
			System.out.println("Element is not present :" + locatorkey);
		
		element = driver.findElement(getLocator(locatorkey));
		
		return element;
	}
	
	public static boolean isElementPresent(String locatorkey) {
		
		System.out.println("Checking for Element Present	:"+locatorkey);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorkey)));
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
		
	}
	public  static By getLocator(String locatorkey)
	{
		By by = null;
		
		if(locatorkey.endsWith("_id"))
		{
			by = By.id(orProp.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_name"))
		{
			by = By.name(orProp.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_className"))
		{
			by = By.className(orProp.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_xpath"))
		{
			by = By.xpath(orProp.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_css"))
		{
			by = By.cssSelector(orProp.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_linktext"))
		{
			by = By.linkText(orProp.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_partiallinktext"))
		{
			by = By.partialLinkText(orProp.getProperty(locatorkey));
		}
		
		return by;
	}
	
}


