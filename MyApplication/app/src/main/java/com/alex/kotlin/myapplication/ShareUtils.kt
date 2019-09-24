package com.alex.kotlin.myapplication

import android.content.Context
import android.content.SharedPreferences


/**
 * @author Alex
 * @date 2019-09-23 14:18
 * @email 18238818283@sina.cn
 * @desc ...
 */
class ShareUtils(context: Context) {

    private val sp: SharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE)

    fun put(key: String, value: String) {
        val editor = sp.edit()
        editor.putString(key, value)
        editor.apply()
    }

    operator fun get(key: String): String? {
        return sp.getString(key, null)
    }

}