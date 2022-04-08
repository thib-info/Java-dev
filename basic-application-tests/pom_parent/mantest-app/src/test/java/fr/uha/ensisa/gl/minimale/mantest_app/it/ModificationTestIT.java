package fr.uha.ensisa.gl.minimale.mantest_app.it;

import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ModificationTestIT {

	@BeforeAll
	public static void setUp() {
		InitConnexion.setupWebDriver();
	}
	
	@AfterAll
	public static void closeConnexion() throws InterruptedException {
		Thread.sleep(2000);
		InitConnexion.shutdownWebDriver();
	}
	
	@Test
	void basicFormularTest() {
		
		JSONObject obj = new JSONObject();
		obj.put("idSystem", 0);
		obj.put("idTest", 0);
		
		
		String baseUrl = InitConnexion.getBaseUrl();
//		InitConnexion.driver.request("POST", baseUrl+"/Test", obj);
	}
	
	
}
