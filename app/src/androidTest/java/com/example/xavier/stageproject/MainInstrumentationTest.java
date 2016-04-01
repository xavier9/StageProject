package com.example.xavier.stageproject;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.AndroidJUnitRunner;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainInstrumentationTest
        extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainInstrumentationTest(Class<MainActivity> activityClass) {
        super(activityClass);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        // Injecting the Instrumentation instance is required
        // for your test to run with AndroidJUnitRunner.
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());

    }

    @Test
    public void typeOperandsAndPerformAddOperation() {
        // Call the CalculatorActivity add() method and pass in some operand values, then
        // check that the expected value is returned.
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}