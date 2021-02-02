package com.example.fooding.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        myAdapter = MainListAdapter(this)
        myAdapter.data = myDatas
        myAdapter.notifyDataSetChanged()
        findViewById<RecyclerView>(R.id.recycler_view).adapter = myAdapter
    }

}