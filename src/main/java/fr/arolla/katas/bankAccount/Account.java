package fr.arolla.katas.bankAccount;

import fr.arolla.katas.bankAccount.exceptions.InvalidOperationException;

public class Account {
	private Money balance;
	private HistoryOfOperations historyOfOperations;

	public Account(Money initialBalance) {
		balance = initialBalance;
		historyOfOperations = new HistoryOfOperations();
	}

	public Money getBalance() {
		return balance;
	}

	public HistoryOfOperations getHistoryOfOperations() {
		return historyOfOperations;
	}

	public void doDeposit(Money depositAmount) {
		balance.addAmount(depositAmount);

		Operation currentOperationDescription = new Operation(Operation.Type.DEPOSIT, depositAmount, balance);
		historyOfOperations.addToHistory(currentOperationDescription);
	}

	public void doWithdrawal(Money withdrawalAmount) throws InvalidOperationException {
		balance.substractAmount(withdrawalAmount);

		Operation currentOperationDescription = new Operation(Operation.Type.WITHDRAWAL, withdrawalAmount, balance);
		historyOfOperations.addToHistory(currentOperationDescription);
	}
}
