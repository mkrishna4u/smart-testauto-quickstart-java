Feature: Verify Google Email Login and Logout
	Used to verify google email login/logout functionality.
	
	Scenario: Verify google email login and logout.
		Given Login on Google email is successful.
		When Click on Logout button on dashboard.
		Then Google email login screen will be displayed.
		