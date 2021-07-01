#
# @Author Ajita Krishna
#
@HomePageTests
Feature: Verify home page functionality.
	This feature will be used to verify home page functionality.
	
	@RegressionTest @SmokeTest
	Scenario: Verify the default information of home page when the page is displayed after login.
		When User login using "StandardUserProfile-01" user profile.
		Then Home page is displayed.
		And Verify the following information is present on the home page:
			| Notification Icon         |
			|	User Icon							    |
			|	Repositories Label		    |
			|	Find a repository Textbox |
	
	@RegressionTest
	Scenario: Verify <Find a repository> filter is working properly.
		Given User is already logged in using "StandardUserProfile-01" user profile.
		And Navigate to home page.
		When The user types "java" in the <Find a repository> textbox present on home page.
		Then The filter should show all the labels which contains "java" on home page.
		
	@RegressionTest
	Scenario: Verify <Sign out> functionality is working properly.
		Given User is already logged in using "StandardUserProfile-01" user profile.
		When The user clicks on <User icon> on home page.
		And From the menu items click <Sign out> on home page.
		Then Verify the login page is displayed. 
		And Close the web browser.


