package com.example.fooding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooding.R

class MainListAdapter(private val context: Context) : RecyclerView.Adapter<MainListViewHolder>(){
    //데이터를 저장하는 변수
   var data = mutableListOf<MainListData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.main_list_item,parent,false)

        return MainListViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.onBind(data[position])
    }
}
