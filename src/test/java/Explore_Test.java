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
    ExplorePageHotTracks explorePageHotTracks;
    ExplorePageFeaturedMixtapes explorePageFeaturedMixtapes;
    ExplorePageFeaturedPlaylists explorePageFeaturedPlaylists;
    ExplorePageHotLabels explorePageHotLabels;
    ExplorePageSSDJ explorePageSSDJ;
    ExplorePageTop10Tracks explorePageTop10Tracks;
    ExplorePageUpcomingShows explorePageUpcomingShows;


    public Explore_Test() {

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
        explorePageHotTracks = new ExplorePageHotTracks(webDriver);
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        System.out.println("Explore page was opened");
        explorePageHotTracks.showMoreHotTracks();
    }

    @Test
    public void AllTrackProfiles() {
        explorePageHotTracks = new ExplorePageHotTracks(webDriver);
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        System.out.println("Explore page was opened");
        explorePageHotTracks.alltracksProfiles();
    }

    @Test
    public void TrackDJProfile() {
        explorePageHotTracks = new ExplorePageHotTracks(webDriver);
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        System.out.println("Explore page was opened");
        explorePageHotTracks.trackDJProfilepage();
    }

    @Test
    public void AllMixtapes() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePageFeaturedMixtapes = new ExplorePageFeaturedMixtapes(webDriver);
        System.out.println("Explore page was opened");
        explorePageFeaturedMixtapes.showMoreMixtapes();

    }

    @Test
    public void AllMixtapeProfile() {
        explorePageFeaturedMixtapes = new ExplorePageFeaturedMixtapes(webDriver);
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        System.out.println("Explore page was opened");
        explorePageFeaturedMixtapes.allMixtapeProfiles();

    }

    @Test
    public void AllMixtapeDj() {
        explorePageFeaturedMixtapes = new ExplorePageFeaturedMixtapes(webDriver);
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePageFeaturedMixtapes.allMixtapeDj();
    }

    @Test
    public void ShowMorePlaylists() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePageFeaturedPlaylists = new ExplorePageFeaturedPlaylists(webDriver);
        System.out.println("Explore page was opened");
        explorePageFeaturedPlaylists.showMorePlaylist();
    }

    @Test
    public void AllPlaylistsProfile() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePageFeaturedPlaylists = new ExplorePageFeaturedPlaylists(webDriver);
        System.out.println("Explore page was opened");
        explorePageFeaturedPlaylists.allPlaylistsProfiles();
    }


    @Test
    public void AllPlaylistsAuthor() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePageFeaturedPlaylists = new ExplorePageFeaturedPlaylists(webDriver);
        System.out.println("Explore page was opened");
        explorePageFeaturedPlaylists.allPlaylistsAuthor();
    }

    @Test
    public void ShowMoreHL() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePageHotLabels = new ExplorePageHotLabels(webDriver);
        System.out.println("Explore page was opened");
        explorePageHotLabels.showMoreHotLabels();
    }

    @Test
    public void allLabelsProfiles() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePageHotLabels = new ExplorePageHotLabels(webDriver);
        System.out.println("Explore page was opened");
        explorePageHotLabels.allLabelsProfiles();
        explorePageHotLabels.allLabelsProfileIcons();
    }


    @Test
    public void ShowMoreSSdj() {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePageSSDJ = new ExplorePageSSDJ(webDriver);
        System.out.println("Explore page was openeed");
        explorePageSSDJ.showMoreSSDj();
    }

    @Test
    public  void SSDjProfileNames ()
    {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePageSSDJ = new ExplorePageSSDJ(webDriver);
        System.out.println("Explore page was openeed");
        explorePageSSDJ.ssDjProfilename();
        explorePageSSDJ.ssDjProfileIcons();
    }
    @Test
    public void Top10Tracks()
    {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePageTop10Tracks = new ExplorePageTop10Tracks(webDriver);
        explorePageTop10Tracks.top10TracksProfileName();
    }

    @Test
    public void Top10TracksDj()
    {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePageTop10Tracks = new ExplorePageTop10Tracks(webDriver);
        explorePageTop10Tracks.top10TracksDJ();
    }

    @Test
    public void ShowMoreUpcomingShows ()
    {
        explorePage = new ExplorePage(webDriver);
        explorePage.itemClick();
        explorePageUpcomingShows = new ExplorePageUpcomingShows(webDriver);
        explorePageUpcomingShows.showMoreShows();


    }

}
































































