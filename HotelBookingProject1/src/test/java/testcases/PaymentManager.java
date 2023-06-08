package testcases;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManager 
{
  @Test
  public void applyDiscount()
  {
	  System.out.println("Applying Discount");
  }
  @Test
  @Parameters({"action"})
  public void makePayment(String paymentType,	ITestContext context)
  {
	  if(paymentType.equals("pay@hotel"))
		  System.out.println("pay@hotel Booking");
	  else
		  System.out.println("electronicPayment booking");
	  
	  //booking number
	  String bookingID = "mrity1234";
	  context.setAttribute("bookingid", bookingID);
	  System.out.println("Booking id in makepayment function		: "	+bookingID);
	  
  }
}
