package com.example.administrator.test

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class PhoneNumberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number)

        setResult(Activity.RESULT_OK, createIntent())
        finish()

    }

    companion object {

      public  fun createIntent():Intent{
            val intent = Intent()
            intent.putExtra("AAA","123456789")
            return intent
        }
    }
}
