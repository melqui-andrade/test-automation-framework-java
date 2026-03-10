package com.melqui.portfolio.ui.steps.definitions;

import com.melqui.portfolio.ui.data.TestDataLoader;
import com.melqui.portfolio.ui.data.WebFormDataSet;
import com.melqui.portfolio.ui.data.WebFormScenarioData;
import com.melqui.portfolio.ui.steps.WebFormActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class WebFormStepDefinitions {

    private static final WebFormDataSet WEB_FORM_DATA =
        TestDataLoader.load("test-data/web-form-data.json", WebFormDataSet.class);

    @Steps
    WebFormActions webFormActions;

    private WebFormScenarioData selectedData;

    @Given("the Selenium demo web form is opened")
    public void theSeleniumDemoWebFormIsOpened() {
        webFormActions.openFormPage();
    }

    @When("the user submits the form with the {string} data set")
    public void theUserSubmitsTheFormWithTheDataSet(String dataSetKey) {
        selectedData = dataFor(dataSetKey);
        webFormActions.submitFormWith(selectedData);
    }

    @Then("the form submission should be accepted")
    public void theFormSubmissionShouldBeAccepted() {
        assertThat(webFormActions.confirmationMessage()).isEqualTo(selectedData.getConfirmationMessage());
    }

    @Then("the checkbox should remain selected")
    public void theCheckboxShouldRemainSelected() {
        assertThat(webFormActions.checkboxIsSelected()).isTrue();
    }

    private WebFormScenarioData dataFor(String dataSetKey) {
        return switch (dataSetKey) {
            case "defaultSubmission" -> WEB_FORM_DATA.getDefaultSubmission();
            default -> throw new IllegalArgumentException("Unknown form data set: " + dataSetKey);
        };
    }
}
