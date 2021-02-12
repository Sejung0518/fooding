package com.example.fooding.adapter

import android.content.Intent
import android.media.Rating
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fooding.R

class RatingFoodActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_rating)

        edit_ranking_show.onRatingBarChangeListener = MyRatingBarChangeListener()

        var intent = getIntent()
        processIntent(intent)
    }
    val edit_ranking_show = findViewById<RatingBar>(R.id.edit_ranking_show)
    var show_rating = findViewById<TextView>(R.id.show_rating)

    inner class MyRatingBarChangeListener: RatingBar.OnRatingBarChangeListener{
        override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
            show_rating.setText("${edit_ranking_show.rating} / 5")
            returnToItem()
        }
    }

    fun processIntent(intent: Intent){
        if(intent != null){
            var rating = intent.getFloatExtra("rating", 0.0f) as Float
            edit_ranking_show.setRating(rating)
        }
    }

    fun returnToItem(){
        var ratingBarUpdate = edit_ranking_show.rating
        var intent = Intent() as Intent
        intent.putExtra("ratingBarUpdate", ratingBarUpdate)

        setResult(RESULT_OK, intent)
        finish()
    }
}