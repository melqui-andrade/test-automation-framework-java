package com.melqui.portfolio.ui.steps.definitions;

import com.melqui.portfolio.ui.data.LoginCredential;
import com.melqui.portfolio.ui.data.LoginDataSet;
import com.melqui.portfolio.ui.data.TestDataLoader;
import com.melqui.portfolio.ui.steps.AuthenticationActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepDefinitions {

    private static final LoginDataSet LOGIN_DATA =
        TestDataLoader.load("test-data/login-data.json", LoginDataSet.class);

    @Steps
    AuthenticationActions authenticationActions;

    private LoginCredential selectedCredential;

    @Given("the practice login page is opened")
    public void thePracticeLoginPageIsOpened() {
        authenticationActions.openLoginPage();
    }

    @When("the user logs in with the {string} credentials")
    public void theUserLogsInWithTheCredentials(String credentialKey) {
        selectedCredential = credentialFor(credentialKey);
        authenticationActions.loginWith(selectedCredential);
    }

    @Then("the secure area should be displayed")
    public void theSecureAreaShouldBeDisplayed() {
        assertThat(authenticationActions.successHeading()).isEqualTo(selectedCredential.getExpectedHeading());
    }

    @Then("the logout action should be available")
    public void theLogoutActionShouldBeAvailable() {
        assertThat(authenticationActions.logoutIsVisible()).isTrue();
    }

    @Then("an authentication error should be displayed")
    public void anAuthenticationErrorShouldBeDisplayed() {
        assertThat(authenticationActions.invalidCredentialsMessage()).contains(selectedCredential.getExpectedError());
    }

    private LoginCredential credentialFor(String credentialKey) {
        return switch (credentialKey) {
            case "validUser" -> LOGIN_DATA.getValidUser();
            case "invalidPasswordUser" -> LOGIN_DATA.getInvalidPasswordUser();
            default -> throw new IllegalArgumentException("Unknown credential key: " + credentialKey);
        };
    }
}
