package fr.arolla.katas.bankAccount.deposit;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:account_deposit.feature")
public class AccountDepositTest {
}
