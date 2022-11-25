package com.example.wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ViewImage : AppCompatActivity() {
    lateinit var image2 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        image2 = findViewById(R.id.img2)

        val extras = intent.extras
        val img = extras!!.getInt("image")

        image2.setImageResource(img)

    }
}