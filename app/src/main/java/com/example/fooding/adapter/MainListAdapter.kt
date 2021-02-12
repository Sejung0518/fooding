package com.example.fooding.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.view.menu.MenuView
import androidx.core.graphics.drawable.toDrawable
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooding.R
import com.example.fooding.data.ListData
import com.google.android.material.internal.ViewUtils.dpToPx
import java.io.ByteArrayOutputStream

@Suppress("CAST_NEVER_SUCCEEDS", "DEPRECATION")
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
    @SuppressLint("RestrictedApi")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.onBind(data!!.get(position))

        // 간격 설정
        val myHeight = dpToPx(context,200)
        val layoutParams = holder.itemView.layoutParams
        layoutParams.height = myHeight.toInt()
        holder.itemView.requestLayout()
    }

    //MainListViewHolder
    //View를 저장할 변수(데이터 교체)
    inner class MainListViewHolder(itemView: View, itemClick: (ListData) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        var img_foods = itemView.findViewById<ImageView>(R.id.img_foods)
        var name_stores = itemView.findViewById<TextView>(R.id.edit_name_stores)
        var name_foods = itemView.findViewById<TextView>(R.id.name_foods)
        var img_category = itemView.findViewById<ImageView>(R.id.item_category)
        var price_foods = itemView.findViewById<TextView>(R.id.price_foods)
        var rank_foods = itemView.findViewById<RatingBar>(R.id.edit_ranking)
        var contents_foods = itemView.findViewById<TextView>(R.id.contents_foods)


        //View와 데이터를 연결시키는 함수
        fun onBind(data: ListData) {
            //Glide 라이브러리를 통해 외부 링크를 ImageView에 넣을 수 있다.
            Glide.with(itemView).load(data.img_foods?.toUri()).into(img_foods)
            name_stores.text = data.name_stores
            name_foods.text = data.name_foods

            //val bitmap = BitmapFactory.decodeByteArray(data.img_category,0,
            //    data.img_category?.count()!!
            //)
            //bitmap as BitmapDrawable
            //img_category.setImageDrawable(bitmap)

            //val bitmap = BitmapFactory.decodeByteArray(data.img_category,0,length)
            //val BM = data.img_category as Bitmap
            //val BD = BM as BitmapDrawable
            //val draw = BD as Drawable
            //img_category.setImageDrawable(draw)
            //val imageBytes = Base64.decode(data.img_category, 0)
            //val os = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            //val bm = BitmapDrawable(os)

            //img_category.setBackgroundDrawable(bm)
            //Glide.with(itemView).load(bm).into(img_category)
            //img_category.setBackgroundDrawable(null)
            //img_category.setImageBitmap(data.img_category)
            //Glide.with(itemView).load(data.img_category).into(img_category)
            //Glide.with(itemView).load(BitmapDrawable(data.img_category)).into(img_category)
            //img_category.setImageBitmap(data.img_category)
            //img_category.setImageDrawable(BitmapDrawable(data.img_category))

            //Glide.with(itemView).load(data.img_category).into(img_category.drawable)
            price_foods.text = data.price_foods
            rank_foods.rating = data.rank_foods
            contents_foods.text = data.contents_foods

            itemView.setOnClickListener { itemClick(data) }

        }


    }

}




