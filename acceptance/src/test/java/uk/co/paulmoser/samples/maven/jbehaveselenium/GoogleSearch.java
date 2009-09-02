package uk.co.paulmoser.samples.maven.jbehaveselenium;

import uk.co.paulmoser.samples.maven.jbehaveselenium.util.BaseScenario;

import org.jbehave.scenario.Scenario;

import org.jbehave.web.selenium.SeleniumStepsConfiguration;
import org.jbehave.web.selenium.SeleniumContext;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class GoogleSearch extends BaseScenario {
  public GoogleSearch(final ClassLoader classLoader) {
    super(classLoader);
    // Add the steps needed for this scenario
    //

    Selenium selenium = new DefaultSelenium("localhost", 4444, "*firefox",
				"http://www.google.com");

    SeleniumStepsConfiguration configuration = new SeleniumStepsConfiguration(selenium, new SeleniumContext());
    addSteps(new GoogleSteps(configuration));
  }
}
