Feature: Explore Category Validation

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
    And the users select Auto&Repair category
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
    
    @explore
    Scenario: to verify the featured in city
    Given  the users tap on location field
    When  the user tap on city
    Then the user should be validate the city
    