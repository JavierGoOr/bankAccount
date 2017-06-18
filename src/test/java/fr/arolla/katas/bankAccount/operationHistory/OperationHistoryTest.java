package fr.arolla.katas.bankAccount.operationHistory;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:operation_history.feature")
public class OperationHistoryTest {
}
