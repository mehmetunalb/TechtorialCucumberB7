package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com.weborder","src/test/resources/com.ebay"}, // full path from content root
        glue = "steps/com",
        // we use this to catch any unimplemented step in feature file before launching the webpage dryRun
        dryRun = false
)

public class cukesRunner {


}
