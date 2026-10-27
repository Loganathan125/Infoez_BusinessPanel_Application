@login
Feature: to verify the infoez mobile application

  Background:
    Given ven the user tap profile button
    And the user tap login or register button

  Scenario Outline: Login with valid credentials
    Given the user enter username "<username>"
    And the user enter password "<password>"
    And the user click on login button
    Then the user redirected the home page "<HomePage>"

    Examples:
      | username         | password  | HomePage |
      # |                  |           | InValid1  |
      # | 1234567899       | 12345678  | InValid2  |
      # | owner@infoez.com | Owner     | InValid3  |
      # | owner@infoez.com | owner@123 | InValid4  |
      # | owner@infoez.com | OWNER@123 | InValid5  |
      # | owner@infoez.com | !@$%^&*@! | InValid6  |
      # | owner&infoez.com | Owner@123 | InValid7  |
      # | 123456789        | Owner@123 | Invalid8  |
      # | owner@infoez.com | 123456789 | InValid9  |
      # | ownerinfoez.com  | Owner@123 | InValid10 |
      # |                  | Owner@123 | Invalid11 |
      # | Owner@infoez.com |           | Invalid12 |
      | owner@infoez.com | Owner@123 | Valid    |
