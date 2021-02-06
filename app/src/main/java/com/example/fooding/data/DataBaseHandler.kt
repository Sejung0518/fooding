package com.example.fooding.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

// DB작업에 사용될 네임 값들 지정
val DATABASE_NAME = "ListDB"
val TABLE_NAME = "ListData"
// val COL_IMG = "image"
val COL_STROE = "store"
val COL_FOODS = "foods"
val COL_PRICE = "price"
val COL_RANK = "rank"
val COL_CONTENTS ="contents"

class DataBaseHandler(var context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME ($COL_FOODS VARCHAR(50) PRIMARY KEY AUTOINCREMENT,$COL_STROE VARCHAR(50),$COL_PRICE VARCHAR(50)," +
                "$COL_RANK VARCHAR(50),$COL_CONTENTS VARCHAR(50))"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    // 데이터 삽입
    fun insertData(data: MainListData){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_STROE,data.name_stores)
        cv.put(COL_FOODS,data.name_foods)
        cv.put(COL_PRICE,data.price_foods)
        cv.put(COL_RANK,data.rank_foods)
        cv.put(COL_CONTENTS,data.contents_foods)

        val result = db.insert(TABLE_NAME,null,cv)

        if(result == (-1).toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()
    }

    // 데이터 READ
    fun readData():MutableList<MainListData>{
        val list:MutableList<MainListData> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_NAME"
        val result:Cursor = db.rawQuery(query,null)

        if(result.moveToFirst()){
            do{
                val data = MainListData("커피디자인하다","자바칩","5000원",
                "5점","HJMT")
                data.name_stores = result.getString(result.getColumnIndex(COL_STROE))
                data.name_foods = result.getString(result.getColumnIndex(COL_FOODS))
                data.price_foods = result.getString(result.getColumnIndex(COL_PRICE))
                data.rank_foods = result.getString(result.getColumnIndex(COL_RANK))
                data.contents_foods = result.getString(result.getColumnIndex(COL_CONTENTS))
                list.add(data)

            }while(result.moveToNext())
        }else
            Toast.makeText(context,"There is no data",Toast.LENGTH_LONG).show()

        result.close()
        db.close()
        return list
    }

    // 데이터 UPDATE
    fun updateData(){
        val db =this.writableDatabase
        val query = "Select * from $TABLE_NAME"
        val result:Cursor = db.rawQuery(query,null)

        if(result.moveToFirst()){
            do{
                val cv = ContentValues()
                cv.put(COL_STROE,result.getString((result.getColumnIndex((COL_STROE))+1)))
                db.update(TABLE_NAME,cv,"$COL_FOODS=? AND $COL_PRICE=? AND $COL_RANK=? AND $COL_CONTENTS=?",
                arrayOf(result.getString(result.getColumnIndex(COL_FOODS)),
                        result.getString(result.getColumnIndex(COL_PRICE)),
                        result.getString(result.getColumnIndex(COL_RANK)),
                        result.getString(result.getColumnIndex(COL_CONTENTS))))
            }while (result.moveToNext())
        }
        result.close()
        db.close()
    }

    // 데이터 삭제
    fun deleteData(){
        val db = this.writableDatabase

        db.delete(TABLE_NAME,null,null)
        db.close()
    }
}



