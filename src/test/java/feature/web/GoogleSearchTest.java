package feature.web;
 
import org.junit.runner.RunWith;
 
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		plugin = {
		"pretty",
		"json:target_json/cucumber.json",
		"junit:taget_junit/cucumber.xml"
		})
public class GoogleSearchTest {
}