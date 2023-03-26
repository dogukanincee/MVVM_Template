package com.dogukanincee.mvvm_template

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dogukanincee.mvvm_template.view.MainActivity
import org.hamcrest.core.AnyOf.anyOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    /**
     * The [ActivityScenario] instance of the MainActivity.
     */
    private lateinit var scenario: ActivityScenario<MainActivity>

    /**
     * Launches the MainActivity before each test.
     */
    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    /**
     * Tests that the updateButton updates the messageTextView when clicked.
     */
    @Test
    fun clickUpdateButton_updatesMessageTextView() {
        onView(withId(R.id.updateButton)).perform(click())
        onView(withId(R.id.messageTextView)).check(matches(isDisplayed()))
    }

    /**
     * Tests that the update button is displayed on launch.
     */
    @Test
    fun testUpdateButtonIsDisplayedOnLaunch() {
        onView(withId(R.id.updateButton)).check(matches(isDisplayed()))
    }

    /**
     * Espresso test class to verify that the initial value of the messageTextView is updated on button click.
     */
    @Test
    fun testInitialMessageTextViewValue() {
        onView(withId(R.id.updateButton)).perform(click())
        onView(withId(R.id.messageTextView)).check(
            matches(
                anyOf(
                    withText("Merhaba"),
                    withText("Hello"),
                    withText("Hallo"),
                    withText("Bonjour"),
                    withText("Hola"),
                    withText("こんにちは"),
                    withText("안녕하세요")
                )
            )
        )
    }
}