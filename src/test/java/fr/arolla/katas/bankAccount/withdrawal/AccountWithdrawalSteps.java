package fr.arolla.katas.bankAccount.withdrawal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.arolla.katas.bankAccount.Account;
import fr.arolla.katas.bankAccount.Money;
import fr.arolla.katas.bankAccount.exceptions.InvalidOperationException;

public class AccountWithdrawalSteps {
	private Account userAccount;
	private boolean withdrawalExecutedCorrectly;
	
	@Given("^the account balance of the user is (\\d+) euros$")
	public void initializeAccount(final int initialBalanceInEuros) {
		Money initialBalance = new Money(initialBalanceInEuros);
		userAccount = new Account(initialBalance);
	}
 
	@When("^the user makes a withdrawal of (\\d+) euros$")
	public void makeWithdrawal(final int withdrawalAmountInEuros) {
		Money withdrawalAmount = new Money(withdrawalAmountInEuros);
		withdrawalExecutedCorrectly = true;
		
		try {
			userAccount.doWithdrawal(withdrawalAmount);
		} catch (InvalidOperationException e) {
			withdrawalExecutedCorrectly = false;
		}
	}
 
	@Then("^the account balance of the user should be (\\d+) euros$")
	public void verifyFinalBalance(final int expectedFinalBalanceInEuros) {
		Money expectedFinalBalance = new Money(expectedFinalBalanceInEuros);
		assertEquals(expectedFinalBalance, userAccount.getBalance());
	}
	
	@Then("^the operation should be denied$")
	public void verifyOperationDenied() {
		assertFalse(withdrawalExecutedCorrectly);
	}

}
