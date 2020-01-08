package com.example.kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.data.YoutubeItem


class RecyclerAdapter(val list: ArrayList<YoutubeItem>, val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.rv_title.setText(list[position].title)
        holder.rv_title_price.setText(list[position].title_price)
        Glide.with(context).load(list[position].image).override(1024).into(holder.rv_image)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val rv_title = itemView.findViewById<TextView>(R.id.title)
        val rv_title_price = itemView.findViewById<TextView>(R.id.title_price)
        val rv_image = itemView.findViewById<ImageView>(R.id.thumbnail)


    }


}

