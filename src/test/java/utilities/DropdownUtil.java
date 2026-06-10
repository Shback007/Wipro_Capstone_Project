package utilities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtil {
	
	//Single Select
	
	public static void selectByVisibleText(WebElement dropdownElement,
											String value) {
		
		Select drp = new Select(dropdownElement);
		
		drp.selectByVisibleText(value);
	}
	
	//Multi Select
	
	public static void selectMultipleOptions(WebDriver driver,
											 WebElement dropdownElement,
											 String[] values) {
		
		Select drp = new Select(dropdownElement);
		
		List<WebElement> options = drp.getOptions();
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.CONTROL);
		
		for(String value: values) {
			
			for(WebElement option:options) {
				
				if(option.getText().equalsIgnoreCase(value))
					
					act.click(option);
			}
		}
		
		act.keyUp(Keys.CONTROL).perform();
	}
	
	public static Set<String>getSelectedOptions(WebElement element) {

		
		Select drp =new Select(element);

		Set<String> selectedValues = new HashSet<>();


		List<WebElement> selectedOptions =

        drp.getAllSelectedOptions();


		for(WebElement option: selectedOptions) {

			selectedValues.add(option.getText());
		}


		return selectedValues;
	}

}
