package fr.arolla.katas.bankAccount;

import java.util.ArrayList;
import java.util.List;

import fr.arolla.katas.bankAccount.exceptions.InvalidOperationException;

public class Account {
	private int balance;
	private List<Operation> pastOperations;
	
	public Account(int initialBalance) {
		balance = initialBalance;
		pastOperations = new ArrayList<Operation>();
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void doDeposit(int depositAmount) {
		balance += depositAmount;
		
		Operation currentOperationDescription = new Operation(Operation.Type.DEPOSIT,
				depositAmount, balance);
		pastOperations.add(currentOperationDescription);
	}
	
	public void doWithdrawal(int withdrawalAmount) throws InvalidOperationException {
		if(withdrawalAmount > balance){
			throw new InvalidOperationException();
		}
		balance -= withdrawalAmount;
		
		Operation currentOperationDescription = new Operation(Operation.Type.WITHDRAWAL,
				withdrawalAmount, balance);
		pastOperations.add(currentOperationDescription);
	}

	public List<Operation> getPastOperations() {
		return pastOperations;
	}
}
