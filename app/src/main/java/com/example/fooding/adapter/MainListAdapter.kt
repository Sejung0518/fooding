package com.example.fooding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooding.R

class MainListAdapter(val context: Context, val data:MutableList<MainListData>,val itemClick:(MainListData)->Unit) : RecyclerView.Adapter<MainListAdapter.MainListViewHolder>(){
    //데이터를 저장하는 변수
   //var data = mutableListOf<MainListData>()

    //viewHolder를 생성하고 view를 붙여주는 부분
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_list_item,parent,false)

        return MainListViewHolder(view,itemClick)
    }

    // 데이터의 개수를 반환
    override fun getItemCount(): Int = data.size

    //재활용되는 view를 호출하여 실행되는 메소드 - 전달 및 데이터 결합
    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.onBind(data[position],context)
    }

    //MainListViewHolder
    //View를 저장할 변수(데이터 교체)
    inner class MainListViewHolder(itemView: View, itemClick:(MainListData)->Unit): RecyclerView.ViewHolder(itemView){
        //val img_foods = itemView.findViewById<ImageView>(R.id.img_foods)
        val name_stores = itemView.findViewById<TextView>(R.id.name_stores)
        val name_foods = itemView.findViewById<TextView>(R.id.name_foods)
        val price_foods = itemView.findViewById<TextView>(R.id.price_foods)
        //val rank_foods: String
        val contents_foods = itemView.findViewById<TextView>(R.id.contents_foods)

        //View와 데이터를 연결시키는 함수
        fun onBind(data: MainListData, context: Context){
            //Glide 라이브러리를 통해 외부 링크를 ImageView에 넣을 수 있다.
            //이미지, 별점, 날짜, 카테고리 부족
            //Glide.with(itemView).load(data.img_foods).into(img_foods)
            name_stores.text = data.name_stores
            name_foods.text = data.name_foods
            price_foods.text = data.price_foods
            contents_foods.text = data.contents_foods

            itemView.setOnClickListener { itemClick(data) }

        }
    }

}
