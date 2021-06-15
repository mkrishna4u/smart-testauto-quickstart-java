# Quickstart Project to setup Software Testing Automation Environment (Based on Smart Testing Automation Framework)

This is a maven based quickstart project to start working on sofwtare testing automation. If you have 10 minutes you can setup software testing environment and start writing the software testing automation related test cases. This quickstart project is based on **smart-testauto-framework** library present on the following path: 

	https://github.com/mkrishna4u/smart-testauto-framework
	

## Steps to setup project environment:

1.  Checkout both the projects on your computer

	*   smart-testauto-framework
	*   smartfwk-testauto-quickstart

2. Download Sikuli OCR Data files from the link <https://github.com/tesseract-ocr/tessdata_best> and place in **./test-config/sikuli-config/tessdata**

	tessdata
	|-	eng.traineddata (or any trained data file)
	|- configs
		|- api-config
		|- txt
		|- etc..

3. First compile the 'smart-testauto-framework' project using command:

> mvn clean install

4. Then run 'smartfwk-testauto-quickstart-java' project testcases using command:

> mvn clean verify -Dtest.suite.file=test-suites/MainTestSuite.xml

5. To generate only HTML reports, use the following commands:

> mvn verify -DskipTests=true

NOTE: Test execution HTML reports are placed on the following directory:
> test-results\cucumber-html-reports

## How to connect with relational database? 
	1. Add particular JDBC library in pom.xml file 
	2. Create a database profile in test-config/apps-config/<app-name>/database-profiles directory

## Code writing instructions:

1.  Place cucumber features in cucumber-testcases/ directory
2.  Place sikuli resources like images in sikuli-resources/ directory
3.  Place test data like excel files etc in test-data/ directory
4.  Write page objects in src/main/java/page_objects
5.  Write validators code in src/main/java/validators
6.  Write test step definitions (*StepDefs.java) and test execution code (*Test.java) code in src/test/java/stepdefs/features directory
8.  To run the regression test, use the following command:

	*   mvn -Dcucumber.filter.tags="@RegressionTest" clean verify
	* OR
	*   runRegressionTests.bat
	
NOTE: Test execution HTML reports are placed on the following directory:
> test-results\cucumber-html-reports

## License
Apache License, 2.0
