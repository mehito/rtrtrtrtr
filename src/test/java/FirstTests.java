import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //przed każdym kolejnym findElements poczekaj 10 sekund, zanim wywalisz error,
        // co sekundę sprawdzaj czy element jest dostepny
    }
    @Test
    public void goToPodcastAndSelectThirdAndPlayIt(){

        WebElement podcastBtn = driver.findElement(By.xpath("//a[@href='/pod']"));
        highlightElement(driver,podcastBtn);
        podcastBtn.click();
        String podcastUrl = driver.getCurrentUrl();
        //przejście na inną stronę z podcastami

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://dev.to/pod"));
        //sprawdzaj co sekundę czy url ma nazwę:   zanim wywalisz błąd

        List<WebElement> podcasts = driver.findElements(By.tagName("h3"));
//        for (WebElement podcast: podcasts){
//            highlightElement(driver, podcast);
        WebElement thirdPodcast = podcasts.get(2);
        thirdPodcast.click();
        WebElement recordBtn = driver.findElement(By.className("record-wrapper"));
        recordBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("status-message"))));

        String recordBtnClassAttribute = recordBtn.getAttribute("class");

        boolean isPlaying = recordBtnClassAttribute.contains("playing");

        assertTrue("podcast wasn't played", isPlaying);

        }

    @Test
    public void secondTest(){



    }
}
