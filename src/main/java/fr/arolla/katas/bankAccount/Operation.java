package fr.arolla.katas.bankAccount;

import java.util.Date;

public class Operation {
	public enum Type {
	    DEPOSIT, WITHDRAWAL
	}
	
	private Date date;
	private Type type;
	private int amount;
	private int accountBalanceAfterOperation;
	
	public Operation(Type type, int amount, int accountBalanceAfterOperation){
		date = new Date();
		this.type = type;
		this.amount = amount;
		this.accountBalanceAfterOperation = accountBalanceAfterOperation;
	}
	
	public Date getDate() {
		return date;
	}
	public Type getType() {
		return type;
	}
	public int getAmount() {
		return amount;
	}
	public int getAccountBalanceAfterOperation() {
		return accountBalanceAfterOperation;
	}
	
	public String toString() {
		return "Operation: (date: " + date + 
				", type: " + type + 
				", amount: " + amount +
				", accountBalanceAfterOperation: " + accountBalanceAfterOperation + ")";
	}
}
