Feature: Validating Place API's

Scenario Outline: Verify if Place has been succesfully added using AddPlaceAPI
Given Add Place Payload with "<name>" "<lanugage>" "<address>"
When user calls "addPlaceAPI" with "Post" http request
Then the API call is success with status code 200
And the "status" in the response body is "OK"
And the "scope" in the response body is "APP"
And verify place_id created maps to "<name>" using "getPlaceAPI"

Examples: 
| name | language | address            |
| John | English  | World cross center |
#| Jane | Spanish  | Sea cross center   |