Feature: Account Deposit

As a bank client
I want to make a deposit in my account
In order to save money
 
  Scenario Outline: Make a deposit
    Given the account balance of the user is <initial balance> euros
    When the user makes a deposit of <deposit amount> euros
    Then the account balance of the user should be <final balance> euros
    
    Examples:
    | initial balance | deposit amount | final balance |
    |               0 |          26500 |         26500 |
    |           26500 |              0 |         26500 |
    |             100 |            200 |           300 |
    |             200 |            300 |           500 |
    |             150 |            150 |           300 |
    |            1234 |           4321 |          5555 |