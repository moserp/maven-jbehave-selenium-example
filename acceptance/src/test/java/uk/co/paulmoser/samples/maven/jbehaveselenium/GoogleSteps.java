package uk.co.paulmoser.samples.maven.jbehaveselenium;

import org.jbehave.scenario.steps.Steps;
import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.annotations.Then;

import org.jbehave.web.selenium.SeleniumSteps;
import org.jbehave.web.selenium.SeleniumStepsConfiguration;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.*;
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

  private String pageLoadTimeout = "7000";

  /**
   *
   */
  public GoogleSteps(SeleniumStepsConfiguration configuration) {
    super(configuration);
  }

  @Given("I am on the Google homepage")
  public void goToTheGoogleHomepage() {
    selenium.open("/");
    waitForPageToLoad();
  }

  @When("I search for \"$searchString\"")
  public void searchFor(String searchString) {
    selenium.type("q", searchString);
    selenium.click("btnG");
    waitForPageToLoad();
  }

  @When("I follow the link \"$linkText\"")
  public void followLinkWithText(String linkText) {
    selenium.click("link="+linkText);
    waitForPageToLoad();
  }

  @Then("I should see \"$expectedText\"")
  public void shouldSee(String expectedText) {
    assertThat(selenium.getBodyText(), containsString(expectedText));
  }

  @Then("the URL of the page should be \"$expectedURL\"")
  public void pageURLShouldBe(String expectedURL) {
    assertThat(selenium.getLocation(), is(expectedURL));
  }

  @Then("a screenshot is captured")
  public void captureScreenshot() {
    selenium.captureScreenshot("screenshot.png");
  }

  private void waitForPageToLoad() {
    selenium.waitForPageToLoad(pageLoadTimeout);
  }
}
