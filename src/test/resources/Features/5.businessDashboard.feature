# @counters
Feature: to verify the  business dashboard in the BO panel

  Scenario Outline: all counts increase after interacting with a random listion
    Given the user tap on  business dashboard card
    When the user note all the counts on the dashbaord
    And the user open a random listion from "your listings"
    When the admin tap on "<action>" action btn
    Then the admin verify the "<action>" action

    Examples:
      | action     |
      | Call       |
      | Whatsapp   |
      | Directions |
      | Enquire    |

  Scenario Outline: to verify the review and favourite icon and share
    Given the user tap business dashboard card
    When the user tap on any business card
    And the user tap on write a review
    Then the user verify the review
    And the admin tap on share btn
    Then the admin should be validate  share button
    When the admin tap  favorite icon in the business details page
    And the admin tap  saved button
    Then the admin should  validate the favourite list

  Scenario Outline: to verify the update lead status for each lead card
    When the user tap on "<tap>"

    Examples:
      | tap        |
      | Interested |

  @review
  Scenario Outline: to verify the reply to a review
    When the user tap on reviews tab
    And  the user reply to the review with "<reply>"
    Then the user verify the reply posted message
    

    #Examples:
      #| reply           |
      #| Great Experince |

  @plan
  Scenario Outline: to verify the subscription
    Given the user tap on plan tap
    When the user tap upgrade on "<plan>"
    And the user select payment method "<method>"
    And the user tap on pay button
    Then the user verify the plan active "<method>"

    Examples:
      | plan | method  |
      | Pro  | PhonePe |
# @listings
# Scenario: All listings shown match the listings count in the header
# Given the user read the total from the "Your listings" header
# When the user scroll to the end of the listings
# Then the number of unique listings should equal the header total
