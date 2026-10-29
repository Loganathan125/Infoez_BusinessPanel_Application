@BusinessOwner
Feature: Infoez Business Owner Mobile Application

  Background:
    Given I am logged in as a business owner


  @BO_01 @profile @positive
  Scenario: Verify business owner profile
    When I navigate to the business owner profile
    Then I verify the business owner profile is displayed
    And I verify the "Open business dashboard" button is displayed
    And I verify the "Create a listing" option is displayed
    And I verify the "Claim an existing listing" option is displayed

  @BO_02 @dashboard @positive
  Scenario: Open business dashboard
    When I navigate to the business owner profile
    And I click the Open business dashboard button
    Then I verify the Business dashboard page is displayed
    And I verify the dashboard tabs are displayed

  @BO_03 @overview @positive
  Scenario Outline: Verify dashboard overview metrics
    When I navigate to the business dashboard
    And I select the "Overview" tab
    Then I verify the overview metric "<metric>" is displayed

    Examples:
      | metric     |
      | Views      |
      | Calls      |
      | WhatsApp   |
      | Directions |
      | Enquiries  |
      | Leads      |

  @BO_04 @listings @positive
  Scenario Outline: Verify business listings
    When I navigate to the business dashboard
    And I select the "Overview" tab
    Then I verify the business listing "<business>" is displayed

    Examples:
      | business            |
      | Bloom Beauty Studio |
      | HomeFix Pro         |
      | QuickShift Auto     |
      | Aarogya Clinic      |

  @BO_05 @leads @positive
  Scenario: Verify business leads
    When I navigate to the business dashboard
    And I select the "Leads" tab
    Then I verify the leads section is displayed
    And I verify the lead status options are displayed

  @BO_06 @leads @positive
  Scenario Outline: Update business lead status
    When I navigate to the business dashboard
    And I select the "Leads" tab
    And I select the first lead
    And I change the lead status to "<status>"
    Then I verify the selected lead status is "<status>"

    Examples:
      | status     |
      | New        |
      | Contacted  |
      | Interested |
      | Converted  |

  @BO_07 @reviews @positive
  Scenario: Verify business reviews
    When I navigate to the business dashboard
    And I select the "Reviews" tab
    Then I verify the reviews section is displayed
    And I verify customer ratings are displayed
    And I verify the Reply button is displayed

  @BO_08 @reviews @positive
  Scenario: Open reply to customer review
    When I navigate to the business dashboard
    And I select the "Reviews" tab
    And I click the Reply button for the first review
    Then I verify the review reply option is opened

  @BO_09 @analytics @positive
  Scenario Outline: Verify business analytics
    When I navigate to the business dashboard
    And I select the "Analytics" tab
    Then I verify the analytics section "<section>" is displayed

    Examples:
      | section                     |
      | MONTH TO DATE               |
      | Total customer interactions |
      | 7-day trends                |
      | Channel breakdown           |

 
  @BO_10 @plan @positive
  Scenario: Verify current subscription plan
    When I navigate to the business dashboard
    And I select the "Plan" tab
    Then I verify the current subscription plan is displayed
    And I verify the current plan is "Enterprise"

  @BO_11 @plan @positive
  Scenario Outline: Verify available subscription plans
    When I navigate to the business dashboard
    And I select the "Plan" tab
    Then I verify the subscription plan "<plan>" is displayed

    Examples:
      | plan       |
      | Free       |
      | Starter    |
      | Pro        |
      | Enterprise |

  @BO_12 @plan @positive
  Scenario Outline: Verify subscription pricing
    When I navigate to the business dashboard
    And I select the "Plan" tab
    Then I verify the subscription plan "<plan>" has price "<price>"

    Examples:
      | plan       | price  |
      | Free       | Free   |
      | Starter    | ₹19/mo |
      | Pro        | ₹49/mo |
      | Enterprise | ₹149/mo |


  @BO_13 @listing @positive
  Scenario: Verify create business listing form
    When I navigate to the business owner profile
    And I click the Create a listing option
    Then I verify the List your business page is displayed
    And I verify the Camera option is displayed
    And I verify the Gallery option is displayed
    And I verify the business listing fields are displayed

  @BO_14 @listing @positive
  Scenario Outline: Enter business listing details
    When I navigate to the business owner profile
    And I click the Create a listing option
    And I enter the business name "<businessName>"
    And I select the business category "<category>"
    And I enter the business description "<description>"
    And I enter the street address "<address>"
    And I enter the area "<area>"
    And I enter the city "<city>"
    And I enter the pincode "<pincode>"
    And I enter the phone number "<phone>"
    And I enter the WhatsApp number "<whatsapp>"
    Then I verify the business listing details are entered

    Examples:
      | businessName         | category      | description             | address         | area       | city    | pincode | phone      | whatsapp   |
      | Infoez Beauty Studio | Beauty clinic | Beauty and salon care   | 12 Main Street  | Anna Nagar | Chennai | 600040  | 9000000001 | 9000000001 |
      | Infoez Pet Care      | Pet Care      | Pet grooming and care   | 25 Park Street  | T Nagar    | Chennai | 600017  | 9000000002 | 9000000002 |

  @BO_15 @listing @positive
  Scenario Outline: Submit business listing for verification
    When I navigate to the business owner profile
    And I click the Create a listing option
    And I enter the business name "<businessName>"
    And I select the business category "<category>"
    And I enter the business description "<description>"
    And I enter the street address "<address>"
    And I enter the area "<area>"
    And I enter the city "<city>"
    And I enter the pincode "<pincode>"
    And I enter the phone number "<phone>"
    And I enter the WhatsApp number "<whatsapp>"
    And I click the Submit for verification button
    Then I verify the business listing is submitted for verification

    Examples:
      | businessName          | category      | description           | address        | area       | city    | pincode | phone      | whatsapp   |
      | Infoez Testing Studio | Beauty clinic | Test business listing | 10 Main Street | Anna Nagar | Chennai | 600040  | 9000000003 | 9000000003 |


  @BO_16 @listing @negative
  Scenario Outline: Verify business listing mandatory field validation
    When I navigate to the business owner profile
    And I click the Create a listing option
    And I enter the business name "<businessName>"
    And I select the business category "<category>"
    And I enter the business description "<description>"
    And I enter the street address "<address>"
    And I enter the area "<area>"
    And I enter the city "<city>"
    And I enter the pincode "<pincode>"
    And I enter the phone number "<phone>"
    And I enter the WhatsApp number "<whatsapp>"
    And I click the Submit for verification button
    Then I verify the business listing is not submitted
    And I verify the mandatory field "<missingField>" is invalid

    Examples:
      | businessName     | category      | description     | address     | area       | city    | pincode | phone      | whatsapp   | missingField |
      |                  | Beauty clinic | Test business  | Main Street | Anna Nagar | Chennai | 600040  | 9000000001 | 9000000001 | Business name |
      | Test Studio      | Beauty clinic | Test business  | Main Street | Anna Nagar | Chennai |         | 9000000001 | 9000000001 | Pincode       |
      | Test Studio      | Beauty clinic | Test business  | Main Street | Anna Nagar | Chennai | 600040  |            | 9000000001 | Phone         |

 
  @BO_17 @enquiries @positive
  Scenario: Verify business enquiries
    When I navigate to the Enquiries page
    Then I verify the Enquiries page is displayed
    And I verify enquiry cards are displayed
    And I verify new enquiry status is displayed