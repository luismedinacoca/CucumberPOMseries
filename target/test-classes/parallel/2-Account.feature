Feature: Account Page Feature

  Background:
    Given user has already logged in to application
    | username|password|
    |testing@example.com.ar|Selenium2021|

  Scenario: Account page title
    Given user is on Account page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  Scenario: Account section count
    Given user is on Account page
    Then user gets account section
    |ORDER HISTORY AND DETAILS|
    |MY CREDIT SLIPS|
    |MY ADDRESSES|
    |MY PERSONAL INFORMATION|
    |MY WISHLISTS|
    |Home|
    And account section count should be 6