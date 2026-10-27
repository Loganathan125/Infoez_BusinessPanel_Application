 Feature: verify the home page fuctionality

  Scenario: to verify the notification count decreased after opening a notification
    Given the admin tap on notification
    When the user capture the current notification count
    And the user open the first notification
    Then the notification count should decrease by one

  Scenario Outline: to verify the location selection on home page
    Given the user tap on location field
    When the user search city "<City>"
    And the user select city "chennai" from the list
    Then the home page should display location

    Examples:
      | City    |
      | Chennai |

  Scenario: to verify the notify me functionality
    Given the admin tap near me option
    When the admin tap on only this time option
    And the admin tap turn on option
    Then the Nearby business should be displayed

  Scenario: to verify the use my current location
    Given the admin tap on lodation field
    When the amin tap on use my current location
    And the admin tap on this time option
    Then use my current location should be displayed

  Scenario: to verify the favourite icon
    Given the admin tap on search bar
    When the admin tap on favorite icon
    And the admin tap on saved button
    Then the admin should be validate the favourite icon

  Scenario: to verify the call functionality
    Given the admin click on search bar
    When the admin tap on any Business name
    And the admin tap call function
    Then the admin should be validate the call functionality

  Scenario: to verify the whatsapp functionality
    Given the admin click  search bar
    When the admin tap  any Business name
    And the admin tap whatsapp function
    Then the admin should be validate the whatsapp functionality

  Scenario: to verify the directions function
    Given the admin click search field
    When admin tap any business name
    And the admin tap directions functions
    Then the admin should be redirected to maps

  Scenario: to verify the enquiry is listed in my enquires
    Given the admin tap on search field
    When user tap on any business name
    And the admin tap enquire functions
    And the admin enter enquiry message and send
    Then the send enquiry should be listed in my enquiries

  Scenario: to verify the share button
    Given the admin clicked on search field
    When the admin clicked on any business name
    And the admin tap on share button
    Then the admin should be validate the share button

  Scenario: to verify the home page search field
    Given the admin enter a value "Kiaq Business"
    When the admin tap search bar
    Then the admin verify the place found
    
    Scenario: to verify the filtering and sort
    Given the admin click on search
    When the admin tap mostRelevant
    And the admin tap verified only
    And the admin tap featured only
    Then the admin tap showw result


  @home1
  Scenario: to verify the filtering sort like verified, featured
    Given the admin clck searchField
    When the admin click on verified card
    Then the admin validate the  verified card


  @home2
  Scenario: to verify the filtering sort rating
    When the admin click on rating card
    Then the admin validate the  rating card

  @home3
  Scenario: to verify the featured filter
    When the admin tap on feature card
    Then the admin validate the the featured card
    
    @home4
    Scenario: to verify the map view
    When the admin tap on map view
    And  the admin verify the list view
    And the admin verify the places on the map
    Then the admin tap on back to list
    
    
    @home5
    Scenario: to verify the search functinality
    When  the admin leave the search field
    Then the admin validate the search field
    
    Scenario: to verify the Manage your business
    When the admin tap on manage your business card
    Then the admin validate the business dashboard page
    
    Scenario: to verify the see all and view all
    When the admin tap see all 
    Then the admin tap view all
    
    
    


    
    


    
