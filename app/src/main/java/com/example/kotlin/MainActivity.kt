package com.example.kotlin

import `in`.srain.cube.views.GridViewWithHeaderAndFooter
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.data.YoutubeItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.gridLayout
import org.jetbrains.anko.spinner

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


//        spinner().onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//
//            }
//
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {

//                when (spinner().getItemAtPosition(position)) {
//                    "모든 피부 타입" -> {
//                        AllSkinType()
//                    }
////                    "건성 피부 타입" -> {
////                        DrySkinType()
////                    }
////                    "지성 피부 타입" -> {
////                        OilySkinType()
////                    }
////                    "트러블 피부 타입" -> {
////                        TroubleSkinType()
////                    }
////                    "복합성 피부 타입" -> {
////                        ComplicatedSkinType()
////                    }
//
//                }
//            }
//        }


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
