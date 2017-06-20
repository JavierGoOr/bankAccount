Feature: Operation History

As a bank client
I want to see the history (operation, date, amount, balance) of my operations
In order to check my operations

Scenario: First deposit for an account
    Given the account of the user has never been used
    When the user makes a deposit of 1000 euros
    Then the history of user operations should be:
      | type    | amount | accountBalanceAfterOperation |
      | DEPOSIT | 1000   | 1000                         |
      
Scenario: Deposit and withdrawal correctly executed
    Given the account of the user has never been used
    When the user makes a deposit of 1000 euros
    And the user makes a withdrawal of 100 euros
    And the user makes a withdrawal of 200 euros
    Then the history of user operations should be:
      | type       | amount | accountBalanceAfterOperation |
      | DEPOSIT    | 1000   | 1000                         |
      | WITHDRAWAL | 100    | 900                          |
      | WITHDRAWAL | 200    | 700                          |
      
Scenario: Two deposits and incorrect withdrawal
    Given the account of the user has never been used
    When the user makes a deposit of 1000 euros
    And the user makes a deposit of 2000 euros
    And the user makes a withdrawal of 4000 euros
    Then the history of user operations should be:
      | type       | amount | accountBalanceAfterOperation |
      | DEPOSIT    | 1000   | 1000                         |
      | DEPOSIT    | 2000   | 3000                         |