import PageObject.DevToMainPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObjectTests {

    WebDriver driverInPageObjectTests; // obiekt typu webdriver

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Users/konradkowal/Downloads/chromedriver");
        driverInPageObjectTests = new ChromeDriver();
        driverInPageObjectTests.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test(){
        DevToMainPage devToMainPage = new DevToMainPage(driverInPageObjectTests); //tworzymy nowy obiekt klasy DevToMainPage
        // przekazujemy przeglądarkę z PageObjectTests do DevToMainPage, do konstruktora
        // konstruktor tworzy nam nowy obiekt devToMainPage


    }
}
