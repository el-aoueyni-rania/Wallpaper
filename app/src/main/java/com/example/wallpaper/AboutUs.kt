package com.example.wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.webkit.WebView
import android.webkit.WebViewClient

class AboutUs : AppCompatActivity() {
    lateinit var webV : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        webV = findViewById(R.id.webview)
        webV.webViewClient = WebViewClient()
        webV.loadUrl("http://isetb.rnu.tn")
    }

}