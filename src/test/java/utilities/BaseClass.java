package utilities;
//Importing packages
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {

    // store current working directory path with "user.dir"
    public static String projectPath = System.getProperty("user.dir");
    public String ipaPath;
    public String testDataFilePath = projectPath + "/TestData/";
    public String reportFilePath;
    public Date date;
    static Date dte = new Date();
    static String dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dte);
    static String reportFileName = "Testing_" + dateFormat;
    public static String screenShotFilePath=projectPath+"/ScreenShots/";
    public String driverPath=projectPath+"/Drivers/";

    private String frameworkDir = System.getProperty("user.dir");
    private String webDriverPath = frameworkDir + File.separator + "resources" + File.separator + "chromedriver.exe";

    // create instance for webdriver
    public static WebDriver driver;

    // to launch chrome browser
    public void launchBrowser(String url) {

        System.setProperty("webdriver.chrome.driver", webDriverPath);
        //WebDriverManager.chromedriver().setup();

        // launch chrome browser
        driver = new ChromeDriver();

        // maximize window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // direct it to the Base URL
        driver.get(url);
    }



    // Explicit wait method for element
    public WebElement waitForExpectedElement(WebDriver driver, final By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Capture Screen Shot and save in the location
    public static String captureScreenshot(WebDriver driver, String screenshotname) {

        try {

            // Set the Current Date and Time
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

            Date dt = new Date();
            System.out.println(dateFormat.format(dt));

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File(projectPath + "/ScreenShots/"+ dateFormat.format(dt) + "_" + screenshotname + ".jpg"));

            System.out.println("screenshot has taken");
        } catch (Exception e) {
            System.out.println("exception while taking screenshot" + e.getMessage());
        }
        return screenshotname;
    }
}
