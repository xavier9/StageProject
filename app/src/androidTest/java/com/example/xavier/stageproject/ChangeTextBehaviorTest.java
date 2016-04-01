package com.example.xavier.stageproject;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.app.Activity;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Basic tests showcasing simple view matchers and actions like {@link ViewMatchers#withId},
 * {@link ViewActions#click} and {@link ViewActions#typeText}.
 * <p>
 * Note that there is no need to tell Espresso that a view is in a different {@link Activity}.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ChangeTextBehaviorTest {

    public static final String STRING_TO_BE_TYPED = "Espresso";

    /**
     * A JUnit {@link Rule @Rule} to launch your activity under test. This is a replacement
     * for {@link ActivityInstrumentationTestCase2}.
     * <p>
     * Rules are interceptors which are executed for each test method and will run before
     * any of your setup code in the {@link Before @Before} method.
     * <p>
     * {@link ActivityTestRule} will create and launch of the activity for you and also expose
     * the activity under test. To get a reference to the activity you can use
     * the {@link ActivityTestRule#getActivity()} method.
     */
    @Rule
    public ActivityTestRule<LDAPActivety> mActivityRule = new ActivityTestRule<>(
            LDAPActivety.class);

    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.Username))
                .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.Error)).check(matches(withText("Username and password required")));
    }

    @Test
    public void changeText_newActivity() {
        // Type text and then press the button.
        onView(withId(R.id.Username)).perform(typeText(STRING_TO_BE_TYPED),
                closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());

        // This view is in a different Activity, no need to tell Espresso.
        onView(withId(R.id.Error)).check(matches(withText("Username and password required")));
    }
}