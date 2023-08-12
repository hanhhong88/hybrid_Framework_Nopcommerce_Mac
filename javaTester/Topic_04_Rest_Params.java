import org.testng.annotations.Test;

public class Topic_04_Rest_Params {
String address_link = "//div[@class = 'side-2'] //a[text() = 'Addresses']";
String order_link = "//div[@class = 'side-2'] //a[text() = 'Orders']";

String dynamic_sector = "//div[@class = '%s']//a[text() = '%s']";

String dynamic_sidebar_link = "//div[@class = 'side-2'] //a[text() = '%s']";

String dynamic_country = "//td[@data-key='females' and text() = '%s']//following-sibling::td[@data-key='country' and text() = '%s']//following-sibling::td[@data-key='males' and text() = '%s']//following-sibling::td[@data-key='total' and text() = '%s']";
	
	@Test
	public void Test_01_Rest_Params () {
		ClicktoElement(address_link);
		ClicktoElement(order_link);
		
		ClicktoElement(dynamic_sidebar_link, address_link);
		ClicktoElement(dynamic_sidebar_link, order_link);
		
		ClicktoElement(dynamic_sector, "footer", "Orders");
		ClicktoElement(dynamic_sector, "header", "Register");
		
		ClicktoElement(dynamic_country, "276880", "Angola", "276472", "553353");
		
		
	}
//	click to stable arg
//	public void ClicktoElement (String locatorvalue) {
//		System.out.println("Click to: " + locatorvalue);
//	}
	
// click to 1 dynamic arg	
//	public void ClicktoElement (String locatorvalue, String page_name) {
//		System.out.println("Path before is " + locatorvalue);
//		locatorvalue = String.format(locatorvalue, page_name);
//		System.out.println("Path after is " + locatorvalue);
//	}
	
	// click to 2 dynamic args	
//	public void ClicktoElement (String locatorvalue, String sector, String page_name) {
//		System.out.println("Path before is " + locatorvalue);
//		locatorvalue = String.format(locatorvalue, sector, page_name);
//		System.out.println("Path after is " + locatorvalue);
//	}
	
	// click to 4 dynamic args	
//	public void ClicktoElement (String locatorvalue, String females, String country, String males, String total) {
//		System.out.println("Path before is " + locatorvalue);
//		locatorvalue = String.format(locatorvalue, females, country, males, total);
//		System.out.println("Path after is " + locatorvalue);
//	}

	//	any number of args
	public void ClicktoElement (String locatorvalue, String...values) {
		System.out.println("Path before is " + locatorvalue);
		locatorvalue = String.format(locatorvalue, (Object[]) values);
		System.out.println("Path after is " + locatorvalue);
	}

}
