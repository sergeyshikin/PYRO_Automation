import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Explore_Test {


    WebDriver webDriver;
    WebDriverWait wait;
    ExplorePage explorePage;
    LogInForm logInForm;
    boolean loggedIn = false;

    public Explore_Test() {
//        System.setProperty("webdriver.chrome.driver", "/UDownloads/Automation/chromedriver");

        webDriver = new ChromeDriver();

        webDriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }


    @Before
    public void Autorization() {
        webDriver.get("https://pyromusic.cn");
        logInForm = new LogInForm(webDriver);
        logInForm.logInFlow();
        System.out.println("Login successfull");
    }

    @After
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }

    @Test
    public void AllHotTracks() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        System.out.println("Explore page was opened");
        explorePage.showMoreHotTracks();
    }

    @Test
    public void TrackProfile() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePage.trackProfilePage();
        explorePage.itemClick();
        explorePage.trackDJProfilepage();
    }

    @Test
    public void AllMixtapes() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePage.showMoreMixtapes();
    }

    @Test
    public void MixtapeProfile() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePage.mixtapeProfilePage();
        explorePage.itemClick();
        explorePage.mixtapeDJProfile();
    }

    @Test
    public void AllPlaylists() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePage.showMorePlaylists();
    }

    @Test
    public void PlaylistProfile() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePage.playlistProfilePage();
        webDriver.findElement(By.xpath("/html/body/header/div[1]/nav/a[2]")).click();
        //explorePage.itemClick();
        explorePage.playlistDJProfile();
    }

    @Test
    public void AllLabels() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePage.showMoreHotLabels();
    }

    @Test
    public void LabelProfile() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePage.labelsProfilePage();
        //  webDriver.findElement(By.xpath("/html/body/header/div[1]/nav/a[2]")).click();
        explorePage.itemClick();
        explorePage.labelsProfilePageIcon();
    }


    @Test
    public void superStarDjs()
    {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePage.showMoreSSDjs();
    }



}




