Feature: Data provider 
@Dataprovider
Scenario Outline: Passing data using SO to get method
Given An url for api testing
When enter the path of the given method "<path>"
Then Validate response code

Examples: 
|path|
|/api/users/2|