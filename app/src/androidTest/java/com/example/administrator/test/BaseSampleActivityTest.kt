package com.example.administrator.test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.After

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Alex
 * @date 2019/3/28 下午1:51
 * @email 18238818283@sina.cn
 * @desc ...
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class BaseSampleActivityTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<BaseSampleActivity>(BaseSampleActivity::class.java)

    @Test
    fun testBtnFive(){

        onView(withId(R.id.textView3)).check(matches(withText("TextView")))
        onView(withId(R.id.editText2)).perform(typeText(Companion.pomelos), closeSoftKeyboard())

        onView(withId(R.id.button5)).perform(click())

        onView(withId(R.id.textView3)).check(matches(withText(Companion.pomelos)))
    }

    @Test
    fun textBtnSix(){

        onView(withId(R.id.textView3)).check(matches(withText("TextView")))

        onView(withId(R.id.editText2)).perform(typeText(Companion.pomelos), closeSoftKeyboard())

        onView(withId(R.id.textView3)).check(matches(withText("TextView")))

        onView(withId(R.id.button6)).perform(click())

        onView(withId(R.id.textView4)).check(matches(withText(Companion.pomelos)))

    }

    companion object {
        const val pomelos = "A"
    }


}

