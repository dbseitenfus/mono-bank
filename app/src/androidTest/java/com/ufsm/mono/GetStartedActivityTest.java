package com.ufsm.mono;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.accessibility.AccessibilityChecks;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.junit.Rule;
import org.junit.Test;

public class GetStartedActivityTest extends TestCase {

    @Rule
    public ActivityTestRule activity = new ActivityTestRule(GetStartedActivity.class, true, true);

    @Test
    public void testGeneral() {
        activity.launchActivity(new Intent());

        testGetStartedScreen();
        testLoginScreen();
        testMainActivity();
    }

    public void testGetStartedScreen(){
        if(activity.getActivity() == null) activity.launchActivity(new Intent());

        //GetStarted Screen
        onView(withText("Gaste mais inteligente\nEconomize mais")).check(matches(isDisplayed()));
        onView(withId(R.id.containedButton)).check(matches(isDisplayed()));
        onView(withId(R.id.containedButton)).check(matches(isClickable()));
        onView(withId(R.id.containedButton)).perform(click());
    }

    public void testLoginScreen(){
        onView(withText("Faça login em sua conta")).check(matches(isDisplayed()));
        onView(withId(R.id.textInputLayoutPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.textInputLayoutEmailAddress)).check(matches(isDisplayed()));
        onView(withId(R.id.signInButton)).check(matches(isClickable()));

        //Form
        onView(withId(R.id.editTextTextEmailAddress)).perform(typeText("dseitenfus@gmail.com"));
        onView(withId(R.id.signInButton)).perform(click());

        //Error
        onView(withText("Informe sua senha")).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTextEmailAddress)).perform(clearText());
        onView(withId(R.id.signInButton)).perform(click());

        onView(withId(R.id.editTextTextEmailAddress)).perform(typeText("dseitenfus@gmail.com"));
        onView(withId(R.id.editTextPassword)).perform(typeText("senha123456"));

        onView(withId(R.id.signInButton)).perform(click());
    }

    public void testMainActivity(){
        onView(withId(R.id.button2MainActivity)).perform(click());
        onView(withId(R.id.button3AnalyticsActivity)).perform(click());
    }

}