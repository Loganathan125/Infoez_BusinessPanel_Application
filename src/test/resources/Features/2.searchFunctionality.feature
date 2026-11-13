
@search
#@admin
Feature: verify the home page fuctionality

  Scenario Outline: to verify the business details actions
    Given the admin tap on bottom search icon
    When the admin open the business from search result
    When the admin tap on "<action>" action button
    Then the admin verify "<action>" action

    Examples:
      | action     |
      | Call       |
      | Whatsapp   |
      | Directions |
      | Enquire    |

  Scenario: to verify the share button and favourite icon
    And the admin tap on share button
    Then the admin should be validate the share button
    When the admin tap on favorite icon in the business details page
    And the admin tap on saved button
    Then the admin should be validate the favourite list

  Scenario Outline: to verify search result with filters
    When the admin tap on bottom search bar
    And the admin tap on Filters in search module
    And the admin select "<Sort by>" in filter section
    And the admin tap show result button
    Then the admin validates the places for applied filter

    Examples:
      | Sort by       |
      | Most relevant |

  Scenario Outline: to verify the ratings
    When the admin tap filters in search Module
    And the admin select "<MinimumRating>" in the filter section
    And the admin click show result button
    Then the admin validates the places for the applied filter

    Examples:
      | MinimumRating |
      | 4+            |

  Scenario: to verify the verified toggles
    When the admin tap filter search module
    And the admin enabled verified only
    And the admin click on show results btn
    Then the admin  validate the places for applied filter

  Scenario: to verify the featured toggles
    When the user tap filter search module
    And the admin enabled featured only
    And the admin tap on show results btn
    Then the admin  validates the place for applied filter

  Scenario: to verify the map view in the explore Business page
    When the admin tap on map view
    And the admin verify the list view
    And the admin verify the places on the map
    Then the admin tap on back to list
    When the admin leave the search field
    Then the admin validate the search field
    
    
