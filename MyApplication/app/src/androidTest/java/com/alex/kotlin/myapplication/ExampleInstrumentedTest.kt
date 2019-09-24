package com.alex.kotlin.myapplication

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    lateinit var share : ShareUtils

    @Before
    fun setUp(){
        val appContext = InstrumentationRegistry.getTargetContext()
        share = ShareUtils(appContext)
    }

    @Test
    fun useAppContext() {
        share.put("A","AAAA")
        assertEquals("AAAA",share.get("A"))

        share.put("B","BBBB")
        assertEquals("BBBB",share.get("B"))

    }
}
