package com.example.kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.data.YoutubeItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val list = arrayListOf<YoutubeItem>(
            YoutubeItem(
                R.drawable.image01,
                R.string.title01,
                R.string.price01
            ),
            YoutubeItem(
                R.drawable.image02,
                R.string.title02,
                R.string.price02
            ),
            YoutubeItem(
                R.drawable.image03,
                R.string.title03,
                R.string.price03
            ),
            YoutubeItem(
                R.drawable.image04,
                R.string.title04,
                R.string.price04

            ),
            YoutubeItem(
                R.drawable.image05,
                R.string.title05,
                R.string.price05
            ),
            YoutubeItem(
                R.drawable.image06,
                R.string.title06,
                R.string.price06
            ),
            YoutubeItem(
                R.drawable.image07,
                R.string.title07,
                R.string.price07
            ),
            YoutubeItem(
                R.drawable.image08,
                R.string.title08,
                R.string.price08
            ),
            YoutubeItem(
                R.drawable.image09,
                R.string.title09,
                R.string.price09
            ),
            YoutubeItem(
                R.drawable.image10,
                R.string.title10,
                R.string.price10
            )
        )


//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//
//        recyclerView.adapter = RecyclerAdapter(list, this)

        val adapter = RecyclerAdapter(list, this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        (recyclerView.adapter as RecyclerAdapter).notifyDataSetChanged()


        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL) //리사이클러뷰 구분선
        )
    }
}
