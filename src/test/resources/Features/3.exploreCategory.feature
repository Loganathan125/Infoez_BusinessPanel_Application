@explore
 Feature: Explore Category Validation

  Scenario: verify restaurants category
    Given the users select restaurant category
    When the explore business page should be displayed
    And the user tap filter&sort
    And the user select filter sction 
    And the user tap on show result
    Then place found count should be validate

  Scenario: verify cafes&Backery category
    Given the users select cafe&Backery category
    When explore business page should be displayed
    Then place found count should  validate

  Scenario: verify Beauty&Spa category
    Given the users select Beauty&Spa category
    When the explore business page should  displayed
    Then Beauty&Spa placeFound count should be velidate

  Scenario: verify Fitness&WellNess category
    Given the users select FitNess&WellNess category
    When the explore business page should be visiable
    Then placefound count should be validate

  Scenario: verify Auto&Repair category
    Given the users select Auto&Repair category
    When the Explore businesses page should be displayed
    Then Auto&Repair place found count should be Validate

  Scenario: verify Health&Medical category
    Given the users select Health&Medical category
    When the explore business pages should be Displayed
    Then Health&Medical place found count Should be validete

  Scenario: verify Reatil&Shopping category
    Given the users select retails&shopping category
    When The Retails explore busineses page should be displayed
    Then Retails&Shopping  place found Count should be validated

  Scenario: verify Education category
    Given the users select Education category
    When the Education explore busines Page should be displayed
    Then Education Place found countt should be validate
