package glue;



import glue.W;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.time.Duration;

public class GoogleSteps {

    @Given("url {string} is launched")
    public void url(String url) {
        W.get().driver.get(url);
        acceptCookiesIfWarned();
    }

    @When("About page is shown")
    public void aboutPageIsShown() {
        WebElement aboutLink = W.get().driver.findElement(By.linkText("About"));
        aboutLink.click();
    }

    @Then("page displays {string}")
    public void pageDisplays(String expectedText) {
        WebElement body = new WebDriverWait(W.get().driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        assertTrue(body.getText().contains(expectedText));
    }

    @When("searching for {string}")
    public void searchingFor(String query) {
        WebElement searchBox = W.get().driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    @Then("results contain {string}")
    public void resultsContain(String expectedText) {
        new WebDriverWait(W.get().driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
        WebElement searchResults = W.get().driver.findElement(By.id("search"));
        assertTrue(searchResults.getText().contains(expectedText));
    }

    @Then("result stats are displayed")
    public void resultStatsAreDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        WebElement resultStats = new WebDriverWait(W.get().driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='result-stats']")));
        assertTrue(resultStats.isEnabled());
    }

    @Then("number of {string} is more than {int}")
    public void numberOfResultsIsMoreThan(String type, int number) {
        WebElement resultStats = W.get().driver.findElement(By.xpath("//div[@id='result-stats']"));
        String statsText = resultStats.getText();
        String[] parts = statsText.split(" ");
        long count = 0;
        double time = 0;

        for (String part : parts) {
            part = part.replace(",", "");
            try {
                if (type.equals("results")) {
                    count = Long.parseLong(part);
                    assertTrue(count > number);
                } else if (type.equals("seconds")) {
                    time = Double.parseDouble(part.replace("(", "").replace(")", "").replace("s", ""));
                    assertTrue(time > number);
                }
            } catch (NumberFormatException ignored) {
            }
        }
    }

    private static void acceptCookiesIfWarned() {
        try {
            WebElement acceptButton = new WebDriverWait(W.get().driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#L2AGLb")));
            acceptButton.click();
        } catch (NoSuchElementException | org.openqa.selenium.TimeoutException ignored) {
        }
    }
}
