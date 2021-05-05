Feature: Obtaining concrete language message from factory

  Scenario: Requesting a concrete message in a certain language returns the message in that language
    Given A populated message factory
    When Obtaining the "spanish" welcome message
    Then The welcome message is in "spanish" language
