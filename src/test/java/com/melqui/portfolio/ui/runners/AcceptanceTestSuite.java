package com.melqui.portfolio.ui.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.SNIPPET_TYPE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.melqui.portfolio.ui.steps.definitions")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,net.serenitybdd.cucumber.core.plugin.SerenityReporterParallel")
@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase")
public class AcceptanceTestSuite {
}
