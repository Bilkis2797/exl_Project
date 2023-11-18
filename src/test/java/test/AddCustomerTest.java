package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\Test_Data\\ExlProject.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "user name", 2);
	String password = exlRead.getCellData("LoginInfo", "password", 2);
	String DashboardValidationText = exlRead.getCellData("LoginInfo", "dashboardValidationText", 2);
    String addContactValidationText = exlRead.getCellData("AddContactInfo", "AddContactText", 2);
    String fullName = exlRead.getCellData("AddContactInfo", "FullName", 2);
    String company = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
    String email = exlRead.getCellData("AddContactInfo", "Email", 2);
    String phone = exlRead.getCellData("AddContactInfo", "Phone", 2);
    String address = exlRead.getCellData("AddContactInfo", "Address", 2);
    String city = exlRead.getCellData("AddContactInfo", "City", 2);
    String state = exlRead.getCellData("AddContactInfo", "State", 2);
    String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
    String country = exlRead.getCellData("AddContactInfo", "Country", 2);
	
	
	@Test
	public void validCustomerShouldBeAbleToCreateCustomer() throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();
		
		Thread.sleep(3000);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.varifyDashboardPage(DashboardValidationText);
		dashboardPage.clickOnCustomer();
		dashboardPage.clickOnAddCustomer();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddContactPage(addContactValidationText);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(company);
		addCustomerPage.insertEmail(email);
		addCustomerPage.insertPhone(phone);	
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(country);
		addCustomerPage.clickSaveButton();
		
		dashboardPage.clickonListCustomers();	
		
//		addCustomerPage.validateAddedNameOnListCustomer();
		
//		ListCustomerPage listCustomerPage=PageFactory.initElements(driver, ListCustomerPage.class);
//		listCustomerPage.validateAddedNameOnListCustomer();
	}
	
	
	
	
}
