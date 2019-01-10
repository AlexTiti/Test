package com.example.administrator.test.idling

import androidx.test.espresso.IdlingResource
import java.util.concurrent.atomic.AtomicBoolean

/**
 * @author  : Alex
 * @date    : 2018/11/09
 * @version : V 2.0.2
 */
class TestIdlingResource : IdlingResource {

    var callback: IdlingResource.ResourceCallback? = null

    override fun getName() = this.javaClass.name

    val atmoicBoolean = AtomicBoolean(true)  // 此处使用AtomicBoolean保证操作的同步问题

    /**
     * 此处返回的boolean值，和调用onTransitionToIdle()状态时一致，检查
     */
    override fun isIdleNow(): Boolean {
        return atmoicBoolean.get()
    }

    /**
     * 保存注册的IdlingResource.ResourceCallback
     */
    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        this.callback = callback
    }


    fun setBoolean(b: Boolean) {

        atmoicBoolean.set(b)
        if (b) {
            callback?.onTransitionToIdle()  // 在线程处于空闲状态（即加载完成后）调用onTransitionToIdle()
        }

    }

}