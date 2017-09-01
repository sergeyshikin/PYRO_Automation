import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Explore_regression {

    WebDriver webDriver;
    WebDriverWait wait;
    ExploreReg exploreReg;
    ExplorePage explorePage;
    LogInForm logInForm;
    boolean loggedIn = false;

    public Explore_regression() {
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
    public void TrackProfile() {
        exploreReg = new ExploreReg(webDriver);
        exploreReg.regItemClick();
        exploreReg.showMoreHotTracks();
    }



}
