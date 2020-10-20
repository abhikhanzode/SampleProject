Feature: ATL Project

@SmokeTest
Scenario: Check that user able to launch browser and BI Application
	Given Launch the browser and BI Application
	Then close the browser

@RegressionTest
Scenario: ATL Estimate Import Flow
  Given Launch the browser and Brandintelle application
  When Uaser ID and Password both are correct
  Then Click on Login and User should be on Home Page
  And Sraech ATL application
  Then Click on Import Estimate from menu
  And close the Browser
  
 