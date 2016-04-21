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
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

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
    public void testSwipeBetweenFirstAndSecondPage() {
        onView(withText("Messages")).check(matches(isDisplayed()));
        onView(withId(R.id.pager)).perform(swipeLeft());
        onView(withText("Absences")).check(matches(isDisplayed()));
    }

    /**
     * Swipe between the first and second pages and back to the first in the ViewPager.
     */
    @Test
    public void testSwipeBetweenFirstSecondAndBackToFirstPage() {
        onView(withText("Messages")).check(matches(isDisplayed()));
        onView(withId(R.id.pager)).perform(swipeLeft());
        onView(withText("Absences")).check(matches(isDisplayed()));
        onView(withId(R.id.pager)).perform(swipeRight());
        onView(withText("Messages")).check(matches(isDisplayed()));
    }

    /**
     * Swipe to the end of a Fragment
     */
    @Test
    public void testSwipeToTheEnd() {
        onView(withText("Messages")).check(matches(isDisplayed()));
        onView(withId(R.id.pager)).perform(swipeLeft()).perform(swipeLeft()).perform(swipeLeft());
        onView(withText("Links")).check(matches(isDisplayed()));
    }

    /**
     * Swipe to the end of a Fragment and attempt to swipe further
     */
    @Test
    public void testSwipeBeyondTheEnd() {
        onView(withText("Messages")).check(matches(isDisplayed()));
        onView(withId(R.id.pager)).perform(swipeLeft()).perform(swipeLeft()).perform(swipeLeft()).perform(swipeLeft());
        onView(withText("Links")).check(matches(isDisplayed()));
    }



}