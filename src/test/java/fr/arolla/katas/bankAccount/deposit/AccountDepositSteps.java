package fr.arolla.katas.bankAccount.deposit;

import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.arolla.katas.bankAccount.Account;

public class AccountDepositSteps {
	private Account userAccount;
	
	@Given("^the account balance of the user is (\\d+) euros$")
	public void initializeAccount(final int initialBalance) {
		userAccount = new Account(initialBalance);
	}
 
	@When("^the user makes a deposit of (\\d+) euros$")
	public void makeDeposit(final int depositAmount) {
		userAccount.doDeposit(depositAmount);
	}
 
	@Then("^the account balance of the user should be (\\d+) euros$")
	public void verifyFinalBalance(final int expectedFinalBalance) {
		assertEquals(expectedFinalBalance, userAccount.getBalance());
	}
}
