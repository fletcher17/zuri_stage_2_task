package com.decadev.registerationform

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.CoreMatchers.containsString
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    companion object {
        private const val USERNAME = "Olufemi"
        private const val PHONENUMBER = "08134742336"
        private const val EMAIL = "ezekielOlufemi09@yahoo.com"
        private const val GENDER = "Female"

    }

    @Test
    fun test_isActivity_visible() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.main_linearLayout)).check(matches(isDisplayed()))
    }


    @Test
    fun test_isTextTitleVisible() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.registeration_textView)).check(matches(isDisplayed()))

        onView(withId(R.id.registeration_textView)).check(matches(withText(R.string.registeration_textView)))
    }

    @Test
    fun test_isTextInput_visible() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.name_form)).check(matches(isDisplayed()))

        onView(withId(R.id.phoneno_textView1)).check(matches(isDisplayed()))

        onView(withId(R.id.email_textView1)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isButton_visible() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.submit_button)).check(matches(isDisplayed()))
    }

    @Test
    fun test_doesButton_navigateTo_secondActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.name_form)).perform(replaceText(USERNAME))
        onView(withId(R.id.phoneno_textView1)).perform(replaceText(PHONENUMBER))
        onView(withId(R.id.email_textView1)).perform(replaceText(EMAIL))

        onView(withId(R.id.gender_textView)).perform(click())
        onData(anything()).atPosition(2).perform(click())
        onView(withId(R.id.gender_textView)).check(matches(withSpinnerText(containsString(GENDER))))


        onView(withId(R.id.submit_button)).perform(click())

        onView(withId(R.id.dataActivity_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isSpinner_visible() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.gender_textView)).check(matches(isDisplayed()))
    }
}