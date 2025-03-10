package com.example.counterapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    /*
     * Test case 1: Verifies that clicking the increment button increases the counter value
     * This test ensures that when the user clicks the increment button,
     * the counter text is updated to show the incremented value.
     * We start with the default counter value of 0, click the button once,
     * and expect the counter to display "1".
     */
    @Test
    fun testIncrementButton() {
        // Launch the activity
        ActivityScenario.launch(MainActivity::class.java)

        // Verify initial counter is 0
        onView(withId(R.id.counter_text)).check(matches(withText("0")))

        // Click the increment button
        onView(withId(R.id.increment_button)).perform(click())

        // Verify that counter has been incremented to 1
        onView(withId(R.id.counter_text)).check(matches(withText("1")))
    }

    /*
     * Test case 2: Verifies that clicking the decrement button decreases the counter value
     * This test ensures that when the user clicks the decrement button,
     * the counter text is updated to show the decremented value.
     * We start with the default counter value of 0, click the button once,
     * and expect the counter to display "-1".
     */
    @Test
    fun testDecrementButton() {
        // Launch the activity
        ActivityScenario.launch(MainActivity::class.java)

        // Verify initial counter is 0
        onView(withId(R.id.counter_text)).check(matches(withText("0")))

        // Click the decrement button
        onView(withId(R.id.decrement_button)).perform(click())

        // Verify that counter has been decremented to -1
        onView(withId(R.id.counter_text)).check(matches(withText("-1")))
        }
}
