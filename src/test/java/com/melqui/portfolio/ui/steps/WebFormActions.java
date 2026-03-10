package com.melqui.portfolio.ui.steps;

import com.melqui.portfolio.ui.data.WebFormScenarioData;
import com.melqui.portfolio.ui.pages.SeleniumWebFormPage;
import net.serenitybdd.annotations.Step;

public class WebFormActions {

    SeleniumWebFormPage seleniumWebFormPage;
    private boolean checkboxSelectedBeforeSubmit;

    @Step("Open the Selenium demo web form")
    public void openFormPage() {
        seleniumWebFormPage.openFormPage();
    }

    @Step("Submit the web form with the provided dataset")
    public void submitFormWith(WebFormScenarioData data) {
        seleniumWebFormPage.fillMandatoryFields(data.getText(), data.getPassword(), data.getNotes());
        seleniumWebFormPage.selectOption(data.getDropdownOption());
        seleniumWebFormPage.enableCheckbox();
        checkboxSelectedBeforeSubmit = seleniumWebFormPage.isCheckboxSelected();
        seleniumWebFormPage.submitForm();
    }

    @Step("Check whether the checkbox is selected")
    public boolean checkboxIsSelected() {
        return checkboxSelectedBeforeSubmit;
    }

    @Step("Read the form confirmation message")
    public String confirmationMessage() {
        return seleniumWebFormPage.confirmationMessage();
    }
}
