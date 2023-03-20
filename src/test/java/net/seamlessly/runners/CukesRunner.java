package net.seamlessly.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/cucumber-reports.html",
				  "json:target/cucumber.json",
				  "rerun:target/rerun.txt",
				  "me.jvt.cucumber.report.PrettyReports:target/cucumber"},
		features = "src/test/resources/features",
		glue = "net/seamlessly/step_definitions",
		publish = false,
		dryRun = false,
		tags = "@wipp"
)

 public class CukesRunner {
}
