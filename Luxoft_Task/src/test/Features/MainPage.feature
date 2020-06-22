Feature: Example automation tasks for Luxoft recruitment process
  Scenario: Searching for string
    Given I have open main page
    When I search for specific phrase
    Then Phrase results has been found

  Scenario: Changing language
    Given I have open main page
    When I click on DE icon
    Then Language has been changed

  Scenario: Changing domicile
    Given I have open main page
    When I select my domicile
    Then Selected domicile is visible on page
