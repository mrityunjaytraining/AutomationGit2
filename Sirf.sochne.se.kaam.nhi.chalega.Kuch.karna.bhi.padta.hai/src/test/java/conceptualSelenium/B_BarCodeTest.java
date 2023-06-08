package conceptualSelenium;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import io.github.bonigarcia.wdm.WebDriverManager;

public class B_BarCodeTest  //ZXing Java SE Extensions » 3.3.3
{
	@Test
	public void barCodeTest() throws Exception
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://barcode.tec-it.com/en");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		
		String barCodeUrl = driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println(barCodeUrl);
		
		URL url = new URL(barCodeUrl);
		BufferedImage bufferedImage = ImageIO.read(url);

		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap binaryBitMap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		
		Result result= new MultiFormatReader().decode(binaryBitMap);
		System.out.println(result.getText());
		
	}

}
