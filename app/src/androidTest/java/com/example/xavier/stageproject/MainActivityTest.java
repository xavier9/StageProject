package com.example.xavier.stageproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

/**
 * Basic tests showcasing simple view matchers and actions like {@link ViewMatchers#withId},
 * {@link ViewActions#click} and {@link ViewActions#typeText}.
 * <p>
 * Note that there is no need to tell Espresso that a view is in a different {@link Activity}.
 */
@RunWith(AndroidJUnit4.class)
@android.test.suitebuilder.annotation.LargeTest
public class MainActivityTest{

    @Rule
    public final ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<>(MainActivity.class, true, false);
    @Before
    public void init(){
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        Intent intent = new Intent(targetContext, MainActivity.class);
        intent.putExtra("studentid", "47657");
        //intent.putExtra("screen", "3");
        rule.launchActivity(intent);
    }

    @Test
    public void someTest() {
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        Intent intent = new Intent(targetContext, MainActivity.class);
        intent.putExtra("studentid", "47657");
        //intent.putExtra("screen", "3");
        rule.launchActivity(intent);


        /* Your activity is initialized and ready to go. */
    }

    @Test
    public void testSwitchWithId() {
        onView(withId(R.id.tab_layout)).check(matches(not(isChecked())));
        onView(withId(R.id.tab_layout)).perform(click());
        onView(withId(R.id.tab_layout)).check(matches(isChecked()));

    }

    /**
     * Click a switch using its label value.
     * Espresso onView, withText, check, matches, isChecked, perform, not
     */
    @Test
    public void testSwitchWithText() {
        onView(withText("Message")).check(matches(not(isChecked())));
        onView(withText("Absences")).perform(click());
        onView(withText("Absences")).check(matches(isChecked()));
    }

    /**
     * But why do that when you can chain it?
     * A three line test can now be written in a single line.
     * Espresso onView, withText, check, matches, not, isChecked, perform, click
     */
    @Test
    public void testSwitchWithChainingExample() {
        // Start with a ViewInteraction
        onView(withText("Links"))
                // Chain the methods you want to call.
                .check(matches(not(isChecked())))
                .perform(click())
                .check(matches(isChecked()));
    }



}