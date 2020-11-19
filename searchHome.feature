Feature: Search about suitable home
  
Background: The System has a repository of homes with their specifications (type-material-placement-pets-amenties-price-area-bedrooms-bathrooms-leaselength)
Given  these homes are contained in the system
                |HOUSE_WOOD_VILLAGE_NO_GARAGEPARKING,FIREPLACE,ELEVATOR|510_150_3_2_6|
                |APARTMENT_BRICK_CITY_NO_ELEVATOR|230_120_4_2_12|
      
  Scenario Outline: Search home by type
  When I search about home by "HOUSE"
  Then A list of homes that matches the  type specification should be returned and printed on the console
  And email with the result should be sent to the user "salahatr9@gmail.com"
  
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
   
    Scenario: Search about home with less than a specific area
    When I search about home with area less than 140
    Then A list of homes that matches the area specification should be returned and printed on the console
    
    
    Scenario: Search about home with range of specific area
    When I search about home with area between 130 to 200
    Then A list of homes that matches the area range specification should be returned and printed on the console
    
    
     Scenario: Search about home by lease length
     When I search about home with lease length "short term_6 months"
    Then A list of homes that matches the lease length specification should be returned and printed on the console
     
     
     Scenario: Search about home by Amenities
     When I search about home with "GARAGEPARKING,FIREPLACE,ELEVATOR" as Amenities  
     Then A list of homes that matches the Amenities specification should be returned and printed on the console
     
     
     
       Scenario: Search about home by number of bedrooms
     When I search about home with 4 bedrooms  
     Then A list of homes that matches the bedrooms specification should be returned and printed on the console
     
     
     
       Scenario: Search about home by number of bathrooms
     When I search about home with 2 bathrooms  
     Then A list of homes that matches the bathrooms specification should be returned and printed on the console
     
     
      Scenario: Search about home by number of  Allow Pets
     When I search about home that "NO" allow pets  
     Then A list of homes that matches Allow Pets specification should be returned and printed on the console
     
     
     
     
    