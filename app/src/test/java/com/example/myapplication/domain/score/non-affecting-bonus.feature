Feature: Locate cities in Germany using Google Maps

  Scenario: Locate Berlin Germany using Google Maps
    Given I am on www.maps.google.com
    When I search for Berlin Germany
    Then I should see Berlin on the map