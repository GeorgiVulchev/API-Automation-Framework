Feature: Validating Place API's

Scenario: Verify if Place has been succesfully added using AddPlaceAPI
Given Add Place Payload
When user calls "AddPlaceAPI" with Post http request
Then the API call is success with status code 200
And the "status" in the response body is "OK"
And the "scope" in the response body is "APP"
