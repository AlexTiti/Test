package com.example.administrator.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewActivity : AppCompatActivity() {

    val list = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        for (i in 0..50) {
            list.add("AAA $i")
        }

        val adapter = Adapter(list, this)

        recycler.adapter = adapter


    }
}
