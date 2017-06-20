package fr.arolla.katas.bankAccount.operationHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.arolla.katas.bankAccount.Account;
import fr.arolla.katas.bankAccount.HistoryOfOperations;
import fr.arolla.katas.bankAccount.Money;
import fr.arolla.katas.bankAccount.Operation;
import fr.arolla.katas.bankAccount.exceptions.InvalidOperationException;

public class OperationHistorySteps {
	private static final String TYPE = "type";
	private static final String AMOUNT = "amount";
	private static final String ACCOUNT_BALANCE_AFTER_OPERATION = "accountBalanceAfterOperation";
	
	private Account userAccount;

	@Given("^the account of the user has never been used$")
	public void initializeAccount() {
		Money initialAmount = new Money(0);
		userAccount = new Account(initialAmount);
	}

	@When("^the user makes a deposit of (\\d+) euros$")
	public void makeDeposit(final int depositAmountInEuros) {
		Money depositAmount = new Money(depositAmountInEuros);
		userAccount.doDeposit(depositAmount);
	}

	@When("^the user makes a withdrawal of (\\d+) euros$")
	public void makeWithdrawal(final int withdrawalAmountInEuros) {
		Money withdrawalAmount = new Money(withdrawalAmountInEuros);

		try {
			userAccount.doWithdrawal(withdrawalAmount);
		} catch (InvalidOperationException e) {
			// this exception is ignored in this test
		}
	}

	@Then("^the history of user operations should be:$")
	public void verifyHistoryOfOperations(final List<Map<String, String>> expectedOperationsDataTable) {
		List<Operation> expectedOperations = transformListMapToListOperations(expectedOperationsDataTable);

		HistoryOfOperations historyOfOperations = userAccount.getHistoryOfOperations();
		Assert.assertNotNull(historyOfOperations);

		List<Operation> pastOperations = historyOfOperations.getPastOperations();
		Assert.assertNotNull(pastOperations);

		// verify number of operations
		Assert.assertEquals(expectedOperations.size(), pastOperations.size());

		// verify elements of operations
		for (int i = 0; i < expectedOperations.size(); i++) {
			Operation expectedOperation = expectedOperations.get(i);
			Operation actualOperation = pastOperations.get(i);

			Assert.assertEquals(expectedOperation.getType(), actualOperation.getType());
			Assert.assertEquals(expectedOperation.getAmount(), actualOperation.getAmount());
			Assert.assertEquals(expectedOperation.getAccountBalanceAfterOperation(),
					actualOperation.getAccountBalanceAfterOperation());
		}
	}

	private List<Operation> transformListMapToListOperations(final List<Map<String, String>> operationsListMap) {
		Assert.assertNotNull(operationsListMap);
		List<Operation> transformedResult = new ArrayList<Operation>();

		for (Map<String, String> operationsElementsMap : operationsListMap) {
			String operationTypeString = operationsElementsMap.get(TYPE);
			String operationAmountString = operationsElementsMap.get(AMOUNT);
			String operationAccountBalanceString = operationsElementsMap.get(ACCOUNT_BALANCE_AFTER_OPERATION);

			Assert.assertNotNull(operationTypeString);
			Assert.assertNotNull(operationAmountString);
			Assert.assertNotNull(operationAccountBalanceString);

			Operation.Type operationType = Operation.Type.valueOf(operationTypeString);
			int operationAmountInEuros = Integer.parseInt(operationAmountString);
			int operationAccountBalanceInEuros = Integer.parseInt(operationAccountBalanceString);

			Money operationAmount = new Money(operationAmountInEuros);
			Money operationAccountBalance = new Money(operationAccountBalanceInEuros);

			Operation transformedOperation = new Operation(operationType, operationAmount, operationAccountBalance);
			transformedResult.add(transformedOperation);
		}

		return transformedResult;
	}
}
