package com.example.kotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.Constant.VIEW_TYPE_HEADER
import com.example.kotlin.Constant.VIEW_TYPE_ITEM
import com.example.kotlin.Constant.VIEW_TYPE_LOADING
import com.example.kotlin.data.YoutubeItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val list = arrayListOf(
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

        //   val list = ArrayList<YoutubeItem>()
        adapter = RecyclerAdapter(list, this)
        adapter.notifyDataSetChanged()
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        recyclerView.layoutManager = GridLayoutManager(this, 2).also {
            it.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    if (position == 0)
                        return 2
                    else
                        return 1
                }
            }
        }
    }
}


//        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//            }
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//
//                if (dy <= 0) return
//
//                totalItemCount = recyclerView.layoutManager!!.itemCount
//
//                if (recyclerView.layoutManager is GridLayoutManager) {
//                    lastVisibleItem =
//                        (recyclerView.layoutManager as GridLayoutManager).findLastCompletelyVisibleItemPosition()
//                    Toast.makeText(this@MainActivity, "dd", Toast.LENGTH_SHORT).show()
//                }
//
//            }
//
////
////                val lastVisibleItemPosition =
////                    (recyclerView.getLayoutManager() as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
////                val itemTotalCount = recyclerView.getAdapter()!!.getItemCount()
////
////                if (lastVisibleItemPosition == itemTotalCount) {
////
////                    Toast.makeText(this@MainActivity, "dd",Toast.LENGTH_SHORT).show()
////
////                }
////            }
////        })


