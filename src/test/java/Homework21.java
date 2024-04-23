import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {
        String expectedPlaylistName = "BEATS.";
        String expectedSuccessMessage = "Updated playlist \"" + expectedPlaylistName + "\"";

        provideCredentialsAndSubmit("joseph.petersen@testpro.io", "QaOneTwo!!!");

        selectPlaylist();
        doubleClickPlaylist();
        enterNewPlaylistName();

        String actualSuccessMessage = getNewPlaylistNameSuccessMsg().trim();

        Assert.assertEquals(getNewPlaylistNameSuccessMsg(), expectedSuccessMessage,
                "Playlist renaming failed. Expected: " + expectedSuccessMessage + ". Actual: " + actualSuccessMessage);
    }



    public void selectPlaylist() {
        WebElement selectPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.moveToElement(selectPlaylist).click().perform();
    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName() {
        WebElement newPlaylistName =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        newPlaylistName.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        newPlaylistName.sendKeys("BEATS");
        newPlaylistName.sendKeys(Keys.ENTER);
    }

    public String getNewPlaylistNameSuccessMsg() {
        WebElement notification =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}