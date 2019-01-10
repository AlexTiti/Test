package com.example.administrator.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_custom_matcher.*

class CustomMatcherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_matcher)

        btn_edit_phone.setOnClickListener {
            et_phone_hint.hint = "123456789"
        }
    }
}
