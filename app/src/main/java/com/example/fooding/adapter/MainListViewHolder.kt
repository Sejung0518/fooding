package com.example.fooding.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooding.R

//View를 저장할 변수(데이터 교체)
class MainListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    //val img_foods = itemView.findViewById<ImageView>(R.id.img_foods)
    val name_stores = itemView.findViewById<TextView>(R.id.name_stores)
    val name_foods = itemView.findViewById<TextView>(R.id.name_foods)
    val price_foods = itemView.findViewById<TextView>(R.id.price_foods)
    //val rank_foods: String
    val contents_foods = itemView.findViewById<TextView>(R.id.contents_foods)

    //View와 데이터를 연결시키는 함수
    fun onBind(data: MainListData){
        //Glide 라이브러리를 통해 외부 링크를 ImageView에 넣을 수 있다.
        //이미지, 별점, 날짜, 카테고리 부족
        //Glide.with(itemView).load(data.img_foods).into(img_foods)
        name_stores.text = data.name_stores
        name_foods.text = data.name_foods
        price_foods.text = data.price_foods
        contents_foods.text = data.contents_foods
    }
}