package runner.products;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com.products",
        glue = "steps/com/productssteps",
        dryRun = false,
        tags = "@outline"
)

public class ProductsRunner {
}
