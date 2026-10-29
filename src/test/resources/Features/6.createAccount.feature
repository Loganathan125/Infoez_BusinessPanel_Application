@create
Feature: to verify the create account

  Background:
    Given the user launch the   applicationn
    When ven the user tap profile btn
    And the user tap login or register btn

  Scenario Outline: to verif the create account valid and invalid scenarios
    When to user tap create account card
    And the user enter a fullname "<fullName>"
    And the user enter a email "<email>"
    And the user enter a password "<password>"
    And the user tap on create account button
    Then the page should be redirected home page "<expected>"

    Examples:
      | fullName                   | email             | password    | expected |
      |                            | raja@infoez.com   | Test@123    | invalid1 |
      | Raja                       |                   | Test@1234   | invalid2 |
      | Raja                       | rajainfoez.com    |             | invalid3 |
      | lojjsdhjfddbsvdtfgcdfadfcs | raja@infoez       | Test@1234   | invalid4 |
      | Raja                       | raja@infoez.com   | test        | invalid5 |
      | !@#$%##@!#@                | raja@infoez.com   | @!@#$#@@!#  | invalid6 |
      | 12345678                   | raja@infoez.com   | Test@1234   | invalid7 |
      | Suresh V                   | suresh@infoez.com | suresh@1234 | invalid8 |
      | Guru                       | guru@infoez.com   | Guru@1234   | valid    |
