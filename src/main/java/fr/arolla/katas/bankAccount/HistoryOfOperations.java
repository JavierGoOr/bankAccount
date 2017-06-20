package fr.arolla.katas.bankAccount;

import java.util.ArrayList;
import java.util.List;

public class HistoryOfOperations {
	private List<Operation> pastOperations;
	
	public HistoryOfOperations() {
		pastOperations = new ArrayList<Operation>();
	}
	
	public List<Operation> getPastOperations() {
		return pastOperations;
	}

	public void addToHistory(Operation operationToBeAdded){
		pastOperations.add(operationToBeAdded);
	}
}
