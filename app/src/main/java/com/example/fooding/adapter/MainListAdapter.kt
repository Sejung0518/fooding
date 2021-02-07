package com.example.fooding.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.graphics.drawable.toIcon
import androidx.core.net.toFile
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooding.R
import com.example.fooding.data.ListData
import java.net.URL

class MainListAdapter(
    val context: Context,
    val data: List<ListData>?,
    val itemClick: (ListData) -> Unit
) : RecyclerView.Adapter<MainListAdapter.MainListViewHolder>() {

    //viewHolder를 생성하고 view를 붙여주는 부분
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_list_item, parent, false)

        return MainListViewHolder(view, itemClick)
    }

    // 데이터의 개수를 반환
    override fun getItemCount(): Int {
        return data!!.size
    }

    //재활용되는 view를 호출하여 실행되는 메소드 - 전달 및 데이터 결합
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.onBind(data!!.get(position))

        // 간격 설정
        val layoutParams = holder.itemView.layoutParams
        layoutParams.height = 120
        holder.itemView.requestLayout()
    }

    //MainListViewHolder
    //View를 저장할 변수(데이터 교체)
    inner class MainListViewHolder(itemView: View, itemClick: (ListData) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        var img_foods = itemView.findViewById<ImageView>(R.id.img_foods)
        var name_stores = itemView.findViewById<TextView>(R.id.edit_name_stores)
        var name_foods = itemView.findViewById<TextView>(R.id.name_foods)
        var price_foods = itemView.findViewById<TextView>(R.id.price_foods)
        var rank_foods = itemView.findViewById<TextView>(R.id.rating_foods)
        var contents_foods = itemView.findViewById<TextView>(R.id.contents_foods)


        //View와 데이터를 연결시키는 함수
        @RequiresApi(Build.VERSION_CODES.O)
        fun onBind(data: ListData) {
            //Glide 라이브러리를 통해 외부 링크를 ImageView에 넣을 수 있다.
            Glide.with(itemView).load(data.img_foods?.toUri()).into(img_foods)

            name_stores.text = data.name_stores
            name_foods.text = data.name_foods
            price_foods.text = data.price_foods
            rank_foods.text = data.rank_foods
            contents_foods.text = data.contents_foods

            itemView.setOnClickListener { itemClick(data) }

        }


    }

}
