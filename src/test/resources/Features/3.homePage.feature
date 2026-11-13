@home
Feature: Explore Category Validation

Scenario: to verify the location field in the home page

   Given the user tap on location field
    When the user choosyour city popup should be displayed
    And the user enter city "abc" in search cities
    Then the no matches message should be displayed
    And the user select city "Chennai" from  list
    Then the home page should be display location "Chennai"
    And the admin tap on lodation field
    And the amin tap on use my current location
    And the admin tap on this time option
    And the admin tap near me option
    Then the Nearby business should be displayed

  Scenario: to verify search with valid and  invalid values
    Given the admin enter a value "<searchfield>"
    When the admin tap search bar
    Then the admin verify no result found "<result>"

    Examples:
      | searchfield     | result  |
      | 12345678        | invalid |
      | kiaq Technology | valid   |

  Scenario: to verify the explore categories
    Given the users select restaurant category
    When the explore business page should be displayed
    And the user tap filter&sort
    And the user select filter sction
    And the user tap on show result
    Then place found count should be validate
    And the users select cafe&Backery category
    And explore business page should be displayed
    Then place found count should  validate
    And the users select Beauty&Spa category
    And the explore business page should  displayed
    Then Beauty&Spa placeFound count should be velidate
    And the users select FitNess&WellNess category
    And the explore business page should be visiable
    Then placefound count should be validate

  Scenario: to verify the explore categories
    When the users select Auto&Repair category
    And the Explore businesses page should be displayed
    Then Auto&Repair place found count should be Validate
    And the users select Health&Medical category
    And the explore business pages should be Displayed
    Then Health&Medical place found count Should be validete
    And the users select retails&shopping category
    And The Retails explore busineses page should be displayed
    Then Retails&Shopping  place found Count should be validated
    And the users select Education category
    And the Education explore busines Page should be displayed
    Then Education Place found countt should be validate

  Scenario: to verify the featured in city
    Given the users tap on location field
    When the user tap on city
    Then the user should be validate the city

  Scenario: to verify the control center
    When the admin tap on manage your business 
    Then the admin validate the manage your business  page
    And the admin tap see all
    Then the admin tap view all
