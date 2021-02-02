package com.example.fooding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooding.R

class MainListAdapter(private val context: Context) : RecyclerView.Adapter<MainListViewHolder>(){
    //데이터를 저장하는 변수
   var data = mutableListOf<MainListData>()

    //viewHolder를 생성하고 view를 붙여주는 부분
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_list_item,parent,false)

        return MainListViewHolder(view)
    }

    // 데이터의 개수를 반환
    override fun getItemCount(): Int = data.size

    //재활용되는 view를 호출하여 실행되는 메소드 - 전달 및 데이터 결합
    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.onBind(data[position])
    }
}
