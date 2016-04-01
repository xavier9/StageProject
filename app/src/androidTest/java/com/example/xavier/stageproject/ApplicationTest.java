package com.example.xavier.stageproject;

import android.app.Application;
import android.test.ApplicationTestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Runs all instrumentation tests from one place
 */
@RunWith (Suite.class)
@Suite.SuiteClasses ({
        LDAPActivityTest.class,
        MainActivityTest.class,

})

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
}