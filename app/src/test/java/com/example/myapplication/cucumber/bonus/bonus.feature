Feature: Adding bonus to a score

  Scenario: Starting with a lower score than 100 points adding bonus does not affect score
    Given A score with 5 points
    When Adding bonus to 5 points score
    Then Score remains still with 5 points

  Scenario: Starting with a higher or equal score than 100 points adding bonus alters score
    Given A score with 105 points
    When Adding bonus to 105 points score
    Then Score is now 205 points