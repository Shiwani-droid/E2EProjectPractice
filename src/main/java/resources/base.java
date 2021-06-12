package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();

		// to avoid the below path hardocding
//		FileInputStream fis = new FileInputStream(
//				"D:\\Eclipse_latest\\eclipse\\workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		// we can use this as well

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		// mvn test -Dbrowser=chrome
		// this is for mvn when you need to give command from mvn to test in particular
		// browser
		// mvn is using System instead of prop
//		String browserName=System.getProperty("browser");

		String browserName = prop.getProperty("browser");
		//String urlName = prop.getProperty("url");

		System.out.println(browserName);
		//System.out.println(urlName);

		if (browserName.contains("chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					"C:\\\\Program Files (x86)\\\\Chrome Driver\\\\chromedriver.exe");
			
			// to make chromedriver path generic
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();

			if (browserName.contains("headless")) {
				// for Headless browser
				option.addArguments("headless");
			}
			driver = new ChromeDriver(option);

		} else if (browserName.equals("firefox")) {

			// firefox code

		} else if (browserName.equals("IE")) {

			// IE code
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

	public String takeScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(Source, new File(destinationFile));
		return destinationFile;
	}

}
