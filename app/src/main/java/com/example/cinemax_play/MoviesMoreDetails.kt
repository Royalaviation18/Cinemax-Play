package com.example.cinemax_play

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.cinemax_play.R

class MoviesMoreDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_more_details)

        val getImage = intent.getStringExtra("image")
        val getTitle = intent.getStringExtra("title")
        val getDate = intent.getStringExtra("date")
        val getLanguage = intent.getStringExtra("language")
        val desc = intent.getStringExtra("desc")

        val mTitle = findViewById<TextView>(R.id.tvMovieTitle)
        val mImage = findViewById<TextView>(R.id.ivMoviesImage)
        val mDate = findViewById<TextView>(R.id.tvDate)
        val mLanguage = findViewById<TextView>(R.id.tvLanguage)
        val mDesc = findViewById<TextView>(R.id.tvMovieDesc)

        mTitle.text = getTitle
        mDate.text = getDate
        mLanguage.text = getLanguage
        mDesc.text = desc
        mImage.text = getImage

    }
}