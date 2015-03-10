package org.siat.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.siat.selenium.pages.HomePage;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


/**
 * The Class HomeAndDecide.
 */
public class HomeAndDecide extends SiatTestBase
{
	/** The homepage. */
	private HomePage homepage;

	/** The accept next alert. */
	private boolean acceptNextAlert = true;

	/**
	 * Sets the up.
	 * 
	 * @throws Exception
	 *            the exception
	 */
	@BeforeSuite
	public void setUp() throws Exception
	{
		homepage = PageFactory.initElements(driver, HomePage.class);
	}

	/**
	 * Test home and decide.
	 * 
	 * @throws Exception
	 *            the exception
	 */
	@Test
	public void testHomeAndDecide() throws Exception
	{
		driver.get(baseUrl + "/siat-ct-web/pages/index.xhtml");
		driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
		this.sleep(5);
		final Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//tbody[@id='fileItemListForm:datalist_data']/tr/td[5]"))).doubleClick()
				.perform();
		this.sleep(5);
		driver.findElement(By.xpath("//div[@id='productInformationForm:j_idt454:datalist:1:j_idt484']/div[2]/span")).click();
		this.sleep(5);
		driver.findElement(By.id("productInformationForm:j_idt454:datalist:decideButton")).click();
		this.sleep(5);
		driver.findElement(By.id("systemDecisionForm:j_idt79:j_idt89")).click();
		this.sleep(5);

	}

	/**
	 * Sleep.
	 * 
	 * @param seconds
	 *           the seconds
	 */
	public void sleep(final int seconds)
	{
		try
		{
			Thread.sleep(seconds * 1000);
		}
		catch (final InterruptedException e)
		{

		}
	}

	/**
	 * Checks if is element present.
	 * 
	 * @param by
	 *           the by
	 * @return true, if is element present
	 */
	private boolean isElementPresent(final By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		}
		catch (final NoSuchElementException e)
		{
			return false;
		}
	}

	/**
	 * Checks if is alert present.
	 * 
	 * @return true, if is alert present
	 */
	private boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (final NoAlertPresentException e)
		{
			return false;
		}
	}

	/**
	 * Close alert and get its text.
	 * 
	 * @return the string
	 */
	private String closeAlertAndGetItsText()
	{
		try
		{
			final Alert alert = driver.switchTo().alert();
			final String alertText = alert.getText();
			if (acceptNextAlert)
			{
				alert.accept();
			}
			else
			{
				alert.dismiss();
			}
			return alertText;
		}
		finally
		{
			acceptNextAlert = true;
		}
	}
}
