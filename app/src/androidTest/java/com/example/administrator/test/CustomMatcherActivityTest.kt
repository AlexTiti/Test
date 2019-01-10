package com.example.administrator.test


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

/**
 * @author : Alex
 * @version : V 2.0.2
 * @date : 2018/11/09
 */
@LargeTest
class CustomMatcherActivityTest{

    @Rule
    @JvmField
    val activity  =  ActivityTestRule<CustomMatcherActivity>(CustomMatcherActivity::class.java)


    @Test
    fun testHint(){
        onView(withId(R.id.et_phone_hint))
            .check(matches(EditHasHint.hint("111222333")))

        onView(withId(R.id.btn_edit_phone))
            .perform(click())

        onView(withId(R.id.et_phone_hint))
            .check(matches(EditHasHint.hasHintEqualsText("123456789")))
    }


}