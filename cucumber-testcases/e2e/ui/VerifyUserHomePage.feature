@StandardUser
Feature: Verify user home page.
  Used to verify user home page contents after login to the github system.

  @RegressionTest @SmokeTest @SanityTest @TempScenario
  Scenario: Verify default page information just after login.
    When connect to "github" application using "SampleUserProfile" user profile.
    Then "the user" will be "logged in to github application and home page will be displayed ".
    And get text part of each element of "github.TopMenuPO.TopMenu_List" page element and store into "TOP_MENUS_VAR" variable.
    And verify value of "TOP_MENUS_VAR" variable "=" '{ev: ["Pull requests", "Issues", "Codespaces", "Marketplace", "Explore"], valueType: "string-list"}'.
    And verify that the following page elements are visible on "Home page":
      | Page Element                                 |
      | github.LoginSuccessPO.Textbox_FindARepository |
      | github.LoginSuccessPO.Image_NotificationIcon  |

  @RegressionTest @TempScenario
  Scenario: Verify "Find a repository..." filter functionality.
    Given user is already logged in using "SampleUserProfile" user profile on "github" application.
    When type "java" text in "github.LoginSuccessPO.Textbox_FindARepository" page element.
    Then verify text part of each element of "github.LoginSuccessPO.List_Repositories" page element matches "java" text where TextMatchMechanism="contains-expected-value".


      
