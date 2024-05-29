Feature: The user can change their own password
  Rule: As a user
  I want to be able to change my own password within the guidelines of password policy
  So that the integrity of my account security requirements are met.

    Scenario: Change password successfully
      Given I am logged in as a user with username "user123" and password "oldPassword123"
      When I navigate to the password change page
      And I enter the current password "oldPassword123"
      And I enter the new password "newPassword123"
      And I confirm the new password "newPassword123"
      And I submit the change password form
      Then I should see a password change success message

    Scenario: Password change fails due to weak password
      Given I am logged in as a user with username "user123" and password "oldPassword123"
      When I navigate to the password change page
      And I enter the current password "oldPassword123"
      And I enter the new password "weak"
      And I confirm the new password "weak"
      And I submit the change password form
      Then I should see a password change error message indicating the password is too weak

    Scenario: Password change fails due to mismatched new passwords
      Given I am logged in as a user with username "user123" and password "oldPassword123"
      When I navigate to the password change page
      And I enter the current password "oldPassword123"
      And I enter the new password "newPassword123"
      And I confirm the new password "newPassword124"
      And I submit the change password form
      Then I should see a password change error message indicating the passwords do not match