Feature: to verify the profile section

  Scenario: to verify the profile section
    Given the user tap profile btn
    And the business page should be displayed
    Then the user tap create a listing

  Scenario: to verify the camera

  # Given the user tap camera
  # Then the user verify the camera
  Scenario: to verify the gallery image

  # Given the user tap gallery option
  # And the user select the images
  # Then the user validate the images
  
  Scenario: to verify the upto 6 photos
    Given the user tap gallery
    When the user select the imeage
    Then the user validate the image view

  Scenario Outline: submit business details with valid data
    Given the user enter business name "<BusinessName>"
    When the user select a category
    And the user enter description "<businessDescripion>"
    And the user enter  street "<StreetAddress>"
    And the user enter area  "<Area>"
    And the user enter city  "<City>"
    And the user enter  pincode "<pincode>"
    And the user enter phoneNumber "<phoneNumber>"
    And the user enter whatsappNumber  "<WhatsappNumber>"
    And the user submit the business verification form
    Then business name required validation  submission should be displayed "<expected>"

    Examples:
      | BusinessName    | businessDescripion           | StreetAddress | Area           | City    | pincode | phoneNumber | WhatsappNumber | expected |
      |                 | Professional Beauty services | 12 Main Road  | Anna Nagar     | Chennai | 600028  | 7397787483  | 7397787483     | Invalid  |
      | Kiaq Technology | Software Company             | 6th Street    | Navalur        | Chennai |         | 7397787483  | 7397787483     | Invalid2 |
      | A2B             | The Food is good             |               | T Nagar        | Chennai | 600028  | 7397787483  | 7397787483     | Invalid3 |
      | A2B             | The Food is good             | 6th Street    | T Nagar        |         | 600028  | 7397787483  | 7397787483     | Invalid4 |
      | infosys         | Software Company             | 6th Street    | Navalur        | Chennai |         | !@##@!      | !@##@!         | Invalid5 |
      | Desicrew        | Software Company             | Neru Street   | Navalur        | Chennai |         |             | 7397787483     | Invalid6 |
      | Hcl             | Software Company             | 6th Street    | Sollinganallur | Chennai |         | 7397787483  |                | Invalid7 |
      | Cts             | Software Company             | 11th Cross    | Navalur        | Chennai |         |             |                | Invalid8 |
      | Mira Studio     | Professional Beauty services | 12 Main Road  | Anna Nagar     | Chennai | 600028  | 7397787483  | 7397787483     | valid    |

  Scenario Outline: to verify the city search results in claims a business
    Given the user tap claim an existing listing
    When the user search the city "<city>"
    Then the result should be displayed

    Examples:
      | city    |
      | chennai |

  Scenario: to verify the claims a business
    Given the user select any business name
    When the user scroll till bottom
    And the user enter mobile number "7397787483"
    And the user tap submit claims btn
    Then the user validate the claims submitted

  Scenario: to verify the claims a business
    Given the user select any business name
    When the user scroll a till bottom
    And the user enter mobile number
    And the user tap submit claims button
    Then the user validate  claims submitted

  Scenario: to verify the subscription
    Given the user tap free card subscription
    When the user validate the free card subscription
    And the user tap starter card subscription
    And the user validate the starter card subscription
    And the user tap pro card subscription
    And the user validate the pro card subscription
    And the user tap enterprice card subscription
    And the user validate the enterprice card subscription

  Scenario: to verify the notification count decreased after opening a notification
    Given the user tap on notification
    When the user capture current notification count
    And the user open the first notificattion
    Then the notification count should be decrease by one

  Scenario: to verify the open business dashboard
    Given the user tap open business dashboard
    Then the user verify the business dashboard page
