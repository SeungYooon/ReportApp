package com.example.kotlin

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.data.YoutubeItem
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.logging.Handler

class RecyclerAdapter(var list: ArrayList<YoutubeItem>, var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val TYPE_ITEM: Int = 1
    private val TYPE_HEADER: Int = 0
    private val TYPE_LOADING = 2


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

//        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
//        return RecyclerAdapter.ViewHolder(v)
        if (viewType == TYPE_HEADER) {

            val headView: View =
                LayoutInflater.from(parent.context).inflate(R.layout.header, parent, false)

            return HeaderHolder(headView)

        } else {
            val mainView: View =
                LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

            return ViewHolder(mainView)
        }
    }

    override fun getItemViewType(position: Int): Int {

        if (isPositionHeader(position)) {
            return TYPE_HEADER

        } else {
            return TYPE_ITEM
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1 // header 추가
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is ViewHolder) {
            var itemHolder: ViewHolder = holder

            Glide.with(context).load(list[position - 1].image).override(1024).into(holder.rv_image)
            itemHolder.rv_title.setText(list.get(position - 1).title)
            itemHolder.rv_title_price.setText(list.get(position - 1).title_price)


            itemHolder.itemView.setOnClickListener {
                Toast.makeText(
                    context,
                    "Clicked: ${list.get(position - 1).title}",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }

//        holder.rv_title.setText(list[position].title)
//        holder.rv_title_price.setText(list[position].title_price)
//        Glide.with(context).load(list[position].image).override(1024).into(holder.rv_image)
    }


    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val rv_title = itemView.findViewById<TextView>(R.id.title)
        val rv_title_price = itemView.findViewById<TextView>(R.id.title_price)
        val rv_image = itemView.findViewById<ImageView>(R.id.thumbnail)
    }

    fun isPositionHeader(position: Int): Boolean {
        return position == TYPE_HEADER
    }


}





