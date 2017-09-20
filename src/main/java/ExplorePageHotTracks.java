import org.junit.Assert;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ExplorePageHotTracks
{
    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy (xpath = "//div[@class='cover-tracks__head']/a")
    WebElement showMoreHT;
    @FindBy (xpath = "//div[@class='cover-tracks__head']/div")
    WebElement hotTrackBlockTitle;
    @FindBy(xpath = "//div[@class = 'cover-tracks__item']")
    List<WebElement> trackRecord;
    @FindBy (xpath = "//div[@class = 'queueable cover-tracks__list']")
    WebElement trackItemRecord;
    @FindBy (xpath = "//div[@class = 'track-big__info']/a")
    WebElement trackProfilePageTitle;
    @FindBy (xpath = "//div[@class = 'profile-item__name']/span")
    WebElement trackDJProfileName;


    public ExplorePageHotTracks(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait (webDriver, 60);

        PageFactory.initElements(webDriver, this);
    }

    public void showMoreHotTracks()
    {
        String releasedTrackBlockTitle = hotTrackBlockTitle.getText();
        System.out.println("Tested block is  " + releasedTrackBlockTitle);
        Assert.assertEquals(releasedTrackBlockTitle, "Hot Tracks");
        showMoreHT.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/tracks/global_recommended");
        System.out.println("Link Show More for Hot tracks on Explore works correct");
        System.out.println("Featured tracks page was opened");
    }

    public void alltracksProfiles()
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

    }


    public void trackDJProfilepage()
    {
        System.out.println("Количество элементов в списке");
        System.out.println(trackRecord.size());

        for (int nomer = 1; nomer <=trackRecord.size(); nomer++)
        {
            String exploreTrackDj = trackItemRecord.findElement(By.xpath("./div[" + nomer + "]/div[2]/div[1]/a")).getText();
            trackItemRecord.findElement(By.xpath("./div[" + nomer + "]/div[2]/div[1]/a[1]")).click();
             String url = webDriver.getCurrentUrl();
                if (url.contains("keyword"))
                {
                 System.out.println("DJ"+exploreTrackDj+" is not in base");
                }
                else
                    {
                    String trackProfilePagetitle = trackDJProfileName.getText();
                    Assert.assertEquals(exploreTrackDj, trackProfilePagetitle);
                    System.out.println("Track DJ profile page belong to selected track DJ" + exploreTrackDj);
                    }
            webDriver.navigate().back();
        }
    }
}
