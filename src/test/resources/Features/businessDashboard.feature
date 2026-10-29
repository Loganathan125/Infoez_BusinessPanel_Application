
@Infoez @BusinessOwner
Feature: Infoez Business Owner Mobile Application

  Background:
    Given I am logged in as a business owner

  @Positive @BO_Positive
  Scenario Outline: Verify complete business owner positive flow

    When I navigate to the business owner profile
    Then I verify the business owner profile is displayed
    And I verify the "Open business dashboard" button is displayed
    And I verify the "Create a listing" option is displayed
    And I verify the "Claim an existing listing" option is displayed

    When I click the Open business dashboard button
    Then I verify the Business dashboard page is displayed
    And I verify the dashboard tabs are displayed

    When I select the "Overview" tab
    Then I verify the overview metric "Views" is displayed
    And I verify the overview metric "Calls" is displayed
    And I verify the overview metric "WhatsApp" is displayed
    And I verify the overview metric "Directions" is displayed
    And I verify the overview metric "Enquiries" is displayed
    And I verify the overview metric "Leads" is displayed

    Then I verify the business listing "Bloom Beauty Studio" is displayed
    And I verify the business listing "HomeFix Pro" is displayed
    And I verify the business listing "QuickShift Auto" is displayed
    And I verify the business listing "Aarogya Clinic" is displayed

    When I select the "Leads" tab
    Then I verify the leads section is displayed
    And I verify the lead status options are displayed

    When I select the first lead
    And I change the lead status to "<leadStatus>"
    Then I verify the selected lead status is "<leadStatus>"

    When I select the "Reviews" tab
    Then I verify the reviews section is displayed
    And I verify customer ratings are displayed
    And I verify the Reply button is displayed

    When I click the Reply button for the first review
    Then I verify the review reply option is opened
    When I navigate to the business dashboard
    And I select the "Analytics" tab
    Then I verify the analytics section "MONTH TO DATE" is displayed
    And I verify the analytics section "Total customer interactions" is displayed
    And I verify the analytics section "7-day trends" is displayed
    And I verify the analytics section "Channel breakdown" is displayed

    When I select the "Plan" tab
    Then I verify the current subscription plan is displayed
    And I verify the current plan is "Enterprise"
    And I verify the subscription plan "Free" is displayed
    And I verify the subscription plan "Starter" is displayed
    And I verify the subscription plan "Pro" is displayed
    And I verify the subscription plan "Enterprise" is displayed

    # Subscription Pricing
    Then I verify the subscription plan "Free" has price "Free"
    And I verify the subscription plan "Starter" has price "₹19/mo"
    And I verify the subscription plan "Pro" has price "₹49/mo"
    And I verify the subscription plan "Enterprise" has price "₹149/mo"

    # Create Business Listing
    When I navigate to the business owner profile
    And I click the Create a listing option
    Then I verify the List your business page is displayed
    And I verify the Camera option is displayed
    And I verify the Gallery option is displayed
    And I verify the business listing fields are displayed

    # Enter Business Details
    When I enter the business name "<businessName>"
    And I select the business category "<category>"
    And I enter the business description "<description>"
    And I enter the street address "<address>"
    And I enter the area "<area>"
    And I enter the city "<city>"
    And I enter the pincode "<pincode>"
    And I enter the phone number "<phone>"
    And I enter the WhatsApp number "<whatsapp>"
    Then I verify the business listing details are entered

    # Submit Business Listing
    When I click the Submit for verification button
    Then I verify the business listing is submitted for verification

    # Business Enquiries
    When I navigate to the Enquiries page
    Then I verify the Enquiries page is displayed
    And I verify enquiry cards are displayed
    And I verify new enquiry status is displayed

    Examples:
      | leadStatus | businessName         | category      | description           | address        | area       | city    | pincode | phone      | whatsapp   |
      | New        | Infoez Beauty Studio | Beauty clinic | Beauty and salon care | 12 Main Street | Anna Nagar | Chennai | 600040  | 9000000001 | 9000000001 |
      | Contacted  | Infoez Pet Care      | Pet Care      | Pet grooming and care | 25 Park Street | T Nagar    | Chennai | 600017  | 9000000002 | 9000000002 |
      | Interested | Infoez Test Studio   | Beauty clinic | Test business listing | 10 Main Street | Anna Nagar | Chennai | 600040  | 9000000003 | 9000000003 |
      | Converted  | Infoez Demo Studio   | Beauty clinic | Demo business listing | 15 Main Street | Anna Nagar | Chennai | 600040  | 9000000004 | 9000000004 |

  @Negative @BO_Negative
  Scenario Outline: Verify business listing mandatory field validation

    When I navigate to the business owner profile
    And I click the Create a listing option
    Then I verify the List your business page is displayed

    When I enter the business name "<businessName>"
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
      | businessName | category      | description    | address     | area       | city    | pincode | phone      | whatsapp   | missingField  |
      |              | Beauty clinic | Test business  | Main Street | Anna Nagar | Chennai | 600040  | 9000000001 | 9000000001 | Business name |
      | Test Studio  | Beauty clinic | Test business  | Main Street | Anna Nagar | Chennai |         | 9000000001 | 9000000001 | Pincode       |
      | Test Studio  | Beauty clinic | Test business  | Main Street | Anna Nagar | Chennai | 600040  |            | 9000000001 | Phone         |
