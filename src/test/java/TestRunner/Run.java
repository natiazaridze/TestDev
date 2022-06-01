package TestRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (features = "src/test/resources/firstTest.feature",
                glue = {"StepDefinitions"},
                tags = "@Authentication" ,
                plugin = {"summary", "pretty", "html:target/cucumber-reports.html",
                "json:target/cucumber-reports"},
                monochrome = true
        )
public class Run {
}
