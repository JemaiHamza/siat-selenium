package org.siat.selenium;

import org.openqa.selenium.support.PageFactory;
import org.siat.selenium.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * The Class SampleTestNgTest.
 */
public class SampleTestNgTest extends SiatTestBase
{

	/** The homepage. */
	private HomePage homepage;

	/**
	 * Inits the page objects.
	 */
	@BeforeMethod
	public void initPageObjects()
	{
		homepage = PageFactory.initElements(driver, HomePage.class);
	}

	/**
	 * Test home page has a header.
	 */
	@Test
	public void testHomePageHasAHeader()
	{
		driver.get(baseUrl);
		System.out.println("SampleTestNgTest.testHomePageHasAHeader() **** " + driver.getTitle());
		//				Assert.assertFalse("".equals(homepage.header.getText()));
	}

	/**
	 * Test search case.
	 * 
	 * @throws Exception
	 *            the exception
	 */

	//	@Test(invocationCount = 10, threadPoolSize = 5)
	//	public void loadTestPerformance() throws IOException
	//	{
	//
	//		System.out.printf("%n[START] Thread Id : %s is started!", Thread.currentThread().getId());
	//
	//		driver.get(baseUrl);
	//
	//		//perform whatever actions, like login, submit form or navigation
	//
	//		System.out.printf("%n[END] Thread Id : %s", Thread.currentThread().getId());
	//
	//		driver.quit();
	//
	//	}
}
