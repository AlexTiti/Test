package com.example.administrator.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.content.ContentResolverCompat
import androidx.test.espresso.idling.CountingIdlingResource
import com.example.administrator.test.R.id.btnGetText
import com.example.administrator.test.idling.TestIdlingResource
import kotlinx.android.synthetic.main.activity_iding.*


const val textString = " This is a text ! "
class IdingActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iding)

        btnGetText.setOnClickListener {
//            idingResource.increment()
            idingResource.setBoolean(false)
            Handler().postDelayed(
                {
                    tvShowText.text = textString
//                    idingResource.decrement()
                    idingResource.setBoolean(true)
                },3000
            )
        }

    }

    val idingResource by lazy {

//        CountingIdlingResource("Idling")  // 使用系统的CountingIdlingResource
        TestIdlingResource()
    }





}
