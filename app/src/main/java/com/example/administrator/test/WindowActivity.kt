package com.example.administrator.test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_window.*

class WindowActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window)
        val array = resources.getStringArray(R.array.bodies_of_water)
        val adapter = ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,array)
        autoText.setAdapter(adapter)
    }
}
