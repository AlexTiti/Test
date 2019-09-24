package com.alex.kotlin.myapplication

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(application = App::class)
class ExampleUnitTest {

    lateinit var shareUtils: ShareUtils

    @Before
    fun setUp(){
        shareUtils = ShareUtils(RuntimeEnvironment.application)
    }

    @Test
    fun addition_isCorrect() {
        shareUtils.put("C","AAAA")
        assertEquals("AAAA",shareUtils.get("C"))

        shareUtils.put("D","BBBB")
        assertEquals("BBBB",shareUtils.get("D"))
    }
}
