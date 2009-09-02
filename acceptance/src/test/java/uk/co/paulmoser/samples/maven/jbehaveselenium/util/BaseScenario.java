package uk.co.paulmoser.samples.maven.jbehaveselenium.util;

import org.jbehave.scenario.Scenario;
import org.jbehave.scenario.PropertyBasedConfiguration;
import org.jbehave.scenario.errors.PendingErrorStrategy;
import org.jbehave.scenario.parser.ClasspathScenarioDefiner;
import org.jbehave.scenario.parser.PatternScenarioParser;
import org.jbehave.scenario.parser.UnderscoredCamelCaseResolver;


public abstract class BaseScenario extends Scenario {
  public BaseScenario(final ClassLoader classLoader) {
    super(new PropertyBasedConfiguration() {
      // Faffing around with the classloader seems to be necessary for running with Maven
      @Override
      public ClasspathScenarioDefiner forDefiningScenarios() {
        return new ClasspathScenarioDefiner(new UnderscoredCamelCaseResolver(), new PatternScenarioParser(this),
          classLoader);
      }
      // If you want the build to fail if there are pending steps then you need the following.
      // I wonder if you can set something in the POM rather than having to do it here in code
      /*
      @Override
      public PendingErrorStrategy forPendingSteps() {
        return PendingErrorStrategy.FAILING;
      }
      */
    });

  }
}
