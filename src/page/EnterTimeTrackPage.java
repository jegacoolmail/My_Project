
package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterTimeTrackPage {
	
	//elements
	//help
	@FindBy(xpath="//div[contains(text(),'Help']")
	private WebElement helpLink; 
	
	//About ur actitime
	@FindBy(linkText="About your actiTIME")
	private WebElement aboutLink; 
	
	//product version
	@FindBy(xpath="//span[starts-with(text(),'actiTIME')]")
	private WebElement productVersion; 
	
	//close button
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement closeBTN; 
	
	//logout
	@FindBy(linkText="Logout")
	private WebElement logout; 

//Actions
	//verify title
	
	//click help
	public void clickHelp()
	{
		helpLink.click();
	}
	//click about ur actitime
	
	//verify product version
	//click close button
	//click logout
	

}
