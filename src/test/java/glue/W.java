package glue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class W {
    private static W instance;
    public WebDriver driver;

    private W() {

        driver = new ChromeDriver();
    }

    public static W get() {
        if (instance == null) {
            instance = new W();
        }
        return instance;
    }


    public void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}