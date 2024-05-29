package glue;

import utils.Account;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Transaction;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AccountSteps {

    Account account = null;

    @Given("^Account exists for Acc No\\. \"([^\"]*)\" with Name \"([^\"]*)\"$")
    public void accountExistsForAccNoWithName(String number, String name) {
        account = new Account(number, name);
    }

    @Given("^deposits are made$")
    public void depositsAreMade(DataTable dataTable) {
        List<Map<String, String>> transactions = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> transaction : transactions) {
            String type = transaction.get("type");
            double amount = Double.parseDouble(transaction.get("amount"));
            account.deposit(new Transaction(type, amount));
        }
    }

    @Given("^withdrawals are made$")
    public void withdrawalsAreMade(DataTable dataTable) {
        List<Map<String, String>> transactions = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> transaction : transactions) {
            String type = transaction.get("type");
            double amount = Double.parseDouble(transaction.get("amount"));
            account.withdraw(new Transaction(type, amount));
        }
    }

    @When("^statement is produced$")
    public void statementIsProduced() {
        account.produceStatement();
    }

    @Then("^statement includes \"([^\"]*)\"$")
    public void statementIncludes(String expectedText) {
        assertTrue(account.getStatement().contains(expectedText));
    }
}