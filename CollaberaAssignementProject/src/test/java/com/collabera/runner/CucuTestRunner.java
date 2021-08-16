package com.collabera.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
                 glue = {"com/collabera/definations","com/collabera/hooks"},
                 plugin= {"pretty",
         				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        				"timeline:test-output-thread/"},
                 monochrome = true,
                 publish =true,
                 dryRun=false
                 )
public class CucuTestRunner {

}
