package fr.uha.ensisa.gl.minimale.mantest_app.it;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitConnexion{
	public static WebDriver driver;
	private static String host, port;

	public static void setupWebDriver() {
		if (driver != null) return;
		
		host = System.getProperty("host", "localhost");
		port = System.getProperty("servlet.port", "8080");
		
		// Looking for marionette in PATH
		String ext = System.getProperty("os.name", "").toLowerCase().startsWith("win") ? ".exe" : "";
		String geckodrivername = "geckodriver" + ext;
		Collection<String> pathes = new ArrayList<>();
		
		for (String source : new String[] {
				System.getProperty("PATH") /* posix */,
				System.getenv().get("Path") /* win < 10 */,
				System.getenv().get("PATH") /* win >= 10 */ }) {
			if (source != null) {
				pathes.addAll(Arrays.asList(source.trim().split(File.pathSeparator)));
				pathes.add("/usr/local/bin");
			}
		}
		
		File geckoDriver = null;
		for (String path : pathes) {
			File f = new File(path, geckodrivername);
			if (f.exists() && f.canExecute()) {
				//System.setProperty("webdriver.gecko.driver", f.getAbsolutePath());
				WebDriverManager.firefoxdriver().setup();
				geckoDriver = f;
				break;
			}
		}
		
		
		if (geckoDriver == null) {
			// CI/CD
			if(System.getProperty("selenium.remote.browser").equals("firefox")) {
				driver = new RemoteWebDriver(new FirefoxOptions());
				return;
			} else {
				throw new IllegalStateException("Cannot find geckodriver on " + pathes.toString());
			}
		}
		
		driver = new FirefoxDriver();
	}

	
	public static void shutdownWebDriver() {
		if (driver != null) {
			driver.quit();
			try { 
				driver.close();
			} catch (Exception x) {
				x.printStackTrace();
			}
			driver = null;
		}
	}

	public static String getBaseUrl() {
		return "http://" + host + ":" + port + '/';
	}
}
