import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ExplorePageUpcomingShows
{
    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(xpath = "//div[@class='covers-list covers-list--shows']/div[1]/a")
    WebElement showMoreShows;
    @FindBy (xpath = "//div[@class='covers-list covers-list--shows']//div[@class = 'covers-list__title']")
    WebElement showsBlockTitle;
    @FindBy(xpath = "//div[@class = 'cover-tracks__item']")
    List<WebElement> showsRecord;
    @FindBy (xpath = "//div[@class = 'queueable cover-tracks__list']")
    WebElement showItemRecord;
    @FindBy (xpath = "//div[@class = 'track-big__info']/a")
    WebElement showkProfilePageTitle;
    @FindBy (xpath = "//div[@class = 'profile-item__name']/span")
    WebElement trackDJProfileName;


    public ExplorePageUpcomingShows(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait (webDriver, 60);

        PageFactory.initElements(webDriver, this);
    }

    public void showMoreShows()
    {
        String releasedTrackBlockTitle = showsBlockTitle.getText();
        System.out.println("Tested block is  " + releasedTrackBlockTitle);
        Assert.assertEquals(releasedTrackBlockTitle, "Upcoming shows");
        showMoreShows.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/shows/global_recommended");
        System.out.println("Link Show More for Hot tracks on Explore works correct");
        System.out.println("Upcoming Shows page was opened");
    }


 /*   public void alltracksProfiles()
    {
        System.out.println("Количество элементов в списке");
        System.out.println(trackRecord.size());

        for (int nomer=1; nomer<=trackRecord.size(); nomer++)
        {
            String exploreTrackTitle = trackItemRecord.findElement(By.xpath("./div["+nomer+"]/div[2]/a[1]")).getText();
            trackItemRecord.findElement(By.xpath("./div["+nomer+"]/div[2]/a[1]")).click();
            String trackProfilePagetitle = trackProfilePageTitle.getText();
            Assert.assertEquals(exploreTrackTitle, trackProfilePagetitle);
            System.out.println("Track profile page belong to selected track " + exploreTrackTitle);
            webDriver.navigate().back();
        }

    } */

}
