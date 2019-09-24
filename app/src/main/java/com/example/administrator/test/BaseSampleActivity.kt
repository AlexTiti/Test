package com.example.administrator.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_base_sample.*
import kotlinx.android.synthetic.main.activity_main.*

class BaseSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_sample)

        button5.setOnClickListener {
            textView3.text = editText2.text.toString()
        }

        button6.setOnClickListener {
            startActivity(BaseSampleToActivity.newStartIntent(this,editText2.text.toString()))
        }

    }
}
