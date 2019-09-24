package com.example.administrator.test.unit

import android.content.Context
import com.example.administrator.test.R
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.*
import org.mockito.Mockito.*


/**
 * @author Alex
 * @date 2019/3/27 下午9:18
 * @email 18238818283@sina.cn
 * @desc ...
 */
class AddImplTest {

    @Mock
    var add: AddI? = null // Mock对象

    @Mock
    val list: List<String>? = null


    var callback: Call? = null

    @Captor
    val c: ArgumentCaptor<Callback>? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this) // 注册Mock注解
        callback = Call(add!!)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mether() {
        doAnswer { invocation ->
            (invocation.arguments[0] as Callback).success("Test")
        }.`when`(add)?.syncAnswer(ArgumentMatchers.any(Callback::class.java))
        callback?.test()
        verify(add, times(1))?.syncAnswer(ArgumentMatchers.any(Callback::class.java))
//        add?.syncAnswer(c?.capture())
        assertEquals("Test", callback?.message)
    }

}