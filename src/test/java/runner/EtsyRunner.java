package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com.etsy/etsysearchoutline.feature",
        glue = "steps",
        dryRun = false,
        tags = "@outline"
)
public class EtsyRunner {
}
