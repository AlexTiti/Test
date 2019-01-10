package com.example.administrator.test

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * @author  : Alex
 * @date    : 2018/11/07
 * @version : V 2.0.2
 */
class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context : Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

    }

    fun dev(){
        //----------------
        //===============
        //+++++++++++++++
        //|||||||||||||||

        "这时添加add 的版本"
    }

    fun fix(){

    }
}