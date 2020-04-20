Feature: When on the form page, the user can enter in there details
  Scenario: User is on the form page and entered a valid first name.
    Given I am on the form page
    When I enter a valid first name into the field
    Then The form validated my first name

  Scenario: User is on the form page and entered a invalid first name.
    Given I am on the form page
    When I enter a invalid first name into the field
    Then The form informs me of an invalid first name

  Scenario: User is on the form page and entered a valid last name.
    Given I am on the form page
    When I enter a valid last name into the field
    Then The form validated my last name

  Scenario: User is on the form page and entered a invalid last name.
    Given I am on the form page
    When I enter a invalid last name into the field
    Then The form informs me of an invalid last name

  Scenario: User is on the form page and entered a valid age.
    Given I am on the form page
    When I enter a valid number for age into the field
    Then The form validated the number entered for age

  Scenario: User is on the form page and entered a invalid age.
    Given I am on the form page
    When I enter a invalid number for age into the field
    Then The form informs me of an invalid number for age

  Scenario: User is on the form page and selects there gender
    Given I am on the form page
    When I select my gender
    Then The correct selected gender is displayed

  Scenario: User is on the form page and selects only there corresponding gender
    Given I am on the form page
    When I select my gender
    Then The opposite gender is not selected

  Scenario: User is on the form page and select an university
    Given I am on the form page
    When I select a university
    Then I have selected a university

  Scenario: User is on the form page and entered a valid email.
    Given I am on the form page
    When I enter a valid email into the field
    Then The form validated the email that was entered

  Scenario: User is on the form page and entered a invalid email.
    Given I am on the form page
    When I enter a invalid email into the field
    Then The form informs me of an invalid email

  Scenario: User is on the form page and rates the form
    Given I am on the form page
    When I rate the form for my experience
    Then The corresponding value rated is displayed.