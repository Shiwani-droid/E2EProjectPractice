Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome 
And Navigate to "http://qaclickacademy.com/" site
And Click on Login link in home page to login on secure sign in page
When user enters <username> and <password> and logs in
Then Verify user is successfully logged in
And close browsers

Examples:
|username	                    |password	 |
|Test@rocket.co.in            |Password@1|
|tom@gmail.com                |Tesss234  |