Feature: Show greetings

  Scenario: Pseudo-randomly generated greeting must be in the greetings list
    Given A random greeting generator
    When Generating a new random greeting
    Then The greeting must be in the greetings list

  Scenario: If greetings are disabled, generating greeting throws exception
    Given A disabled random greeting
    When Generating a new random greeting, when greetings are disabled
    Then Throws an exception

