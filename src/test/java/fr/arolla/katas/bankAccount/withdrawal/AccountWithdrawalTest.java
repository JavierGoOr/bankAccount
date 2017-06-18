package fr.arolla.katas.bankAccount.withdrawal;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:account_withdrawal.feature")
public class AccountWithdrawalTest {
}
