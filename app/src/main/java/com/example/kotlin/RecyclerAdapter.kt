package com.example.kotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.getDrawable
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.data.YoutubeItem
import kotlinx.android.synthetic.main.header.view.*
import kotlinx.android.synthetic.main.list_item.view.*
import android.content.Context as Context1
import com.example.kotlin.RecyclerAdapter as RecyclerAdapter1

class RecyclerAdapter(var list: ArrayList<YoutubeItem>, var context: Context1) :
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


        } else if (holder is HeaderHolder) {
            var itemHolder: HeaderHolder = holder

            itemHolder.itemView.types_spinner.dropDownVerticalOffset

            itemHolder.itemView.types_spinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?, view: View?, position: Int, id: Long
                    ) {
                        when (position) {
                            0 -> {
                                Toast.makeText(context, "모든 피부 타입", Toast.LENGTH_SHORT).show()
                                everyTypes()
                            }
                            1 -> {
                                Toast.makeText(context, "건성 피부 타입", Toast.LENGTH_SHORT).show()
                                dryTypes()
                            }
                            2 -> {
                                Toast.makeText(context, "지성 피부 타입", Toast.LENGTH_SHORT).show()
                                oilTypes()
                            }
                            3 -> {
                                Toast.makeText(context, "트러블 피부 타입", Toast.LENGTH_SHORT).show()
                                troubleTypes()
                            }
                            4 -> {
                                Toast.makeText(context, "복합성 피부 타입", Toast.LENGTH_SHORT).show()
                                complicatedTypes()
                            }
                        }
                    }
                }
        }
    }

    private fun complicatedTypes() {
        val list = arrayListOf(
            YoutubeItem(
                R.drawable.ic_launcher_foreground,
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
        this@RecyclerAdapter.list = list
        this@RecyclerAdapter.notifyDataSetChanged()

    }

    private fun troubleTypes() {
        val list = arrayListOf(
            YoutubeItem(
                R.drawable.search_img,
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
        this@RecyclerAdapter.list = list
        this@RecyclerAdapter.notifyDataSetChanged()

    }

    private fun dryTypes() {
        val list = arrayListOf(
            YoutubeItem(
                R.drawable.ic_launcher_background,
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
        this@RecyclerAdapter.list = list
        this@RecyclerAdapter.notifyDataSetChanged()
    }

    private fun oilTypes() {

        val list = arrayListOf(
            YoutubeItem(
                R.drawable.image02,
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
        this@RecyclerAdapter.list = list
        this@RecyclerAdapter.notifyDataSetChanged()
    }

    private fun everyTypes() {

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
        this@RecyclerAdapter.list = list
        this@RecyclerAdapter.notifyDataSetChanged()
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





