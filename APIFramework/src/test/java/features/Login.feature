Feature: Applicaton Login

  Scenario: Home page fefault login
    Given User is on NetBanking landing page
    When User login into application with username and password
    Then Cards are displayed

