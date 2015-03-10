package org.siat.selenium.util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * Class that extracts properties from the prop file.
 */
public class PropertyLoader
{

	/** The Constant DEBUG_PROPERTIES. */
	private static final String DEBUG_PROPERTIES = "/debug.properties";

	/**
	 * Load capabilities.
	 * 
	 * @return the capabilities
	 * @throws IOException
	 *            Signals that an I/O exception has occurred.
	 */
	public static Capabilities loadCapabilities() throws IOException
	{
		return loadCapabilities(System.getProperty("application.properties", DEBUG_PROPERTIES));
	}

	/**
	 * Load capabilities.
	 * 
	 * @param fromResource
	 *           the from resource
	 * @return the capabilities
	 * @throws IOException
	 *            Signals that an I/O exception has occurred.
	 */
	public static Capabilities loadCapabilities(final String fromResource) throws IOException
	{
		final Properties props = new Properties();
		props.load(PropertyLoader.class.getResourceAsStream(fromResource));
		final String capabilitiesFile = props.getProperty("capabilities");

		final Properties capsProps = new Properties();
		capsProps.load(PropertyLoader.class.getResourceAsStream(capabilitiesFile));

		final DesiredCapabilities capabilities = new DesiredCapabilities();
		for (final String name : capsProps.stringPropertyNames())
		{
			final String value = capsProps.getProperty(name);
			if (value.toLowerCase().equals("true") || value.toLowerCase().equals("false"))
			{
				capabilities.setCapability(name, Boolean.valueOf(value));
			}
			else if (value.startsWith("file:"))
			{
				capabilities.setCapability(name, new File(".", value.substring(5)).getCanonicalFile().getAbsolutePath());
			}
			else
			{
				capabilities.setCapability(name, value);
			}
		}

		return capabilities;
	}

	/**
	 * Load property.
	 * 
	 * @param name
	 *           the name
	 * @return the string
	 * @throws IOException
	 *            Signals that an I/O exception has occurred.
	 */
	public static String loadProperty(final String name) throws IOException
	{
		return loadProperty(name, System.getProperty("application.properties", DEBUG_PROPERTIES));
	}

	/**
	 * Load property.
	 * 
	 * @param name
	 *           the name
	 * @param fromResource
	 *           the from resource
	 * @return the string
	 * @throws IOException
	 *            Signals that an I/O exception has occurred.
	 */
	public static String loadProperty(final String name, final String fromResource) throws IOException
	{
		final Properties props = new Properties();
		props.load(PropertyLoader.class.getResourceAsStream(fromResource));

		return props.getProperty(name);
	}

}
