package com.example.wallpaper

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() , Myadapter.OnItemClickListener{
    lateinit var mRecyclerView : RecyclerView
    lateinit var myAdapter: Myadapter
    private  val mPlaceList = mutableListOf(
        Image(R.drawable.img1),
        Image(R.drawable.img2),
        Image(R.drawable.img3),
        Image(R.drawable.img4),
        Image(R.drawable.img5),
        Image(R.drawable.img6),
        Image(R.drawable.img7),
        Image(R.drawable.img8),
        Image(R.drawable.img9),
        Image(R.drawable.img10),
        Image(R.drawable.img11),
        Image(R.drawable.img12),
        Image(R.drawable.img13),
        Image(R.drawable.img14))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById(R.id.recyclerview)
        mRecyclerView.layoutManager = GridLayoutManager(this,2)


        myAdapter = Myadapter(this , mPlaceList , this)
        mRecyclerView.adapter = myAdapter
    }






    override fun OnItemClick(position: Int) {
        val pos = position
        val sharedPreferences: SharedPreferences = getSharedPreferences("sharedPrefs" , Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.apply {
            putInt("pos" , pos)
        }.apply()
        Toast.makeText(this, "Item " + pos + " clicked" , Toast.LENGTH_LONG).show()

    }









    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        menu?.setHeaderTitle("Context Menu Header")
        menuInflater.inflate(R.menu.contextmenu, menu)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.aboutus -> {
                val intent = Intent(applicationContext, AboutUs::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }




}