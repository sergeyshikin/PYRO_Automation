import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplorePage {

    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy (xpath = "//*[@id=\"explore-content\"]/div[1]/div[1]/a")
    WebElement showMoreHT;
    @FindBy (xpath = "/html/body/header/div[1]/nav/a[2]")
    WebElement exploreHeaderItem;
    @FindBy(xpath = "//*[@id=\"explore-content\"]/div[1]/div[2]/div[1]/div[2]/a")
    WebElement trackTitle;
    @FindBy(xpath = "//*[@id=\"explore-content\"]/div[1]/div[2]/div[1]/div[2]/div[1]/a")
    WebElement trackDjName;
    @FindBy(xpath = "//*[@id=\"explore-content\"]/div[2]/div[1]/a")
    WebElement showMoreFT;
    @FindBy (xpath = "//*[@id=\"explore-content\"]/div[2]/div[2]/div[1]/a")
    WebElement mixtapeTitle;
    @FindBy (xpath = "//*[@id=\"explore-content\"]/div[2]/div[2]/div[1]/div[2]/a")
    WebElement mixtapeDJ;
    @FindBy (xpath = "//*[@id=\"explore-content\"]/div[3]/div[1]/a")
    WebElement showMorePL;
    @FindBy(xpath = "//*[@id=\"explore-content\"]/div[3]/div[2]/div[1]/a")
    WebElement playlistTitle;
    @FindBy (xpath = "//*[@id=\"explore-content\"]/div[3]/div[2]/div[1]/div[2]/a")
    WebElement playlistDJ;
    @FindBy (xpath = "//*[@id=\"explore-content\"]/div[4]/div/div[1]/div[1]/a")
    WebElement showMoreHL;
    @FindBy (xpath = "//*[@id=\"explore-content\"]/div[4]/div/div[1]/div[2]/div/a")
    WebElement labelTitle;
    @FindBy (xpath = "//*[@id=\"explore-content\"]/div[4]/div/div[1]/div[2]/a/div")
    WebElement labelIcon;
    @FindBy(xpath = "//*[@id=\"explore-content\"]/div[4]/div/div[2]/div[1]/a")
    WebElement showMoressDjs;



    public ExplorePage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait (webDriver, 60);

        PageFactory.initElements(webDriver, this);

    }

    public void itemClick(){

       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[1]/div[2]/div[1]/div[1]/a")));
       exploreHeaderItem.click();
     //  System.out.println("Item Explore in Header menu was  pressed");
    }


    public void showMoreHotTracks()
    {
        String releasedTrackBlockTitle = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[1]/div[1]/div")).getText();
        System.out.println("Tested block is  " + releasedTrackBlockTitle);
        Assert.assertEquals(releasedTrackBlockTitle, "Hot Tracks");
        showMoreHT.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/tracks/global_recommended");
        System.out.println("Link Show More for Hot tracks on Explore works correct");
        System.out.println("Featured tracks page was opened");
    }

   public  void trackProfilePage()
   {
       String exploreTrackTitle = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[1]/div[2]/div[1]/div[2]/a")).getText();
       trackTitle.click();
       String trackProfilePagetitle = webDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div/div[1]/div/div[1]/a")).getText();
       Assert.assertEquals(exploreTrackTitle, trackProfilePagetitle);
       System.out.println("Track profile page belong to selected track " + exploreTrackTitle);
   }

    public void trackDJProfilepage()

    {
        exploreHeaderItem.click();
        String exploreTrackDJName = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[1]/div[2]/div[1]/div[2]/div[1]/a")).getText();
        trackDjName.click();
        String trackProfilePagetitle = webDriver.findElement(By.xpath("//*[@id=\"profile_cover\"]/div/div[2]/div[1]/span[1]")).getText();
        Assert.assertEquals(exploreTrackDJName, trackProfilePagetitle);
        System.out.println("DJ profile page belong to selected track DJ " + exploreTrackDJName);
       }

    public  void showMoreMixtapes()

    {
        String releasedMixtapeBlockTitle = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[2]/div[1]/div")).getText();
        System.out.println("Tested block is  " + releasedMixtapeBlockTitle);
        Assert.assertEquals(releasedMixtapeBlockTitle, "Featured Mixtapes");
        showMoreFT.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/mixtapes/global_recommended");
        System.out.println("Link Show More for FEATURED MIXTAPES on Explore page works correct");
        System.out.println("Featured Mixtapes page was opened");
    }



    public void mixtapeProfilePage()
    {
        exploreHeaderItem.click();
        String exploreMixtapeTitle = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[2]/div[2]/div[1]/a")).getText();
        mixtapeTitle.click();
        String mixtapeProfilePagetitle = webDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div/div[1]/div/div[1]/a")).getText();
        Assert.assertEquals(exploreMixtapeTitle, mixtapeProfilePagetitle);
        System.out.println("Mixtape profile page belong to selected track " + exploreMixtapeTitle);
    }

    public  void mixtapeDJProfile()
    {
        exploreHeaderItem.click();
        String exploreMixtapeDJName = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[2]/div[2]/div[1]/div[2]/a")).getText();
        mixtapeDJ.click();
        String djProfilePagetitle = webDriver.findElement(By.xpath("//*[@id=\"profile_cover\"]/div/div[2]/div[1]/span[1]")).getText();
        Assert.assertEquals(exploreMixtapeDJName, djProfilePagetitle);
        System.out.println("DJ profile page belong to selected track DJ " + exploreMixtapeDJName);
    }


 public  void showMorePlaylists()

    {
        String releasedPlaylistBlockTitle = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[3]/div[1]/div")).getText();
        System.out.println("Tested block is  " + releasedPlaylistBlockTitle);
        Assert.assertEquals(releasedPlaylistBlockTitle, "Featured Playlists");
        showMorePL.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/playlists/global_recommended");
        System.out.println("Link Show More for FEATURED PLAYLISTS on Explore page works correct");
        System.out.println("Featured Playlists page was opened");
    }

 public void playlistProfilePage()
    {
        exploreHeaderItem.click();
        String explorePlaylistTitle = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[3]/div[2]/div[1]/a")).getText();
        playlistTitle.click();
        String playlistProfilePageTitle = webDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div/div[2]/div[1]")).getText();
        Assert.assertEquals(explorePlaylistTitle, playlistProfilePageTitle);
        System.out.println("Playlist profile page belong to selected track " + explorePlaylistTitle);
    }

 public  void playlistDJProfile()
    {
        exploreHeaderItem.click();
        String explorePlaylistDJName = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[3]/div[2]/div[1]/div[2]/a")).getText();
        playlistDJ.click();
        String djProfilePagetitle = webDriver.findElement(By.xpath("//*[@id=\"profile_cover\"]/div/div[2]/div[1]/span[1]")).getText();
        Assert.assertEquals(explorePlaylistDJName, djProfilePagetitle);
        System.out.println("DJ profile page belong to selected track DJ " + explorePlaylistDJName);
    }

 public  void showMoreHotLabels()

    {
        String hotLabels = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[4]/div/div[1]/div[1]/div")).getText();
        System.out.println("Tested block is  " + hotLabels);
        Assert.assertEquals(hotLabels, "Hot Labels");
        showMoreHL.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/record_labels/global_recommended");
        System.out.println("Link Show More for HOT LABELS on Explore page works correct");
        System.out.println("Featured Labels page was opened");
    }

 public void labelsProfilePage()
    {
        exploreHeaderItem.click();
        String exploreLabelTitle = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[4]/div/div[1]/div[2]/div/a")).getText();
        labelTitle.click();
        String labelProfilePageTitle = webDriver.findElement(By.xpath("//*[@id=\"profiles-show\"]/div[2]/div/div[1]/div/div/div[2]/div[1]")).getText();
        Assert.assertEquals(exploreLabelTitle, labelProfilePageTitle);
        System.out.println("Label profile page belong to selected track " + exploreLabelTitle);
    }

 public void labelsProfilePageIcon()
    {
        exploreHeaderItem.click();
        String exploreLabelTitle = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[4]/div/div[1]/div[2]/div/a")).getText();
        labelIcon.click();
        String labelProfilePageTitle = webDriver.findElement(By.xpath("//*[@id=\"profiles-show\"]/div[2]/div/div[1]/div/div/div[2]/div[1]")).getText();
        Assert.assertEquals(exploreLabelTitle, labelProfilePageTitle);
        System.out.println("Label profile page belong to selected track " + exploreLabelTitle);
    }




      public  void showMoreSSDjs()
    {
        String ssDjs = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[4]/div/div[2]/div[1]/div")).getText();
        System.out.println("Tested block is  " + ssDjs);
        Assert.assertEquals(ssDjs, "Superstar DJs");
        showMoressDjs.click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/djs/superstar");
        System.out.println("Link Show More for SUPERSTAR Djs on Explore page works correct");
        System.out.println("SuperstarDJs page was opened");
    }

     }








