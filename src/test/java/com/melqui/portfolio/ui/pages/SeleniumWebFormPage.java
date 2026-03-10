package com.melqui.portfolio.ui.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SeleniumWebFormPage extends PageObject {

    private static final String PAGE_URL = "https://www.selenium.dev/selenium/web/web-form.html";

    private final By textField = By.name("my-text");
    private final By passwordField = By.name("my-password");
    private final By textArea = By.name("my-textarea");
    private final By dropdown = By.name("my-select");
    private final By checkbox = By.id("my-check-1");
    private final By submitButton = By.cssSelector("button");
    private final By confirmationMessage = By.id("message");

    public void openFormPage() {
        openUrl(PAGE_URL);
        $(textField).waitUntilVisible();
    }

    public void fillMandatoryFields(String text, String password, String notes) {
        $(textField).type(text);
        $(passwordField).type(password);
        $(textArea).type(notes);
    }

    public void selectOption(String optionLabel) {
        new Select($(dropdown).waitUntilVisible()).selectByVisibleText(optionLabel);
    }

    public void enableCheckbox() {
        if (!$(checkbox).isSelected()) {
            $(checkbox).click();
        }
    }

    public boolean isCheckboxSelected() {
        return $(checkbox).waitUntilVisible().isSelected();
    }

    public void submitForm() {
        $(submitButton).waitUntilClickable().click();
    }

    public String confirmationMessage() {
        return $(confirmationMessage).waitUntilVisible().getText();
    }
}
