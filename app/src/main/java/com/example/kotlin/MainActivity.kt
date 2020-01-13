package com.example.kotlin

import `in`.srain.cube.views.GridViewWithHeaderAndFooter
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.data.YoutubeItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.header.*
import org.jetbrains.anko.gridLayout
import org.jetbrains.anko.scrollView
import org.jetbrains.anko.sdk25.coroutines.onQueryTextListener
import org.jetbrains.anko.searchView
import org.jetbrains.anko.spinner
import org.jetbrains.anko.support.v4.nestedScrollView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val list = ArrayList<YoutubeItem>()
//        adapter = RecyclerAdapter(list, this)
//        recyclerView.adapter = adapter
//        recyclerView.setHasFixedSize(true)
//        recyclerView.addItemDecoration(
//            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
//        )

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


        val adapter = RecyclerAdapter(list, this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        (recyclerView.adapter as RecyclerAdapter).notifyDataSetChanged()
        //리사이클러뷰 구분선
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



