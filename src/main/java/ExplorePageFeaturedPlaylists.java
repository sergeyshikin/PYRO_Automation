import com.sun.jna.platform.unix.X11;
import org.apache.xpath.operations.Bool;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ExplorePageFeaturedPlaylists
{


    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(xpath = "//*[@id='explore-content']/div[3]/div[1]/a")
    WebElement showMorePlaylist;
    @FindBy(xpath = "//div[@class='covers-list covers-list--margin']//div[@class='covers-list__title covers-list__title--large']")
    WebElement explorePlaylistTitle;
    @FindBy(xpath = "//div[@id ='explore-content']//div[contains(@class, 'paginatable-item')]")
    List<WebElement> listPlaylist;
    @FindBy(xpath = "//div[@id ='explore-content']//div[contains(@class, 'covers-list--margin')]/div[2]")
    WebElement explorePlaylistRecord;
    @FindBy(xpath = "//div[@class = 'labels-item__name']")
    WebElement playlistProfuilePageTitle;
    @FindBy(xpath = "//div[@class = 'profile-item__name']/span")
    WebElement playlistProfileDj;
    @FindBy (xpath = "//*[@id='profile_cover']")
    WebElement djPage;
    @FindBy(xpath = "//div[@class='labels-item__name']")
    WebElement labelProflePageName;


    public ExplorePageFeaturedPlaylists(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 60);

        PageFactory.initElements(webDriver, this);

    }

    public void showMorePlaylist() {
        String releasedTrackBlockTitle = explorePlaylistTitle.getText();
        System.out.println("Tested block is  " + releasedTrackBlockTitle);
        Assert.assertEquals(releasedTrackBlockTitle, "Featured Playlists");
        showMorePlaylist.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/playlists/global_recommended");
        System.out.println("Link Show More for Featured on Explore works correct");
        System.out.println("Featured Mixtapes page was opened");

    }

    public void allPlaylistsProfiles() {
        System.out.println("Количество элементов в списке");
        System.out.println(listPlaylist.size());

        for (int nomer = 1; nomer <= listPlaylist.size(); nomer++) {
            String explorePlaylistTitle = explorePlaylistRecord.findElement(By.xpath("./div[" + nomer + "]/a")).getText();
            explorePlaylistRecord.findElement(By.xpath("./div[" + nomer + "]/a")).click();
            String trackProfilePagetitle = playlistProfuilePageTitle.getText();
            Assert.assertEquals(explorePlaylistTitle, trackProfilePagetitle);
            System.out.println("Track profile page belong to selected track " + explorePlaylistTitle);
            webDriver.navigate().back();
        }

    }

    public void allPlaylistsAuthor()
    {
        System.out.println("Количество элементов в списке");
        System.out.println(listPlaylist.size());

        for (int nomer = 1; nomer <= listPlaylist.size(); nomer++)
        {
            String explorePlaylistDj = explorePlaylistRecord.findElement(By.xpath("./div[" + nomer + "]/div[2]/a")).getText();
            explorePlaylistRecord.findElement(By.xpath("./div[" + nomer + "]/div[2]/a")).click();
            String url = webDriver.getCurrentUrl();
            if (url.contains("keyword"))
            {
                System.out.println("DJ" + explorePlaylistDj + " is not in base");
            }
            else
                {
                if (webDriver.findElement(By.id("profile_cover")).isDisplayed())
                {
                    String trackProfilePagetitle = playlistProfileDj.getText();
                    Assert.assertEquals(explorePlaylistDj, trackProfilePagetitle);
                    System.out.println("Track DJ profile page belong to selected track DJ " + explorePlaylistDj);
                }
                    else
                        {
                            String trackProfilePagetitle = labelProflePageName.getText();
                            Assert.assertEquals(explorePlaylistDj, trackProfilePagetitle);
                            System.out.println("Track DJ profile page belong to selected track DJ " + explorePlaylistDj);
                        }
                }


          webDriver.navigate().back();
        }
    }
}



