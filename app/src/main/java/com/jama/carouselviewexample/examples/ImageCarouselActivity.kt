package com.jama.carouselviewexample.examples

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jama.carouselview.CarouselScrollListener
import com.jama.carouselviewexample.R
import kotlinx.android.synthetic.main.activity_image_carousel.*

class ImageCarouselActivity : AppCompatActivity() {

    val images = arrayListOf(R.drawable.boardwalk_by_the_ocean, R.drawable.journal_and_coffee_at_table, R.drawable.tying_down_tent_fly)
    private val imageTitle = arrayListOf("Cape Town, South Africa", "New York, USA", "Iceland")
    val imageDesc = arrayListOf("Broad walk by the ocean", "Journal and coffee at table", "Tying down tent fly")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_carousel)

        textViewCount.text = "1/${images.size}"
        textViewDesc.text = imageDesc[0]

        val scrollListener = object : CarouselScrollListener {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int, position: Int) {
                textViewCount.text = "${position + 1}/${images.size}"
                textViewDesc.text = imageDesc[position]
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {}
        }

        carouselView.apply {
            size = images.size
            resource = R.layout.image_carousel_item
            hideIndicator(true)
            setCarouselViewListener { view, position ->
                val imageView = view.findViewById<ImageView>(R.id.imageView)
                imageView.setImageDrawable(resources.getDrawable(images[position]))
                val textView = view.findViewById<TextView>(R.id.textViewTitle)
                textView.text = imageTitle[position]
            }
            carouselScrollListener = scrollListener
            show()
        }

        floatingActionButtonLeft.setOnClickListener {
            carouselView.currentItem -= 1
        }

        floatingActionButtonRight.setOnClickListener {
            carouselView.currentItem += 1
        }


    }
}
