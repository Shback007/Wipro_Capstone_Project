package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.DropdownUtil;
import utilities.ScrollUtil;

public class ListPage {
	
	private WebDriver driver;
	
	public ListPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	
	 private By colorDropdown = By.id("colors");
	 
	 private By animalDropdown = By.id("animals");
	 
	 
	//WebElement Methods
	 public WebElement getColorDropdown() {
		 
		 WebElement dropdown= driver.findElement(colorDropdown);
		 
		 ScrollUtil.scrollToElement(driver, dropdown);
		 
		 return dropdown;
		 
		 
	 }
	 
	 public WebElement getAnimalDropdown() {
		 
		 WebElement dropdown= driver.findElement(animalDropdown);
		 
		 ScrollUtil.scrollToElement(driver, dropdown);
		 
		 return dropdown;
	 }
	 
	 //Select single color
	 
	 public void selectColor(String color) {
		 
		 DropdownUtil.selectByVisibleText(getColorDropdown(),
				 						  color);
		 
	 }
	 
	 //select multi color
	 
	 public void selectMultipleColors(String[] colors) {
		 
		 DropdownUtil.selectMultipleOptions(driver, 
				 getColorDropdown(), 
				 colors);
	 }
	 
	 	 
	// Select Single Animal

	    public void selectAnimal(String animal) {

	        DropdownUtil.selectByVisibleText(

	                getAnimalDropdown(),

	                animal);
	    }

	// Select Multiple Animal

	    public void selectMultipleAnimals(
	            String[] animals) {

	        DropdownUtil.selectMultipleOptions(

	                driver,

	                getAnimalDropdown(),

	                animals);
	    }
	    
	    public Set<String> getSelectedColors() {

	        return DropdownUtil
	                .getSelectedOptions(

	                        driver.findElement(
	                                colorDropdown));
	    }



	    public Set<String> getSelectedAnimals() {

	        return DropdownUtil.getSelectedOptions(
	                        driver.findElement(animalDropdown));
	    }
}
