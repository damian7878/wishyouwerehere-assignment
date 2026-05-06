package com.damian.wishyouwerehere

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val locations = listOf(
        Location("Bondi Beach", "Sydney, Australia", "Jan 2026", 4.5f, R.drawable.bondi),
        Location("Opera House", "Sydney, Australia", "Feb 2026", 5.0f, R.drawable.opera),
        Location("Blue Mountains", "NSW, Australia", "Dec 2025", 4.0f, R.drawable.mountains),
        Location("Darling Harbour", "Sydney, Australia", "Mar 2026", 4.2f, R.drawable.harbour)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cards = listOf(
            findViewById<View>(R.id.card1),
            findViewById<View>(R.id.card2),
            findViewById<View>(R.id.card3),
            findViewById<View>(R.id.card4)
        )

        cards.forEachIndexed { index, view ->
            val location = locations[index]

            val image = view.findViewById<ImageView>(R.id.image)
            val title = view.findViewById<TextView>(R.id.title)
            val rating = view.findViewById<RatingBar>(R.id.rating)

            image.setImageResource(location.imageResId)
            title.text = location.name
            rating.rating = location.rating

            view.setOnClickListener {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("location", location)
                startActivity(intent)
            }
        }
    }
}