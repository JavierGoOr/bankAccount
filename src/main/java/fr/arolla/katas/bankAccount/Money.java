package fr.arolla.katas.bankAccount;

import fr.arolla.katas.bankAccount.exceptions.InvalidOperationException;

//for simplicity, only amounts in euros will be used in this kata
public class Money {
	private int amountInEuros;
	
	public Money(int initialAmountInEuros){
		amountInEuros = initialAmountInEuros;
	}
	
	public int getAmountInEuros() {
		return amountInEuros;
	}

	public void addAmount(final Money amountToBeAdded){
		amountInEuros += amountToBeAdded.amountInEuros;
	}
	
	public void substractAmount(final Money amountToBeSubstracted) throws InvalidOperationException {
		if (amountInEuros < amountToBeSubstracted.amountInEuros) {
			throw new InvalidOperationException();
		}
		amountInEuros -= amountToBeSubstracted.amountInEuros;
	}
	
	@Override
	public boolean equals(Object objectToBeCompared) {
		if(!(objectToBeCompared instanceof Money)){
			return false;
		}
		
		Money moneyToBeCompared = (Money) objectToBeCompared;
		return amountInEuros == moneyToBeCompared.amountInEuros;
	}
	
	@Override
	public int hashCode() {
		String amountInEurosString = Integer.toString(amountInEuros);
		return amountInEurosString.hashCode();
	}
	
	@Override
	public String toString(){
		return amountInEuros + " euros";
	}
}
