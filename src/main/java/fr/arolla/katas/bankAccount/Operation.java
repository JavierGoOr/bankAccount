package fr.arolla.katas.bankAccount;

import java.util.Date;

public class Operation {
	public enum Type {
		DEPOSIT, WITHDRAWAL
	}

	private final Date date;
	private final Type type;
	private final Money amount;
	private final Money accountBalanceAfterOperation;

	public Operation(Type type, Money amount, Money accountBalanceAfterOperation) {
		date = new Date();
		this.type = type;
		this.amount = new Money(amount.getAmountInEuros());
		this.accountBalanceAfterOperation = new Money(accountBalanceAfterOperation.getAmountInEuros());
	}

	public Date getDate() {
		return date;
	}

	public Type getType() {
		return type;
	}

	public Money getAmount() {
		return amount;
	}

	public Money getAccountBalanceAfterOperation() {
		return accountBalanceAfterOperation;
	}

	public String toString() {
		return "Operation: (date: " + date + ", type: " + type + ", amount: " + amount
				+ ", accountBalanceAfterOperation: " + accountBalanceAfterOperation + ")";
	}
}
