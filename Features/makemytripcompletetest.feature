Feature: verifying functionalities in makemytrip portal

  Scenario: verifying functionalities in makemytrip portal
    Given Given user is already on home page
    When user select source and destination
    When user select departure and return date
    When user select passengers like adults and childrens combination
    When user select low priced airlines and click book now button
    When user change Premium Flex from Economic class and click continue
    When user click Fare Rules and take Airline Fee and MMT Fee for two hours to three days and sum it for Adults and Children and print Console
    Then user take Total Amount and Validate and print Console






