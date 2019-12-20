package com.jama.carouselviewexample.examples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.jama.carouselviewexample.R
import kotlinx.android.synthetic.main.activity_start_carousel.*

class StartCarouselActivity : AppCompatActivity() {

    private val movies = arrayListOf(R.drawable.harry_potter, R.drawable.konosuba, R.drawable.i_am_legend, R.drawable.priates)
    private val moviesTitles = arrayListOf("Harry Potter", "Konosuba", "I Am Legend", "Pirates of the Caribbean")
    private val trending = arrayListOf(R.drawable.lord_of_ring, R.drawable.naruto, R.drawable.spirited, R.drawable.mad_max)

    private val trendingTitles = arrayListOf("Lord of the Rings", "The Last Naruto the Movie", "Spirited Away", "Mad Max")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_carousel)

        carouselView1.apply {
            size = movies.size
            resource = R.layout.start_carousel_movies_item
            scaleOnScroll = true
            spacing = 50
            hideIndicator(true)
            setCarouselViewListener { view, position ->
                val imageView = view.findViewById<ImageView>(R.id.imageView)
                imageView.setImageDrawable(resources.getDrawable(movies[position]))
                val textView = view.findViewById<TextView>(R.id.textViewTitle)
                textView.text = moviesTitles[position]
            }
            show()
        }

        carouselView2.apply {
            val trendingMovies = trending + movies
            val trendingTitle = trendingTitles + moviesTitles

            size = trendingMovies.size
            resource = R.layout.start_carousel_trending_item
            spacing = 50
            hideIndicator(true)
            setCarouselViewListener { view, position ->
                val imageView = view.findViewById<ImageView>(R.id.imageView)
                imageView.setImageDrawable(resources.getDrawable(trendingMovies[position]))
                val textView = view.findViewById<TextView>(R.id.textViewTitle)
                textView.text = trendingTitle[position]
            }
            show()
        }

    }
}
