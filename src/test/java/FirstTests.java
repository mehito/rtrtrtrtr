import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTests {

    WebDriver driver; // inicjalizacja pustej przeglądarki

    public void highlightElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 3px solid blue;');", element);
    }
    @Before // metoda Before, a właściwie setUp wykona się przed każdym testem
    public void setUp(){
        // 1. wskazanie chormedrivera
        System.setProperty("webdriver.chrome.driver", "/Users/konradkowal/Downloads/chromedriver");
        driver = new ChromeDriver(); // przypisanie do pustej przeglądarki Chrome do wykonywania testów
        driver.get("https://dev.to/");
    }
    @Test
    public void firstTest(){
        WebElement podcastBtn = driver.findElement(By.xpath("//a[@href='/pod']"));
        highlightElement(driver,podcastBtn);

    }
    @Test
    public void secondTest(){

    }

}
