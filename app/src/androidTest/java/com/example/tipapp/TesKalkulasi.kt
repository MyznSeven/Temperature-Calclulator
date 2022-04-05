package com.example.tipapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TesKalkulasi {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun kalkulasi() {
        onView(withId(R.id.input_suhu_edit_text)).perform(typeText("50"))
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("50"))))

        onView(withId(R.id.kelvin2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("324"))))

        onView(withId(R.id.farenheit2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("122"))))

        onView(withId(R.id.reamur2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("40"))))

        onView(withId(R.id.kelvin1)).perform(click())
        onView(withId(R.id.celcius2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("-223"))))

        onView(withId(R.id.farenheit2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("-369"))))

        onView(withId(R.id.kelvin2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("50"))))

        onView(withId(R.id.reamur2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("-178"))))

        onView(withId(R.id.farenheit1)).perform(click())
        onView(withId(R.id.farenheit2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("50"))))

        onView(withId(R.id.celcius2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("10"))))

        onView(withId(R.id.kelvin2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("284"))))

        onView(withId(R.id.reamur2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("8"))))

        onView(withId(R.id.reamur1)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("50"))))

        onView(withId(R.id.celcius2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("63"))))

        onView(withId(R.id.farenheit2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("145"))))

        onView(withId(R.id.kelvin2)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.hasilkalkulasi)).check(matches(withText(containsString("336"))))
    }
}