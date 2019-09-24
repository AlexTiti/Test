package com.example.administrator.test


import android.view.accessibility.AccessibilityNodeInfo
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.allOf
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * @author : Alex
 * @version : V 2.0.2
 * @date : 2018/11/07
 */

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    /**
     * Kotlin中使用   @JvmField注解免除编译问题
     */
    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun test() {
        onView(allOf(
                withText("TextView"),
                hasSibling(withText("Button"))
            )
        ).perform(click())

        onView(withId(R.id.button))
            .check(matches(withText("AAA")))
    }

    @Test
    fun testMenu() {

        onView(withId(R.id.button))
            .check(matches(withText("Button")))

        onView(withId(R.id.click))
            .perform(click())

        onView(withId(R.id.button))
            .check(matches(withText("Menu")))

    }

    @Test
    fun testMenuList() {
        openContextualActionModeOverflowMenu() // 打开Menu菜单
        onView(withText("Search"))
            .perform(click())

        onView(withId(R.id.button))
            .check(matches(withText("Search")))


        openContextualActionModeOverflowMenu()
        onView(withText("Action"))
            .perform(click())

        onView(withId(R.id.button))
            .check(matches(withText("Action")))
    }


}