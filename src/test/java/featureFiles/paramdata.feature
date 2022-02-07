Feature: API testing
Scenario: To test post method using parameterization
Given An Api for testing post method
When posted the correct information with dataprovider "name" and "job"
Then validate the response code "name" and "job"