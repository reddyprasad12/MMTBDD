package stepdefmakemytripcomplete;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.*;
import utilities.BaseClass;
import utilities.ConfigClass;
import utilities.UtilitiesClass;

public class MakeMyTripCompleteScript extends BaseClass {

    // Variable declaration
    public static String adultsFee = null, childrensFee = null, totalAmount = null;


    // Object creation for page classes
    SourceAndDestinationPage objSADP = new SourceAndDestinationPage(driver);
    DepartureAndReturnPage objDARP = new DepartureAndReturnPage(driver);
    TravellersAndClassPage objTACP = new TravellersAndClassPage(driver);
    FlightPage objFP = new FlightPage(driver);
    MoreFaresPage objMFP = new MoreFaresPage(driver);
    CompleteYourBookingPage objCYBP = new CompleteYourBookingPage(driver);

    // Object creation for utilities classes
    ConfigClass config=new ConfigClass();
    UtilitiesClass objUtil = new UtilitiesClass();

    @Before
    public void start( ) throws Exception{
        config.loadPropertyFile();
    }

    @Given("Given user is already on home page")
    public void given_user_is_already_on_home_page() {
        launchBrowser(config.getProperty("url"));
        captureScreenshot(driver, "BrowserLaunched");
    }
    @When("user select source and destination")
    public void user_select_source_and_destination() {
        objSADP.sendSourcePlace(config.getProperty("from"), driver);
        objSADP.sendDestinationPlace(config.getProperty("to"), driver);
        String source = objSADP.getTextFromSource(driver);
        //System.out.println("Return Source Value : " + source);
        // Assert.assertEquals(config.getProperty("from"), source);
        String destination = objSADP.getTextFromDestination(driver);
        //Assert.assertEquals(config.getProperty("to"), destination);
    }
    @When("user select departure and return date")
    public void user_select_departure_and_return_date() {
        objDARP.selectDepartureDate(driver);
        objDARP.selectReturnDate(driver);
        String departureDate = objDARP.getDepartureDate(driver);
       // System.out.println("Selected Departure Date: " + departureDate);
        String returnDate = objDARP.getReturnDate(driver);
        //System.out.println("Selected Return Date: " + returnDate);
    }
    @When("user select passengers like adults and childrens combination")
    public void user_select_passengers_like_adults_and_childrens_combination() {
        objTACP.navigateToTravellersAndClassScreen(driver);
        objTACP.selectAdults(driver);
        objTACP.selectChildrens(driver);
        objTACP.clickOnApplyButton(driver);
        String numberOfPassengers = objTACP.getNumberOfPassengers(driver);
        System.out.println("Total Passengers: " + numberOfPassengers);
    }
    @When("user select low priced airlines and click book now button")
    public void user_select_low_priced_airlines_and_click_book_now_button() {
        objFP.clickOnSearchButton(driver);
        objFP.clickOnExpandFareList(driver);
        objFP.selectLowPriceArilines(driver);
        objFP.clickOnBookNowButton(driver);
    }

    @When("user change Premium Flex from Economic class and click continue")
    public void user_change_premium_flex_from_economic_class_and_click_continue() {
        objMFP.selectPremiumFlex(driver);
        objMFP.clickContinueBTN(driver);
    }

    @When("user click Fare Rules and take Airline Fee and MMT Fee for two hours to three days and sum it for Adults and Children and print Console")
    public void user_click_fare_rules_and_take_airline_fee_and_mmt_fee_for_two_hours_to_three_days_and_sum_it_for_adults_and_children_and_print_console() {
        totalAmount = objCYBP.clickViewFareRulesAndGetDetails(driver);
    }

    @Then("user take Total Amount and Validate and print Console")
    public void user_take_total_amount_and_validate_and_print_console() {
        System.out.println("Total Amount is : " + totalAmount);
        Assert.assertEquals("₹ 39,982", totalAmount);
        System.out.println("Total Amount " + totalAmount + " is verified successfully");
    }

    @After
    public void browser() throws Throwable {
        driver.quit();
    }
}
