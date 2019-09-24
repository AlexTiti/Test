package com.example.administrator.test

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_base_sample_to.*

const val KEY_EXTRA_MESSAGE = "EXTRA"


class BaseSampleToActivity : AppCompatActivity() {

    companion object {

        public fun newStartIntent(context: Context, message: String): Intent {
            val newIntent = Intent(context, BaseSampleToActivity::class.java)
            newIntent.putExtra(KEY_EXTRA_MESSAGE, message)
            return newIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_sample_to)
        textView4.text = intent.getStringExtra(KEY_EXTRA_MESSAGE)
    }

}
