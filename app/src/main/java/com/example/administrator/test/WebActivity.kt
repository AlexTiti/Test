package com.example.administrator.test

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*


class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView.settings.javaScriptEnabled = true
        webView.requestFocus()
        webView.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                return false
            }
        }

        webView.loadUrl(initWebView(intent))

    }

    fun initWebView(intent: Intent):String{
       return intent.getStringExtra("url") ?: "file:///android_asset/web_form.html"
    }




}
