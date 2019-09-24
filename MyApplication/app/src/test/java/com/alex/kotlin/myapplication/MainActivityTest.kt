package com.alex.kotlin.myapplication

import android.widget.Button
import android.widget.TextView
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

/**
 * @author Alex
 * @date 2019-09-23 14:43
 * @email 18238818283@sina.cn
 * @desc ...
 */
@RunWith(RobolectricTestRunner::class)
class MainActivityTest{

    @Test
    fun test(){
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        val button = activity.findViewById<Button>(R.id.button)
        val textView = activity.findViewById<TextView>(R.id.textView)
        assertEquals("Hello World!",textView.text)
        button.performClick()
        assertEquals("TEXT",textView.text)
    }

}