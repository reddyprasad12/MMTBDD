package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CompleteYourBookingPage extends BaseClass {

    public ArrayList<String> al;
    public WebDriver driver;

    public CompleteYourBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By VIE_FARE_RULES = By.xpath("//span[text()='View Fare Rules']");
    public static final By ADULTS_FEE = By.xpath("(//p[contains(text(),'2 hours to 3 days')])[1]//following::p[text()='ADULT : '][1]//b");
    public static final By CHILDRENS_FEE = By.xpath("(//p[contains(text(),'2 hours to 3 days')])[1]//following::p[text()='CHILD : '][1]//b");
    public static final By TIME_FRAME_LABEL = By.xpath("(//div[@class='flightDetailsInfoLeft'])[4]/p[@class='appendBottom3']");
    public static final By ADULTS_TXT = By.xpath("(//div[@class='flightDetailsInfoRight'])[2]/p[1]");
    public static final By CHILDRENS_TXT = By.xpath("(//div[@class='flightDetailsInfoRight'])[2]/p[2]");
    public static final By FARE_RULES_CLOSE_BTN = By.xpath("(//div[@class='commonOverlay ']//span[contains(@class,overlayCrossIcon)])[1]");
    public static final By TOTAL_AMOUNT = By.xpath("//div[@class='fareFooter']/p/span[2]");

    public void navigateToCompleteYourBookingTab(WebDriver driver) {
        try {
            Set<String> windowHandles = driver.getWindowHandles();
            List<String> windowHandlesList = new ArrayList<>(windowHandles); //Set to List Conversion
            //5) Write to total window handle number to the console.
            System.out.println("Total window count: " + windowHandlesList.size() + "\n");

            //6) Switch to second window
            driver.switchTo().window(windowHandlesList.get(1));

            //7) Get the current window's handle and write to the console window. It must be second window handle.
            //System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String clickViewFareRulesAndGetDetails(WebDriver driver) {
        String totalAmount = null;
        String adultsFee = null;
        int sumOfAdultsFee=0;
        String childrensFee = null;
        try {
            //System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");
            Set<String> windowHandles = driver.getWindowHandles();
            List<String> windowHandlesList = new ArrayList<>(windowHandles); //Set to List Conversion
            // Switch to second window
            driver.switchTo().window(windowHandlesList.get(1));

            /*al = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window((String) al.get(1));*/

            waitForExpectedElement(driver, VIE_FARE_RULES);
            Thread.sleep(5000);
            driver.findElement(VIE_FARE_RULES).click();

            waitForExpectedElement(driver, ADULTS_FEE);
            adultsFee = driver.findElement(ADULTS_FEE).getText();
            //System.out.println("Adults Fee: " + adultsFee);
            System.out.println(
                    driver.findElement(TIME_FRAME_LABEL).getText()
                            + " fee for "
                            + driver.findElement(ADULTS_TXT).getText()
                           // + " fee is " + adultsFee
            );

            waitForExpectedElement(driver, CHILDRENS_FEE);
            childrensFee = driver.findElement(CHILDRENS_FEE).getText();
            //System.out.println("Childrens Fee: " + childrensFee);
            System.out.println(
                    driver.findElement(TIME_FRAME_LABEL).getText()
                            + " fee for "
                            + driver.findElement(CHILDRENS_TXT).getText()
                           // + " fee is " + childrensFee
            );
            waitForExpectedElement(driver, FARE_RULES_CLOSE_BTN);
            driver.findElement(FARE_RULES_CLOSE_BTN).click();
            totalAmount = driver.findElement(TOTAL_AMOUNT).getText();



        } catch (Exception e) {
            e.getMessage();
        }
        return totalAmount;
    }

    public String getAdultsFee(WebDriver driver) {
        String adultsFee = null;
        try {
            /*System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");
            Set<String> windowHandles = driver.getWindowHandles();
            List<String> windowHandlesList = new ArrayList<>(windowHandles); //Set to List Conversion
            // Switch to second window
            driver.switchTo().window(windowHandlesList.get(1));*/
            //driver.switchTo().window((String) al.get(1));
            //System.out.println("Current Window Handle: " + driver.getWindowHandle() + "\n");
            waitForExpectedElement(driver, ADULTS_FEE);
            adultsFee = driver.findElement(ADULTS_FEE).getText();

        } catch (Exception e) {
            e.getMessage();
        }
        return adultsFee;
    }

    public int getSumOfAdultsFee(String adultsFee) {
        int sumOfAdultsFee=0;
        try {
            //need to implement logic

        } catch (Exception e) {
            e.getMessage();
        }
        return sumOfAdultsFee;
    }

    public String getChildrensFee(WebDriver driver) {
        String childrensFee = null;
        try {
            waitForExpectedElement(driver, CHILDRENS_FEE);
            childrensFee = driver.findElement(CHILDRENS_FEE).getText();
        } catch (Exception e) {
            e.getMessage();
        }
        return childrensFee;
    }

    public int getSumOfChildrensFee(String childrensFee) {
        int subOfChildrensFee=0;
        try {
            //need to implement logic

        } catch (Exception e) {
            e.getMessage();
        }
        return subOfChildrensFee;
    }
}
