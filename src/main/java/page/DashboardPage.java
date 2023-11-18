package page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how= How.XPATH, using="//*[@id=\"page-wrapper\"]/div[2]/div/h2")WebElement DASHBOARD_HEADER_ELEMET;
	@FindBy(how= How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/a/span[1]")WebElement CUSTOMER_MENU_ELEMET;
	@FindBy(how= How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")WebElement ADD_CUSTOMER_MENU_ELEMET;
	@FindBy(how= How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")WebElement LIST_CUSTOMER_ELEMET;


    public void varifyDashboardPage(String dashboardtext) {
    	Assert.assertEquals(DASHBOARD_HEADER_ELEMET.getText(), dashboardtext, "wrong page!");
    }

    public void clickOnCustomer() {
    	CUSTOMER_MENU_ELEMET.click();
    }
     
    public void clickOnAddCustomer() {
    	ADD_CUSTOMER_MENU_ELEMET.click();
    	
    }
    public void clickonListCustomers() throws InterruptedException {
    	Thread.sleep(2000);
    	LIST_CUSTOMER_ELEMET.click();
    }
    
}
