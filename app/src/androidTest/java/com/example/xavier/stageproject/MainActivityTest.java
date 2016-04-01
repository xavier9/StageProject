package com.example.xavier.stageproject;

import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.app.Activity;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.xavier.stageproject.Classes.Message;

import java.util.regex.Matcher;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;


/**
 * Basic tests showcasing simple view matchers and actions like {@link ViewMatchers#withId},
 * {@link ViewActions#click} and {@link ViewActions#typeText}.
 * <p>
 * Note that there is no need to tell Espresso that a view is in a different {@link Activity}.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest{
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);



    @Test
    public void testSwipingThroughViews() {
        // Should be on position 0 to start with.
        onView(withText("Message")).check(matches(isDisplayed()));

        // Swipe left once.
        onView(withId(R.id.pager)).perform(swipeLeft());

        // Now position 1 should be visible.
        onView(withText("Absence")).check(matches(isDisplayed()));

        // Swipe left again.
        onView(withId(R.id.pager)).perform(swipeLeft());

        // Now position 2 should be visible.
        onView(withText("Roster")).check(matches(isDisplayed()));

        // Swipe left again.
        onView(withId(R.id.pager)).perform(swipeLeft());

        // Position 2 should still be visible as this is the last view in the pager.
        onView(withText("Link")).check(matches(isDisplayed()));
    }
    @Test
    public void testSwipingBackAndForward() {
        // Should be on position 0 to start with.
        onView(withText("Message")).check(matches(isDisplayed()));

        // Swipe left once.
        onView(withId(R.id.pager)).perform(swipeLeft());

        // Now position 1 should be visible.
        onView(withText("Absence")).check(matches(isDisplayed()));

        // Swipe back to the right.
        onView(withId(R.id.pager)).perform(swipeRight());

        // Now position 0 should be visible again.
        onView(withText("Message")).check(matches(isDisplayed()));

        // Swipe right again.
        onView(withId(R.id.pager)).perform(swipeRight());

        // Position 0 should still be visible as this is the first view in the pager.
        onView(withText("Message")).check(matches(isDisplayed()));
    }

}