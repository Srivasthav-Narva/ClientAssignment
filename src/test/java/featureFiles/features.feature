Feature: API Testing
@postmethod
  Scenario: POST Method
    Given An API for Post method
    When posted with correct information
    Then validate status code received for post
    
    @getmethod 
  Scenario: GET Method
  Given An Api for testing get method
  When Retrieve the information from the api
  Then validate status  code for get method
  
  @putmethod
  Scenario: PUT Method
  Given API for testing put method
  When Updated correct information
  Then validate response code for put method
  
    @patchmethod
  Scenario: PATCH Method
  Given An API for testing patch method
  When updates with correct information
  Then validate positive response code for patch method
  
  @deletemethod
  Scenario: DELETE Method
  Given An API for testing delete method
  When Delete the resource from api
  Then validate the response code for delete
  
  @postmethod
  Scenario: To test Post Method
    Given API for testing Post method
    When posted with correct information in the url
    Then validate status for post
    
    @negativescenario
  Scenario: To test Post Method
    Given API for testing for negative scenario
    When posted with incorrect information in the url
    Then validate negative status code for post
    
    @GetNegativeScenario
    Scenario: To test get method
    Given An API for testing get method
    When retriving information from  API
    Then validate response code