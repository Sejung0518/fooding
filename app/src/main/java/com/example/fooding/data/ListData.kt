package com.example.fooding.data

import android.net.Uri
import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DataTable")
data class ListData(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "img")
    var img_foods: String?,

    @ColumnInfo(name = "store")
    var name_stores: String?,

    @ColumnInfo(name = "food")
    var name_foods: String?,

    @ColumnInfo(name = "price")
    var price_foods: String?,

    @ColumnInfo(name = "rank")
    var rank_foods: Int?,

    @ColumnInfo(name = "contents")
    var contents_foods: String?
){
    constructor():this(null,null,"","","", rank_foods = null,"")
}
