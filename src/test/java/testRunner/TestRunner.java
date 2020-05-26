package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
            features = ".//Features/Login.feature",  //to execute specific feature fil

           //features = {".//Features/Customer.feature",".//Features/Login.feature"},//suppose I have 5 features file but need to execute 2 feature files
           //features = ".//Features/", if we want to execute all the features file
           //features = {".//Features/Customer.feature",".//Features/Login.feature"},
           glue = "stepsDefinition",
           dryRun = false,
           monochrome = true,
           plugin = {"pretty","html:test-output"}
        )
public class TestRunner {
}
