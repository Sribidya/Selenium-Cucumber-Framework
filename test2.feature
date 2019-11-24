Feature: Send email
  I want to use this to send email to the company

  Scenario: Send email to Sixty
    Given user is on homepage
    When I provide details on contact tab
    And click subscribe
    Then A mail is sent
