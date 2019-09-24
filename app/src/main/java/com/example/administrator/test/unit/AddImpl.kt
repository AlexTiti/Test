package com.example.administrator.test.unit

import android.util.Log

/**
 * @author Alex
 * @date 2019/3/27 下午9:16
 * @email 18238818283@sina.cn
 * @desc ...
 */
 open class AddImpl : Add {

    override fun mether(a: Int, b: Int): Int {
        return a + b
    }


    fun syncAnswer(callback: Callback?) {
        Thread {
            Thread.sleep(5000)
            callback?.success("Success")
        }.start()
    }

    fun action(msg:String) : String{
        return msg
    }

}