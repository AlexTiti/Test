package com.example.administrator.test

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_intent.*
import java.util.jar.Manifest

class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        button2.setOnClickListener {

            val b = ContextCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED

            if (b){
                val string = editText.text.trim()
                val intent = Intent(Intent.ACTION_CALL)
                intent.setData(Uri.parse("tel: $string"))
                startActivity(intent)
            }else{
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),100)
            }

        }

        button3.setOnClickListener {
            startActivityForResult(Intent(this,PhoneNumberActivity::class.java),200)
        }

        button4.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (intent.resolveActivity(packageManager) != null){
                startActivityForResult(intent,300)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 200){
            editText.setText(data?.getStringExtra("AAA"))
        }

        if (resultCode == Activity.RESULT_OK && requestCode == 300){
            data?.extras.let {
                val bitmap : Bitmap = it?.getParcelable("data") as Bitmap
                imageView.setImageBitmap(bitmap)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            val string = editText.text.trim()
            val intent = Intent(Intent.ACTION_CALL)
            intent.setData(Uri.parse("tel: $string"))
            startActivity(intent)
        }
    }

}
