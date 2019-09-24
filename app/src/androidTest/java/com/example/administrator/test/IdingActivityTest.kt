package com.example.administrator.test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * @author : Alex
 * @version : V 2.0.2
 * @date : 2018/11/09
 */

@LargeTest
class IdingActivityTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule(IdingActivity::class.java)

    lateinit var idlingResource: IdlingResource

    /**
     * 在执行测试方法之前注册countingIdlingResource
     */
    @Before
    fun testBefore() {
        idlingResource = activity.activity.idingResource
        IdlingRegistry.getInstance().register(idlingResource) //注册countingIdlingResource
    }

    @Test
    fun testGet() {

        onView(withId(R.id.tvShowText))
            .check(matches(withText("TextView")))

        onView(withId(R.id.btnGetText))
            .perform(click())

        onView(withId(R.id.tvShowText))
            .check(matches(withText(textString)))
    }


    /**
     * 在执行测试结束后取消注册countingIdlingResource
     */
    @After
    fun testAfter() {
        IdlingRegistry.getInstance().unregister(idlingResource) // 取消注册countingIdlingResource
    }

}