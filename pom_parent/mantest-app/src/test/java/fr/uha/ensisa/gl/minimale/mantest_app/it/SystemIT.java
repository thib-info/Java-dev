package fr.uha.ensisa.gl.minimale.mantest_app.it;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SystemIT{
	
	@BeforeAll
	public static void setUp() {
		InitConnexion.setupWebDriver();
		String baseUrl = InitConnexion.getBaseUrl();
		InitConnexion.driver.get(baseUrl + "system");
	}
	
	@AfterAll
	public static void closeConnection() throws InterruptedException {
		Thread.sleep(2000);
		InitConnexion.shutdownWebDriver();
	}

	@Test
	void testPresentation() {
		assertTrue(InitConnexion.driver.getPageSource().contains("tab-tests"), "Some tests are implemented");
	}
	
	@Test
	void systemCaracteristics() {
		assertTrue(InitConnexion.driver.getPageSource().contains("system-description"));
		assertTrue(InitConnexion.driver.getPageSource().contains("caracteristic-sys"));
		assertTrue(InitConnexion.driver.getPageSource().contains("id-systeme"));
		assertTrue(InitConnexion.driver.getPageSource().contains("system-image-container"));
	}
	
	@Test
	void creationNewTest() {
		assertTrue(InitConnexion.driver.getPageSource().contains("addNewTest"));
	}
	

}
