package com.melqui.portfolio.ui.steps;

import com.melqui.portfolio.ui.data.LoginCredential;
import com.melqui.portfolio.ui.pages.PracticeLoginPage;
import net.serenitybdd.annotations.Step;

public class AuthenticationActions {

    PracticeLoginPage practiceLoginPage;

    @Step("Open the practice login page")
    public void openLoginPage() {
        practiceLoginPage.openLoginPage();
    }

    @Step("Login with user {0}")
    public void loginWith(LoginCredential credential) {
        practiceLoginPage.loginWith(credential.getUsername(), credential.getPassword());
    }

    @Step("Read the success heading")
    public String successHeading() {
        return practiceLoginPage.successHeading();
    }

    @Step("Verify that logout action is visible")
    public boolean logoutIsVisible() {
        return practiceLoginPage.isLogoutVisible();
    }

    @Step("Read invalid credentials message")
    public String invalidCredentialsMessage() {
        return practiceLoginPage.invalidCredentialsMessage();
    }
}
