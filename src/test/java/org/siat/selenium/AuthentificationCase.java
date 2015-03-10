package org.siat.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.siat.selenium.pages.HomePage;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


/**
 * The Class AuthentificationCase.
 */
public class AuthentificationCase extends SiatTestBase
{

	/** The accept next alert. */
	private boolean acceptNextAlert = true;

	/** The homepage. */
	private HomePage homepage;

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
	 * Test authentification case.
	 * 
	 * @throws Exception
	 *            the exception
	 */
	@Test
	public void testAuthentificationCase() throws Exception
	{
		driver.get(baseUrl + "/siat-ct-web/pages/unsecure/login.xhtml");
		driver.findElement(By.id("loginForm:j_username")).clear();
		driver.findElement(By.id("loginForm:j_username")).sendKeys("dqpc-sa-agent");
		driver.findElement(By.id("loginForm:j_password")).clear();
		driver.findElement(By.id("loginForm:j_password")).sendKeys("root");
		driver.findElement(By.id("loginForm:loginBtn")).click();
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
