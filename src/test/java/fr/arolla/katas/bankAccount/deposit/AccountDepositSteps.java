package fr.arolla.katas.bankAccount.deposit;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.arolla.katas.bankAccount.Account;
import fr.arolla.katas.bankAccount.Money;

public class AccountDepositSteps {
	private Account userAccount;
	
	@Given("^the account balance of the user is (\\d+) euros$")
	public void initializeAccount(final int initialBalanceInEuros) {
		Money initialBalance = new Money(initialBalanceInEuros);
		userAccount = new Account(initialBalance);
	}
 
	@When("^the user makes a deposit of (\\d+) euros$")
	public void makeDeposit(final int depositAmountInEuros) {
		Money depositAmount = new Money(depositAmountInEuros);
		userAccount.doDeposit(depositAmount);
	}
 
	@Then("^the account balance of the user should be (\\d+) euros$")
	public void verifyFinalBalance(final int expectedFinalBalanceInEuros) {
		Money expectedFinalBalance = new Money(expectedFinalBalanceInEuros);
		assertEquals(expectedFinalBalance, userAccount.getBalance());
	}
}
