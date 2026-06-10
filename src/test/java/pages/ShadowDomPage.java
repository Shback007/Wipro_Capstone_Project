package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ScrollUtil;

public class ShadowDomPage {
	
	private WebDriver driver;
	
	public ShadowDomPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//SELCTORS
	
	//Shadow Host
	private By shadowHost = By.id("shadow_host");
	
	//Nested Shadow Host
	private By nestedShadowHost = By.id("nested_shadow_host");
	
	//Youtube Link Outside Shadowdom
	private By youtubeLink = By.linkText("Youtube");
	
	//Get Shadow Root
	public SearchContext getShadowRoot() {
		
		WebElement host = driver.findElement(shadowHost);
		
		ScrollUtil.scrollToElement(driver, host);
		
		return host.getShadowRoot();	
	}
	
	//Get Nested Shadow Root
	public SearchContext getNestedShadowRoot() {
		
		SearchContext shadowRoot = getShadowRoot();
		
		WebElement nestedHost = shadowRoot.findElement(nestedShadowHost);
		
		return nestedHost.getShadowRoot();
	}
	
	
	//Mobile Label Shadow Root
	public String getMobileLabel() {
		
		return getShadowRoot().findElement(By.cssSelector("span.info")).getText();
	}
	
	//Laptop Label Nested Shadow Dom
	public String getLaptopLabel() {
		
		return getNestedShadowRoot().findElement(By.cssSelector("div")).getText();
	}
	
	
	//Blog Link Shadow Root
	public String getBlogLinkText() {
		
		return getShadowRoot().findElement(By.cssSelector("a")).getText();
	}
	
	//Enter Text Shadow Root
	public String enterText(String text) {
		
		WebElement input = getShadowRoot().findElement(By.cssSelector("input[type='text']"));
		
		input.sendKeys(text);
		
		return input.getAttribute("value");
				
	}
	
	//Checkbox Shadow Root
	public boolean selectCheckBox() {
		
		WebElement checkbox = getShadowRoot().findElement(By.cssSelector("input[type='checkbox']"));
		
		if(!checkbox.isSelected())
			checkbox.click();
		
		return checkbox.isSelected();
	}
	
	//File Upload Shadow Root
	public String uploadFile(String fileName) {
		
		String filePath = System.getProperty("user.dir") + "/src/test/resources/" + fileName;
		
		WebElement upload = getShadowRoot().findElement(By.cssSelector("input[type='file']"));
		
		upload.sendKeys(filePath);
		
		return upload.getAttribute("value");
	}
	
	//Youtube Dom
	public String getYoutubeText() {
		
		return driver.findElement(youtubeLink).getText();
	}
	
	

}
