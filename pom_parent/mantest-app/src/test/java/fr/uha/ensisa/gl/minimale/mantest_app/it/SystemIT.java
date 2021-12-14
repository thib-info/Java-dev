package fr.uha.ensisa.gl.minimale.mantest_app.it;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SystemIT{
	
	@BeforeAll
	public static void setUp() {
		InitConnexion.setupWebDriver();
	}
	
	@AfterAll
	public static void closeConnection() {
		InitConnexion.shutdownWebDriver();
	}

	@Test
	void urlTest() {
		String baseUrl = InitConnexion.getBaseUrl();
		InitConnexion.driver.get(baseUrl + "system");
		assertTrue(InitConnexion.driver.getPageSource().contains("container"), "Success Tests");
	}

}
