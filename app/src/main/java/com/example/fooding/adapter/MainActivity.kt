package com.example.fooding.adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
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
                            "매워요테ㅔㅔㅔㅔㅔㅔㅔ스트ㅡㅡㅡㅡㅡㅡ중입니다ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ호호호ㅗ호"
                    )
            )
        }

        myAdapter = MainListAdapter(this,myDatas){
            Toast.makeText(this, "ItemClick:" + it.name_foods, Toast.LENGTH_SHORT).show()
        }
        //myAdapter.data = myDatas
        myAdapter.notifyDataSetChanged()

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.adapter = myAdapter

        recycler_view.layoutManager = LinearLayoutManager(this)

        /* writeButton click -> WriteItemActivity */
        val writeButton = findViewById<Button>(R.id.writeButton)
            writeButton.setOnClickListener() {
            val intent = Intent(this,WriteItemActivity::class.java)
            startActivity(intent)
        }

    }
}