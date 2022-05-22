package Runner;

import org.junit.runner.RunWith;

import io.cucumber.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles/FeatureTodolist.feature" , glue="Stepdefinition",
plugin= {"pretty", "html:target/cucumber-reports/report.html"},
monochrome= true 
)


public class AllItemTodolist {

}
