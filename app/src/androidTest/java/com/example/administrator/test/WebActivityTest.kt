package com.example.administrator.test

import android.content.Intent
import androidx.test.espresso.web.assertion.WebViewAssertions.webMatches
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms.*
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers.containsString
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author : Alex
 * @version : V 2.0.2
 * @date : 2018/11/09
 */

@LargeTest
@RunWith(AndroidJUnit4::class)
class WebActivityTest {

    val url = "file:///android_asset/web_form.html"

    @Rule
    @JvmField
    val activity = ActivityTestRule(WebActivity::class.java)


    @Test
    fun testWeb() {

        activity.launchActivity(getIntent())

        onWebView()
            .withElement(findElement(Locator.ID, "text_input"))
            .perform(clearElement())
            .perform(webKeys("AAAAA"))
            .withElement(findElement(Locator.ID, "changeTextBtn"))
            .perform(webClick())
            .withElement(findElement(Locator.ID, "message"))
            .check(webMatches(getText(), containsString("AAAAA")))

    }


    @Test
    fun testSubmit() {

        activity.launchActivity(getIntent())

        onWebView().withElement(findElement(Locator.ID, "text_input"))
            .perform(clearElement())
            .perform(webKeys("Web View"))
            .withElement(findElement(Locator.ID, "submitBtn"))
            .perform(webClick())
            .withElement(findElement(Locator.ID, "response"))
            .check(webMatches(getText(), containsString("Web View")))

    }

    fun getIntent(): Intent {
        val intent = Intent()
        intent.putExtra("url", url)
        return intent
    }

}