package com.example.fooding.adapter

import android.media.Rating
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fooding.R


class ShowItemActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_show)

        var show_rating = findViewById<TextView>(R.id.show_rating)
        var edit_ranking_show = findViewById<RatingBar>(R.id.edit_ranking_show)
        var score = edit_ranking_show.getRating()

        //show_rating.setText("${score} / 5")

      /*  edit_ranking_show.setOnRatingBarChangeListener { edit_ranking_show, score, fromUser->
            //show_rating.text = "${edit_ranking_show.rating} / 5"
            show_rating.setText("${score} / 5")
        }*/

       /* edit_ranking_show.setOnRatingBarChangeListener(object : RatingBar.OnRatingBarChangeListener {
            override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
                show_rating.setText("${score} / 5")
            }
        })*/

        edit_ranking_show.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            edit_ranking_show.rating = rating
            show_rating.setText("${edit_ranking_show.rating} / 5")
        }
        //왜 텍스트뷰가 바뀌질 않아,,,눈물난다진짜 ;3c
    }
}