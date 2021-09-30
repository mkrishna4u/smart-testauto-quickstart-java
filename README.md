# Quickstart Project to setup "Web Application (Non-Mobile platform)" Software Testing Automation Environment (Based on Smart Testing Automation Framework, Version 2.X.X)

This is a maven based quickstart project to start working on sofwtare testing automation. If you have 30 minutes (Based on your network speed) you can setup software testing environment and start writing the software testing automation related test cases. This quickstart project is based on **smart-testauto-framework** library present on the following path: 

	https://github.com/mkrishna4u/smart-testauto-framework
	
This project is using following software tools:

	> Selenium Web Driver: You can download the specific selenium web driver (like for chrome, firefox etc..) from the vendor's website and put the executable driver file in **test-config/app-drivers/web-app/<browser-name>/**.
	> Java JDK: Download URL - http://jdk.java.net/ : Used to compile and run Java code.
	> Apache Maven: Download URL - https://maven.apache.org/download.cgi : Used as a build tool to setup project dependencies, compile code and run testcases.
	
Install all the tools on your PC and change the **set-env.cmd** file to set the correct path for environment variables.

## Steps to setup project environment:

A. Checkout project on your computer from Github

	*   smart-testauto-quickstart-java

B. Download Sikuli OCR Data files from the link <https://github.com/tesseract-ocr/tessdata_best> and place in **./test-config/sikuli-config/tessdata**

	tessdata
	|-	eng.traineddata (or any trained data file)
	|- configs
		|- api-config
		|- txt
		|- etc..

C. Change the username and password of github application in the following path:

	> test-config/apps-config/github-app/AppConfig.properties
	
D. Then run the following command to execute the test scenarios (Written in Cucumber).
	
	> mvn clean verify -Dcucumber.filter.tags="@RegressionTest"
	OR
	> runRegressionTests.bat

NOTE: Test execution HTML reports are placed on the following directory:
> test-results\cucumber-html-reports

E. To re-generate only HTML reports manually, use the following commands:

> mvn verify -DskipTests=true

F. If you would like to inspect the elements from web application to create page object (PO) classes, install your favorite plugin / extension on web browser to get the xpath or different type of locators.

## How to connect with relational database? 
	1. Add particular JDBC library in pom.xml file 
	2. Create a database profile in test-config/apps-config/<app-name>/database-profiles directory

## Code writing instructions:

1.  Place cucumber feature files in cucumber-testcases/ directory
2.  Place sikuli resources like images in sikuli-resources/ directory
3.  Place test data like excel, csv, txt, files etc in test-data/ directory
4.  Write page objects in src/main/java/page_objects
5.  Write validators code in src/main/java/validators
6.  Write test step definitions (*StepDefs.java) and test execution code (*Test.java) code in src/test/java/stepdefs/features directory
7.  To run the regression test, use the following command:

	*   mvn clean verify -Dcucumber.filter.tags="@RegressionTest"
	 OR
	*   runRegressionTests.bat
	
NOTE: Test execution HTML reports are placed on the following directory:
> test-results\cucumber-html-reports

## License
Apache License, 2.0
