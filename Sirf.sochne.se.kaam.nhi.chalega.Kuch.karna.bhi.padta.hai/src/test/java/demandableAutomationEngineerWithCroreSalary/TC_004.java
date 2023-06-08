package demandableAutomationEngineerWithCroreSalary;

public class TC_004 extends BaseTest
{
	public static void main(String[] args) throws Exception
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		selectOption("amazonsearchdropbox_id","Books");
		
		typeText("amazonsearchtextbox_name","Ramayana");
		
		clickElement("amazonsearchbutton_xpath");
		
		
	}



}
