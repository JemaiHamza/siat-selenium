package org.siat.selenium;

import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.siat.selenium.util.PropertyLoader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;


/**
 * The Class SiatTestBase.
 */
public class SiatTestBase
{

	/** The grid hub url. */
	protected static String gridHubUrl;

	/** The base url. */
	protected static String baseUrl;

	/** The capabilities. */
	protected static Capabilities capabilities;

	/** The driver. */
	protected WebDriver driver;

	/**
	 * Inits the test suite.
	 * 
	 * @throws IOException
	 *            Signals that an I/O exception has occurred.
	 */
	@BeforeSuite
	public void initTestSuite() throws IOException
	{
		baseUrl = PropertyLoader.loadProperty("site.url");
		gridHubUrl = PropertyLoader.loadProperty("grid.url");
		if ("".equals(gridHubUrl))
		{
			gridHubUrl = null;
		}
		capabilities = PropertyLoader.loadCapabilities();
		WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
	}

	/**
	 * Inits the web driver.
	 */
	@BeforeMethod
	public void initWebDriver()
	{
		driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
	}

	/**
	 * Tear down.
	 */
	@AfterSuite(alwaysRun = true)
	public void tearDown()
	{
		WebDriverFactory.dismissAll();
	}
}
