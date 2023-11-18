package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ListCustomerPage{

	WebDriver driver;
	
	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[i]/td[3]
	
	String begining_xpath = "//tbody/tr[";
	String ending_xpath = "]/td[3]";
	
	public void validateAddedNameOnListCustomer() {
		
		for(int i=1; i>=10 ; i++) {
		//	driver.findElement(By.xpath("//tbody/tr["+ i +  "]/td[3]"));
		  String nameOnList =driver.findElement(By.xpath(begining_xpath + i +ending_xpath)).getText();
		System.out.println(nameOnList);
		
		AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
		String addCustomerPageInsertedName = addCustomerPage.insertedName;
		Assert.assertEquals(nameOnList, addCustomerPageInsertedName, "Name does not exist!");
		
		}
	}
}
