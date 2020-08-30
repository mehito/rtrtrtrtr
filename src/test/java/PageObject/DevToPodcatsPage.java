package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DevToPodcatsPage {
    WebDriver driverInDevToPodcastPage;

    @FindBy(tagName = "h3")
    List<WebElement> podcastList;

    public DevToPodcatsPage(WebDriver driverFromDevToMainPage) {
        this.driverInDevToPodcastPage = driverFromDevToMainPage;
        PageFactory.initElements(driverInDevToPodcastPage, this);
    }

    public DevToSinglePodcastPage selectPodcastFromList(Integer podcastNumber){
        WebDriverWait wait = new WebDriverWait(driverInDevToPodcastPage, 10);
        wait.until(ExpectedConditions.urlToBe("https://dev.to/pod"));
        WebElement selectedPodcast = podcastList.get(podcastNumber);
        selectedPodcast.click();
        return new DevToSinglePodcastPage(driverInDevToPodcastPage, wait);
    }
}
