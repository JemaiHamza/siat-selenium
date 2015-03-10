package org.siat.selenium.pages;

import org.openqa.selenium.WebDriver;


/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page
{

	/** The driver. */
	protected WebDriver driver;

	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	/**
	 * Instantiates a new page.
	 * 
	 * @param driver
	 *           the driver
	 */
	public Page(final WebDriver driver)
	{
		//		this.driver = driver;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle()
	{
		return driver.getTitle();
	}

}
