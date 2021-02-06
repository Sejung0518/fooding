package com.example.fooding.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fooding.R
import com.example.fooding.data.ListDao
import com.example.fooding.data.ListData
import com.example.fooding.data.ListDatabase
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private var listDB: ListDatabase? = null
    private var dataList = listOf<ListData>()
    private lateinit var myAdapter: MainListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listDB = ListDatabase.getInstance(this)

        val r = Runnable {

            try{
                dataList = listDB?.listDao()?.getAll()!!

                //item을 클릭했을 때 반응하는 곳
                myAdapter = MainListAdapter(this,dataList){
                    showPopUp()
                    Toast.makeText(this, "ItemClick:" + it.name_foods, Toast.LENGTH_SHORT).show()
                }
                myAdapter.notifyDataSetChanged()

                val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
                recycler_view.adapter = myAdapter

                recycler_view.layoutManager = LinearLayoutManager(this)
                recycler_view.addItemDecoration(RecyclerDecoration(20))
                recycler_view.setHasFixedSize(true)
            }catch (e:Exception){
                Log.d("tag","Error =- $e")
            }

        }

        val thread = Thread(r)
        thread.start()

        /* writeButton click -> WriteItemActivity */
        val writeButton = findViewById<Button>(R.id.writeButton)
        writeButton.setOnClickListener() {
            val intent = Intent(this,WriteItemActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    //팝업창 띄우기
    @SuppressLint("ResourceType")
    fun showPopUp(){
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.activity_item_show,null)

        val alertDialog = AlertDialog.Builder(this)
                .setView(findViewById(R.layout.activity_item_show))
                .create()
        alertDialog.setView(view)
        alertDialog.show()
    }

    override fun onDestroy() {
        ListDatabase.destroyInstance()
        listDB = null
        super.onDestroy()
    }
}