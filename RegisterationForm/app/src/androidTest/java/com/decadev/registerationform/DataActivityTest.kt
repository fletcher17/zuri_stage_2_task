package com.decadev.registerationform

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DataActivityTest {

    @get:Rule
    val activityScenario = ActivityScenarioRule(DataActivity::class.java)

    @Test
    fun test_isActivity_visible() {
        onView(withId(R.id.dataActivity_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isImage_visible() {
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isData_description_visible() {
        onView(withId(R.id.userNameHolder)).check(matches(isDisplayed()))

        onView(withId(R.id.activity_data_phoneNumber_textView_holder)).check(matches(isDisplayed()))

        onView(withId(R.id.emailHolder)).check(matches(isDisplayed()))

        onView(withId(R.id.genderHolder)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isData_displayedVisible() {
        onView(withId(R.id.imageView)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.imageView2)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.imageView3)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        onView(withId(R.id.userName_textView)).check(matches(isDisplayed()))

        onView(withId(R.id.activity_data_phoneNumber_textView_value)).check(matches(isDisplayed()))

        onView(withId(R.id.email_textView1)).check(matches(isDisplayed()))

        onView(withId(R.id.gender_textView)).check(matches(isDisplayed()))
    }

    @Test
    fun test_doesButton_navigateTo_mainActivity() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        pressBack()
        onView(withId(R.id.main_linearLayout)).check(matches(isDisplayed()))

    }
}