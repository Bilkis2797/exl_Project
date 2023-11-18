package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public void selectFromDropdown(WebElement element, String visibleTest) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleTest);
	}
	
	public int generateRandomNum(int boundryNum) {
		Random rnd = new Random();
		int generateNum = rnd.nextInt(boundryNum);
		return generateNum;
	}
	
	
}
