package com.iwantthisnear.tool;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This controls the behaviors of the program on the browser.
 * @author Mauricio Román
 *
 */

public class FormCommands {

	WebDriver driver;
	NearVariables vars;

	/**
	 * Initiates the variables and Xpaths needed.
	 */
	public FormCommands() {
		this.vars = new NearVariables();
	}
	
	/**
	 * Initiates Selenium Chrome Driver
	 */
	public void createChromeDriver() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	/**
	 * It opens the Chrome Browser
	 * @param webAddress that will show up once the browser opens
	 */
	public void openBrowser(String webAddress) {
		driver.get(webAddress);
		driver.manage().window().maximize();
	}
	
	/**
	 * Fill out the field for the address of reference for the distance estimation.
	 * @param String which contains the reference address
	 */
	public void setAddres1() {
		driver.findElement(By.xpath(NearVariables.address1)).sendKeys(NearVariables.setAddress1());
	}

	/**
	 * Fill out the field for the address of destination for the distance estimation.
	 * @param String which contains the destination address
	 */	
	public void setAddres2(String valuedAddress) {
		driver.findElement(By.xpath(NearVariables.address2)).sendKeys(valuedAddress.trim());
	}
	
	/**
	 * It makes click on the button to estimate the distance.
	 */
	public void clickEstimate() {
		driver.findElement(By.xpath(NearVariables.buttonDistance)).click();
	}
	
	/**
	 * Cleans up the specified text box. 
	 * @param textBox String with the Text Box XPath Variable
	 */
	public void cleanTextBox(String textBox) {
		driver.findElement(By.xpath(textBox)).clear();
	}

	/**
	 * Takes the distance estimated by the web page 
	 * @return String with the distance estimated by the web page.
	 */
	public String getDistance() {
		String finalDistance;
		WebElement value = driver.findElement(By.xpath(NearVariables.fullLabelDistance));
		finalDistance = value.getText();
		String[] words = finalDistance.split("\\s+");
		return words[2];
	}
}
