package org.siat.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * Sample page.
 */
public class HomePage extends Page
{

	/** The header. */
	@FindBy(how = How.TAG_NAME, using = "h1")
	@CacheLookup
	public WebElement header;

	/**
	 * Instantiates a new home page.
	 * 
	 * @param webDriver
	 *           the web driver
	 */
	public HomePage(final WebDriver webDriver)
	{
		super(webDriver);
	}
}
