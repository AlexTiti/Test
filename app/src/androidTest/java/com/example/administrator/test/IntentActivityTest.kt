package com.example.administrator.test

import android.app.Activity.RESULT_OK
import android.app.Instrumentation
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.core.internal.deps.guava.collect.Iterables
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.truth.content.IntentSubject.assertThat
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * @author : Alex
 * @version : V 2.0.2
 * @date : 2018/11/08
 */

/**
 * 此处是AndroidJUnit4
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class IntentActivityTest{

    @Rule
    @JvmField
    val intentsTestRule = IntentsTestRule(IntentActivity::class.java)

    val string  = "123456789"
    val call_data = Uri.parse("tel: $string")


    @Test
    fun testIntent(){

        onView(withId(R.id.editText))
            .perform(
                typeText(string),
                closeSoftKeyboard()
            )

        onView(withId(R.id.button2))
            .perform(click())

        //断言Intent中的元素和数据
        intended(allOf(
            hasAction(Intent.ACTION_CALL),
            hasData(call_data),
            toPackage("com.android.server.telecom")
        ))
    }



    @Test
    fun testAssertIntent(){

        onView(withId(R.id.editText))
            .perform(
                typeText(string),
                closeSoftKeyboard()
            )

        onView(withId(R.id.button2))
            .perform(click())

        //获取创建的Intent
        val receivedIntent = Iterables.getOnlyElement(Intents.getIntents())
        //断言Intent
        assertThat(receivedIntent).hasData(call_data)
        assertThat(receivedIntent).hasAction(Intent.ACTION_CALL)
    }


    @Test
    fun test(){

        val intent = PhoneNumberActivity.createIntent()
        val result = Instrumentation.ActivityResult(RESULT_OK,intent)
        //预设置发送Intent的返回值
        intending(allOf(hasComponent(hasShortClassName(".PhoneNumberActivity"))
        , toPackage("com.example.administrator.test")))
            .respondWith(result)

        onView(withId(R.id.button3))
            .perform(click())

        onView(withId(R.id.editText))
            .check(matches(withText(string)))
    }


    @Before
    fun prepare(){
        val bundle = Bundle()
        bundle.putParcelable("data",BitmapFactory.decodeResource(intentsTestRule.activity.resources,R.drawable.ic_launcher))
        val intent = Intent()
        intent.putExtras(bundle)

        val result = Instrumentation.ActivityResult(RESULT_OK,intent)
        //预设置发送Intent的返回值
        intending(hasAction(MediaStore.ACTION_IMAGE_CAPTURE))
            .respondWith(result)
    }


    @Test
    fun testImageView(){

   onView(withId(R.id.imageView))
    .check(matches(not(ImageHasDrawableMatcher.hasDrawable())))

        onView(withId(R.id.button4))
            .perform(click())

        onView(withId(R.id.imageView))
            .check(matches(ImageHasDrawableMatcher.hasDrawable()))

    }

}