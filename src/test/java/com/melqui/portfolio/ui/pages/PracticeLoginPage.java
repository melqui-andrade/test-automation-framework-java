package com.melqui.portfolio.ui.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class PracticeLoginPage extends PageObject {

    private static final String PAGE_URL = "https://practicetestautomation.com/practice-test-login/";

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By submitButton = By.id("submit");
    private final By successTitle = By.tagName("h1");
    private final By logoutButton = By.linkText("Log out");
    private final By errorMessage = By.id("error");

    public void openLoginPage() {
        openUrl(PAGE_URL);
        $(usernameField).waitUntilVisible();
    }

    public void loginWith(String username, String password) {
        $(usernameField).type(username);
        $(passwordField).type(password);
        $(submitButton).click();
    }

    public String successHeading() {
        return $(successTitle).waitUntilVisible().getText();
    }

    public boolean isLogoutVisible() {
        return $(logoutButton).waitUntilVisible().isVisible();
    }

    public String invalidCredentialsMessage() {
        return $(errorMessage).waitUntilVisible().getText();
    }
}
