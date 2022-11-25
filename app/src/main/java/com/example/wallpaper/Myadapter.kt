package com.example.wallpaper

import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class Myadapter(val c : Context,
                private val list:  List<Image> ,
                 private val listener: OnItemClickListener) : RecyclerView.Adapter<Myadapter.ViewHolder>(){

    private var ps : Int = 0
    private var listData: MutableList<Image> = list as MutableList<Image>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_custom_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Myadapter.ViewHolder, position: Int) {
        val image : Image = listData[position]
        holder.bind(image)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView),

        View.OnClickListener {
            private var imageView: ImageView = itemView.findViewById(R.id.img)
            init {
                ItemView.setOnClickListener(this)
            }


        fun bind(image1: Image){
                imageView.setImageResource(image1.image)
                imageView.setOnClickListener{popupmenu(it , image1)}

        }



        private fun popupmenu(v:View , image1: Image) {
            val popupMenus = PopupMenu(c,v)
            popupMenus.inflate(R.menu.contextmenu)
            popupMenus.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.view ->{
                        val intent = Intent(c.applicationContext, ViewImage::class.java)
                        intent.putExtra("image", image1.image )
                        c.startActivity(intent)
                        true
                    }
                    R.id.set ->{
                        true
                    }
                    R.id.delete ->{
                        val pos = adapterPosition
                        listData.removeAt(pos)
                        notifyDataSetChanged()
                        Toast.makeText(c, "Item " + pos + " deleted " , Toast.LENGTH_LONG).show()
                        true
                    }
                    else -> true
                }
            }
            popupMenus.show()
            val popup = PopupMenu::class.java.getDeclaredField("mPopup")
            popup.isAccessible = true
            val menu = popup.get(popupMenus)
            menu.javaClass.getDeclaredMethod("setForceShowIcon" , Boolean::class.java)
                .invoke(menu , true)

        }


        override fun onClick(p0: View?) {
                ps = adapterPosition
                if (ps !=RecyclerView.NO_POSITION){
                    listener.OnItemClick(ps)
                }
            }

    }

    interface OnItemClickListener {
        fun OnItemClick(position: Int)
    }

}


