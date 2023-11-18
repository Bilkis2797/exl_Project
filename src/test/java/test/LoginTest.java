package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;

	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\ExlProject.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "user name", 2);
	String password = exlRead.getCellData("LoginInfo", "password", 2);
	String DashboardValidationText = exlRead.getCellData("LoginInfo", "dashboardValidationText", 2);

	@Test
	public void ValidUserShouldBeAbleToLogin() {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();

		 DashboardPage dashboardPage = PageFactory.initElements(driver,
		 DashboardPage.class);
		 dashboardPage.varifyDashboardPage(DashboardValidationText);

		BrowserFactory.TearDown();
	}

}
