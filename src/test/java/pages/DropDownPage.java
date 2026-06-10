package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ScrollUtil;
import utilities.WaitUtil;

public class DropDownPage {
	
	private WebDriver driver;
	
	public DropDownPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Input Box
	private By inputBox = By.xpath("//input[@id='comboBox']");
	
	//Select Value
	public String selectValue(String value) {
		
		WebElement dropdown = driver.findElement(inputBox);
		
		ScrollUtil.scrollToElement(driver, dropdown);
		
		dropdown.click();
		
		//Append Xpath
		
		List<WebElement> allOptions = 
				driver.findElements(
						By.xpath(
								inputBox.toString()
								.replace("By.xpath: ", "")
								+ "/following::div[@class='option']"));
		
		for(WebElement option:allOptions) {
			
			if(option.getText().equalsIgnoreCase(value)) {
				
				String selectedText = option.getText();
				
				ScrollUtil.scrollToElement(driver, option);
				
				WaitUtil.pause(0.5);
				
				option.click();
				
				return selectedText;
			}
				
		}
		
		return "No Option Found";
	}
		
}
