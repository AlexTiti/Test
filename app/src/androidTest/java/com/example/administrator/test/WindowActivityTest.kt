package com.example.administrator.test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

/**
 * @author : Alex
 * @version : V 2.0.2
 * @date : 2018/11/09
 */
@LargeTest
class WindowActivityTest{

    @Rule
    @JvmField
    val activity = ActivityTestRule(WindowActivity::class.java)


    @Test
    fun testWindow(){

        onView(withId(R.id.autoText))
            .perform(typeText("So"), closeSoftKeyboard())

        onView(withText(("South China Sea")))
            .inRoot(withDecorView(not(`is`(activity.activity.window.decorView))))
            .check(matches(isDisplayed()))

        onView(withText(("Southern Ocean")))
            .inRoot(withDecorView(not(`is`(activity.activity.window.decorView))))
            .check(matches(isDisplayed()))

    }

}