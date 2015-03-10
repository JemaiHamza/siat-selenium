package org.siat.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * The Class DashbaordPage.
 */
public class DashbaordPage extends Page
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
	public DashbaordPage(final WebDriver webDriver)
	{
		super(webDriver);
	}
}
