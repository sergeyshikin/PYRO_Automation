import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class ExploreReg {

        private WebDriver webDriver;
        private WebDriverWait wait;


        @FindBy(xpath = "//*[@id=\"explore-content\"]/div[1]/div[1]/a")
        WebElement showMoreHT;
        @FindBy (xpath = "/html/body/header/div[1]/nav/a[2]")
        WebElement exploreHeaderItem;
        @FindBy(xpath = "//*[@id=\"explore-content\"]/div[1]/div[2]/div[1]/div[2]/a")
        WebElement trackTitle;





        public ExploreReg(WebDriver driver) {
            webDriver = driver;
            wait = new WebDriverWait (webDriver, 60);

            PageFactory.initElements(webDriver, this);

        }

        public void regItemClick(){

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[1]/div[2]/div[1]/div[1]/a")));
            exploreHeaderItem.click();
            //  System.out.println("Item Explore in Header menu was  pressed");
        }


        public void showMoreHotTracks()
        {
            List<WebElement> trackElements = webDriver.findElements(By.xpath("//*[@id=\"explore-content\"]/div[1]/div[2]")
                    .findElement(ByXPath("@//div"));
            for (trackElements:System.out.println(trackElements);

        }





/*
            String releasedTrackBlockTitle = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[1]/div[1]/div")).getText();
            System.out.println("Tested block is  " + releasedTrackBlockTitle);
            Assert.assertEquals(releasedTrackBlockTitle, "Hot Tracks");
            showMoreHT.click();
            Assert.assertEquals(webDriver.getCurrentUrl(), "https://pyromusic.cn/tracks/global_recommended");
            System.out.println("Link Show More for Hot tracks on Explore works correct");
            System.out.println("Featured tracks page was opened");
 */


        public  void trackProfilePage()
        {
            String exploreTrackTitle = webDriver.findElement(By.xpath("//*[@id=\"explore-content\"]/div[1]/div[2]/div[1]/div[2]/a")).getText();
            trackTitle.click();
            String trackProfilePagetitle = webDriver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div/div[1]/div/div[1]/a")).getText();
            Assert.assertEquals(exploreTrackTitle, trackProfilePagetitle);
            System.out.println("Track profile page belong to selected track " + exploreTrackTitle);
        }
}
