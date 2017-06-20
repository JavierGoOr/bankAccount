Feature: Account Withdrawal

As a bank client
I want to make a withdrawal from my account
In order to retrieve some or all of my savings
 
  Scenario Outline: Make a withdrawal of an amount within the account balance
    Given the account balance of the user is <initial balance> euros
    When the user makes a withdrawal of <withdrawal amount> euros
    Then the account balance of the user should be <final balance> euros
    
    Examples:
    | initial balance | withdrawal amount | final balance |
    |          100000 |             10000 |         90000 |
    |          100000 |              2000 |         98000 |
    |            5000 |                 0 |          5000 |
    |            5000 |              1111 |          3889 |
    
  Scenario Outline: Make a withdrawal of an amount exceeding the account balance
    Given the account balance of the user is <initial balance> euros
    When the user makes a withdrawal of <withdrawal amount> euros
    Then the operation should be denied
    And the account balance of the user should be <initial balance> euros
    
    Examples:
    | initial balance | withdrawal amount |
    |          100000 |           1000000 |
    |               0 |              2000 |
    |            5000 |             50000 |
    |              10 |              2000 |