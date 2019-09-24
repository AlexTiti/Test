package com.example.administrator.test



import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author : Alex
 * @version : V 2.0.2
 * @date : 2018/11/07
 */

@RunWith(AndroidJUnit4::class)
class RecycleViewActivityTest {

    @Before
    fun launch() {
        ActivityScenario.launch(RecycleViewActivity::class.java)
    }

    @Test
    fun test() {


//        onView(withId(R.id.recycler)).perform(RecyclerViewActions.actionOnItemAtPosition<>(
//            0, click()
//        ))

    }

}