package uk.co.paulmoser.samples.maven.jbehaveselenium;

import org.jbehave.scenario.steps.Steps;
import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.annotations.Then;

import org.jbehave.web.selenium.SeleniumSteps;
import org.jbehave.web.selenium.SeleniumStepsConfiguration;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/** 
 *
 * Steps that are specific to Google. Allows us to write more focused steps in
 * our scenarios
 *
 *  Note: I don't know if there is a better way of calling the SeleniumSteps 
 *  other than passing an instance in.
 */
public class GoogleSteps extends SeleniumSteps {

  private String pageLoadTimeout = "3000";

  /**
   *
   */
  public GoogleSteps(SeleniumStepsConfiguration configuration) {
    super(configuration);
  }

  @Given("we are on the Google homepage")
  public void goToTheGoogleHomepage() {
 //   selenium.open("http://www.google.com/");
    selenium.open("/");
    waitForPageToLoad();
  }

  @When("we search for \"$searchString\"")
  public void searchFor(String searchString) {
    selenium.type("q", searchString);
    selenium.click("btnG");
    waitForPageToLoad();
  }

  @Then("we should see \"$expectedString\"")
  public void weShouldSee(String expectedString) {
    waitFor(5);
    assertThat(selenium.isTextPresent(expectedString), is(true));
  }

  private void waitForPageToLoad() {
    selenium.waitForPageToLoad(pageLoadTimeout);
  }
}
