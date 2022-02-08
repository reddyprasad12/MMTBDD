package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

public class MoreFaresPage extends BaseClass {

    public WebDriver driver;

    public MoreFaresPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By PREMIUM_FLEX = By.xpath("//p[text()='Premium Flex']");
    public static final By CONTINUE_BTN = By.xpath("//button[text()='Continue']");

    public void selectPremiumFlex(WebDriver driver) {
        try {
            waitForExpectedElement(driver, PREMIUM_FLEX);
            driver.findElement(PREMIUM_FLEX).click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void clickContinueBTN(WebDriver driver) {
        try {
            waitForExpectedElement(driver, CONTINUE_BTN);
            driver.findElement(CONTINUE_BTN).click();
            Thread.sleep(10000);
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
