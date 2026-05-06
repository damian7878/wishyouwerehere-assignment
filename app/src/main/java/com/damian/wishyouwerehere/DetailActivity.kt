package com.damian.wishyouwerehere

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val location = intent.getParcelableExtra("location") as? Location

        location?.let {
            findViewById<ImageView>(R.id.image).setImageResource(it.imageResId)
            findViewById<TextView>(R.id.name).text = it.name
            findViewById<TextView>(R.id.place).text = it.place
            findViewById<TextView>(R.id.date).text = it.lastVisit
            findViewById<RatingBar>(R.id.rating).rating = it.rating
        }
    }
}