package demandableAutomationEngineerWithCroreSalary;

public class TC_003 extends BaseTest
{
	public static void main(String[] args) throws Exception
	{
		init();
		
		launch("chromebrowser");
		
		driver.manage().window().maximize();
		
		navigateUrl("amazonurl");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		driver.manage().deleteAllCookies();
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		driver.navigate().forward();
		
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		
		driver.close();
		
	//	driver.quit();
		
	}

}
