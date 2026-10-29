Feature: verify the home page fuctionality

  Scenario Outline: to verify the location search and nearby business functionality
    Given the user tap on location field
    When the user search city "<City>"
    And the user select city "chennai" from the list
    Then the home page should display location "<location>"
    And the admin tap on lodation field
    And the amin tap on use my current location
    And the admin tap on this time option
    Then use my current location should be displayed
    And the admin tap near me option
    And the admin tap on only this time option
    And the admin tap turn on option
    Then the Nearby business should be displayed

    Examples:
      | City     | location |
      | abc      | invalid1 |
      | 23426242 | invalid2 |
      | Chennai  | valid    |
      | ch       | valid    |

  Scenario: to verify the business actions like call,whatsapp,directions,enquiry ,share and favourite
    Given the admin click on search bar
    When the admin tap on any Business name
    And the admin tap call function
    Then the admin should be validate the call functionality
    And the admin tap whatsapp function
    Then the admin should be validate the whatsapp functionality
    And the admin tap directions functions
    Then the admin should be redirected to maps
    And the admin tap enquire functions
    And the admin enter enquiry message and send
    And the admin tap on share button
    Then the admin should be validate the share button
    And the admin tap on favorite icon
    And the admin tap on saved button
    Then the admin should be validate the favourite icon

  Scenario: to verify search with invalid values
    Given the admin enter a value "<searchfield>"
    When the admin tap search bar
    Then the admin verify no result found "<result>"

    Examples:
      | searchfield   | result  |
      | 12345678      | invalid |
      | kiaq Business | valid   |

 
  Scenario Outline: to verify search result with filterss cards and map view
    When the admin tap on  search bar
    Then the admin verify result found
    And the admin tap mostRelevant
    Then the admin should be validate most relevant filter
    And the admin tap on top rated filter
    And the admin tap rating 4+
    Then the admin  should be validate the top rated filter
    And the admin tap on newest filter
    And the admin tap rating 4.5
    Then the admin should be validate the newest
    And the admin tap on most reviewed
    Then the admin should be validated the most reviewed
    And the admin tap verified only
    And the admin tap featured only
    Then the admin tap show result
    And the admin click on verified card
    Then the admin validate the  verified card
    And the admin click on rating card
    Then the admin validate the  rating card
    And the admin tap on feature card
    Then the admin validate the the featured card
    And the admin tap on map view
    And the admin verify the list view
    And the admin verify the places on the map
    Then the admin tap on back to list
    When the admin leave the search field
    Then the admin validate the search field


  Scenario: to verify the control center
    When the admin tap on control center card
    Then the admin validate the control center page
    And  the admin tap see all
    Then the admin tap view all
