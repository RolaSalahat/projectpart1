Feature: Search about suitable home
  
Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenties-price-area-bedrooms-bathrooms-leaselength)
Given  these homes are contained in the system
                |HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR|510_150_3_2_6|
                |APARTMENT_BRICK_CITY_NO_ELEVATOR|230_120_4_2_12|
      
  Scenario Outline: Search home by type
  When I search about home by "HOUSE"
  Then A list of homes that matches the  type specification should be returned and printed on the console
  
  Scenario: Search about home with less than a specific price
    When I search about home with price less than 400
    Then A list of homes that matches the price specification should be returned and printed on the console
   
   Scenario: Search home by placement
   When I search about home by "VILLAGE" as a placment
   Then A list of homes that matches the placement specification should be returned and printed on the console
   
   Scenario: Search home by material
   When I search about home by "WOOD" material
   Then A list of homes that matches the material specification should be returned and printed on the console
   
    Scenario: Search about home with range of specific price
    When I search about home with price between 150 to 600
    Then A list of homes that matches the price range specification should be returned and printed on the console
   