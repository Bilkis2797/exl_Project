package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how= How.XPATH, using="//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")WebElement ADD_CONTACT_HEADER_ELEMET;
	@FindBy(how= How.XPATH, using="//*[@id=\"account\"]")WebElement FULL_NAME_ELEMET;
	@FindBy(how= How.XPATH, using="//*[@id=\"cid\"]")WebElement COMPANY_ELEMET;
	@FindBy(how= How.XPATH, using="//*[@id=\"email\"]")WebElement EMAIL_ELEMET;
	@FindBy(how= How.XPATH, using="//*[@id=\"phone\"]")WebElement PHONE_ELEMET;
	@FindBy(how= How.XPATH, using="//*[@id=\"country\"]")WebElement COUNTRY_ELEMET;
	@FindBy(how= How.XPATH, using="//*[@id=\"address\"]")WebElement ADDRESS_ELEMET;
	@FindBy(how= How.XPATH, using="//*[@id=\"city\"]")WebElement CITY_ELEMET;
	@FindBy(how= How.XPATH, using="//*[@id=\"state\"]")WebElement STATE_ELEMET;
	@FindBy(how= How.XPATH, using="//*[@id=\"zip\"]")WebElement ZIP_ELEMET;
	@FindBy(how= How.XPATH, using="//*[@id=\"submit\"]")WebElement SAVE_BUTTON_ELEMET;

	public void verifyAddContactPage(String addContactHeaderText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ADD_CONTACT_HEADER_ELEMET));
		Assert.assertEquals(ADD_CONTACT_HEADER_ELEMET.getText(), addContactHeaderText, "wrong page!");
	}
	
	String insertedName;
	public void insertFullName(String fullName) {
		insertedName = fullName+ generateRandomNum(999);
		FULL_NAME_ELEMET.sendKeys(insertedName);
	}
	
	public void selectCompany(String company) {
		selectFromDropdown(COMPANY_ELEMET, company);
	}
	
	public void insertEmail(String email) {
		EMAIL_ELEMET.sendKeys(generateRandomNum(987)+email);
	}
	
	public void insertPhone(String phoneNum) {
		PHONE_ELEMET.sendKeys(phoneNum + generateRandomNum(9999));
	}
	
	public void insertAddress(String address) {
		ADDRESS_ELEMET.sendKeys(address);
	}
	public void insertCity(String city) {
		CITY_ELEMET.sendKeys(city);
	}
	public void insertState(String state) {
		STATE_ELEMET.sendKeys(state);
	}
	public void insertZip(String zip) {
		ZIP_ELEMET.sendKeys(zip);
	}
	public  void selectCountry(String country) {
		selectFromDropdown(COUNTRY_ELEMET, country);
	}
	
	public void clickSaveButton() {
		SAVE_BUTTON_ELEMET.click();
	}
	
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[i]/td[3]
	//tbody/tr[1]/td[7]/a[2](Delete Button)
		
		String begining_xpath = "//tbody/tr[";
		String ending_xpath = "]/td[3]";
		String begining_xpath_delete = "//tbody/tr[";
		String ending_xpath_delete = "]/td[7]/a[2]";
		
		public void validateAndDeleteAddedNameOnListCustomer() {
			
			for(int i=1; i>=10 ; i++) {
			//	driver.findElement(By.xpath("//tbody/tr["+ i +  "]/td[3]"));
			  String nameOnList =driver.findElement(By.xpath(begining_xpath + i +ending_xpath)).getText();
			System.out.println(nameOnList);
			
	//		Assert.assertEquals(nameOnList, insertedName, "Name does not exist!");
			
			if(nameOnList.contains(insertedName)) {
				System.out.println("Entered name exist!!!");
				driver.findElement(By.xpath(begining_xpath_delete+i+ending_xpath_delete));
				break;

			}
			}
	
		}
		}
