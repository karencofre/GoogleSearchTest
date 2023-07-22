package com.tutotrial.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tutorial.modelo.GoogleHomePage;

public class GoogleSearchTest {
    private WebDriver driver;
    private GoogleHomePage googleHomePage;

    @Before
    public void setUp() {
        // Cambia la siguiente ruta al directorio donde tengas el controlador ChromeDriver
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
        driver = new ChromeDriver();
        googleHomePage = new GoogleHomePage(driver);
        googleHomePage.open();
    }

    @Test
    public void testGoogleSearch() {
        String searchText = "Selenium Java";
        googleHomePage.enterSearchText(searchText);
        googleHomePage.performSearch();

        // Agregamos una pausa para que podamos ver el resultado de la búsqueda
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

