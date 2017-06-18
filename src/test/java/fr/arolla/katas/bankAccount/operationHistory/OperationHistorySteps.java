package fr.arolla.katas.bankAccount.operationHistory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.arolla.katas.bankAccount.Account;
import fr.arolla.katas.bankAccount.Operation;
import fr.arolla.katas.bankAccount.exceptions.InvalidOperationException;

public class OperationHistorySteps {
	private Account userAccount;
	private boolean withdrawalExecutedCorrectly;
	
	@Given("^the account of the user has never been used$")
	public void initializeAccount() {
		userAccount = new Account(0);
	}
	
	@When("^the user makes a deposit of (\\d+) euros$")
	public void makeDeposit(final int depositAmount) {
		userAccount.doDeposit(depositAmount);
	}
	
	@When("^the user makes a withdrawal of (\\d+) euros$")
	public void makeWithdrawal(final int withdrawalAmount) {
		withdrawalExecutedCorrectly = true;
		
		try {
			userAccount.doWithdrawal(withdrawalAmount);
		} catch (InvalidOperationException e) {
			withdrawalExecutedCorrectly = false;
		}
	}
	
	@Then("^a withdrawal should have been denied$")
	public void verifyOperationDenied() {
		assertFalse(withdrawalExecutedCorrectly);
	}
	
	@Then("^account balance should be (\\d+) euros$")
	public void verifyFinalBalance(final int expectedFinalBalance) {
		assertEquals(expectedFinalBalance, userAccount.getBalance());
	}
	
	@Then("^the history of user operations should be:$")
	public void verifyFinalBalance(final List<Operation> expectedOperations) {
		//verify number of operations
		Assert.assertNotNull(userAccount.getPastOperations());
		Assert.assertEquals(expectedOperations.size(), userAccount.getPastOperations().size());
		
		//verify elements of operations
		for(int i = 0; i < expectedOperations.size(); i++){
			Operation expectedOperation = expectedOperations.get(i);
			Operation actualOperation = userAccount.getPastOperations().get(i);
			
			Assert.assertEquals(expectedOperation.getType(), actualOperation.getType());
			Assert.assertEquals(expectedOperation.getAmount(), actualOperation.getAmount());
			Assert.assertEquals(expectedOperation.getAccountBalanceAfterOperation(), actualOperation.getAccountBalanceAfterOperation());
		}
	}
}
