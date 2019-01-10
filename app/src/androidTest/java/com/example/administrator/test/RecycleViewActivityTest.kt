package com.example.administrator.test


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.v7.widget.RecyclerView
import android.view.View
import androidx.test.core.app.ActivityScenario

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import javax.annotation.MatchesPattern

/**
 * @author : Alex
 * @version : V 2.0.2
 * @date : 2018/11/07
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class RecycleViewActivityTest{

    @Rule
    @JvmField
    val activity = ActivityTestRule(RecycleViewActivity::class.java)



    @Test
    fun test(){

        onView(withId(R.id.recycler))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<Adapter.ViewHodler>(20,click())
            )
        val text = "AAA 20"
        onView(withText(text)).check(matches(isDisplayed()))

    }

}