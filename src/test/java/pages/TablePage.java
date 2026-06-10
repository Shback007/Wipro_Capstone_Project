package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ScrollUtil;


public class TablePage {
	
	private WebDriver driver;
	
	public TablePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By static_WebTable = By.xpath("//table[@name='BookTable']");
	
	private By dynamic_WebTable = By.xpath("//table[@id='taskTable']");
	
	
	
	private By pagination_WebTable= By.xpath("//table[@id='productTable']");
	
	private By pagination= By.xpath("//ul[@id='pagination']");
	
	//Static Web Table Operation
	
	public List<String> getMAximumPriceBookDetails(){
		
		WebElement table = driver.findElement(static_WebTable);
		
		ScrollUtil.scrollToElement(driver, table);
		
		
		List<WebElement> prices = 
				driver.findElements(By.xpath(
							static_WebTable.toString()
							.replace("By.xpath: ", "")
							+ "/tbody/tr/td[4]"
							));
		
		int maxPrice = 0;
		
		WebElement maxPriceElement = null;
		
		//Find Maximum Price Element
		
		for(WebElement price :prices) {
			
			int currentPrice = Integer.parseInt(price.getText());
			
			if(currentPrice > maxPrice) {
				
				maxPrice = currentPrice;
				
				maxPriceElement = price;
			}
		}
		
		//Move to Row
		
		WebElement row = maxPriceElement.findElement(By.xpath("./parent::tr"));
		
		//Get All Coloumns
		
		List<WebElement> columns = row.findElements(By.tagName("td"));
		
		//Store Complete Row Data
		
		List<String> rowDetails = new ArrayList<>();
		
		for(WebElement column : columns) {
			
			rowDetails.add(column.getText());
		}
		
		return rowDetails;
	}
	
	//Get Dynamic Table Details
	
	public List<String> getDynamicTableDetails(){
		
		WebElement table = driver.findElement(dynamic_WebTable);
		
		ScrollUtil.scrollToElement(driver, table);
		
		List<String> details = new ArrayList<>();
		
		//Append Xpath
		
		List<WebElement> elements = driver.findElements(
				By.xpath(
						 dynamic_WebTable.toString()
						 .replace("By.xpath: ", "")
						 + "/following-sibling::div/p"));
		
		//Store Texts
		
		for(WebElement element:elements) {
			details.add(element.getText());
		}
		
		return details;
	}
	
	// Select Pagination Table Row
	public List<String> selectPaginationTableRow(int pageNumber, int rowNumber){
		
		WebElement table = driver.findElement(pagination_WebTable);
		
		ScrollUtil.scrollToElement(driver, table);
		
		driver.findElement(By.xpath(
							pagination.toString()
							
							.replace("By.xpath: ", "")
							
							+ "/li["
							
							+ pageNumber
							
							+ "]")).click();
		
		//Select Checkbox
		
		driver.findElement(By.xpath(
							pagination_WebTable.toString()
							
							.replace("By.xpath:", "")
							
							+ "/tbody/tr["
							
							+ rowNumber
							
							+"]/td[4]/input")).click();
		
		//Store Selected Row Details
		
		List<String> rowDetails = new ArrayList<>();
		
		List<WebElement> columns = driver.findElements(
									By.xpath(
										pagination_WebTable.toString()
										
										.replace("By.xpath:", "")
										
										+ "/tbody/tr["
										
										+ rowNumber
										
										+"]/td"));
		
		//Exclude Checkbox Column
		for(int c=0;c<columns.size();c++) {
			rowDetails.add(columns.get(c).getText());
		}
		
		return rowDetails;
	}
	 
	
	
	
}
