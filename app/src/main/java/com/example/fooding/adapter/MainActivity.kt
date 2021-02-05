package com.example.fooding.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fooding.R


class MainActivity : AppCompatActivity() {

    private lateinit var myAdapter: MainListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDatas = mutableListOf<MainListData>()

        myDatas.apply {
            add(
                    MainListData(
                            "스타벅스",
                            "아이스아메리카노",
                            "5000원",
                            "비싸요 ㅠㅠ"
                    )
            )

            add(
                    MainListData(
                            "맘스터치",
                            "싸이버거",
                            "5500원",
                            "맛있어요"
                    )
            )

            add(
                    MainListData(
                            "엽기떡볶이ㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣㅣ",
                            "떡볶이ㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓ",
                            "14000원ㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓㅓ",
                            "매워요"
                    )
            )


            add(
                    MainListData(
                            "BHC?",
                            "허니콤보",
                            "14000원?",
                            "쫀맛!"
                    )
            )
        }

        //item을 클릭했을 때 반응하는 곳
        myAdapter = MainListAdapter(this,myDatas){
            showPopUp()
            Toast.makeText(this, "ItemClick:" + it.name_foods, Toast.LENGTH_SHORT).show()
        }
        //myAdapter.data = myDatas
        myAdapter.notifyDataSetChanged()

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.adapter = myAdapter

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(RecyclerDecoration(20))

        /* writeButton click -> WriteItemActivity */
        val writeButton = findViewById<Button>(R.id.writeButton)
        writeButton.setOnClickListener() {
            val intent = Intent(this,WriteItemActivity::class.java)
            startActivity(intent)
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
}