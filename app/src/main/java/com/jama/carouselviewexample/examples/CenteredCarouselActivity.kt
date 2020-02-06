package com.jama.carouselviewexample.examples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.jama.carouselview.enums.IndicatorAnimationType
import com.jama.carouselview.enums.OffsetType
import com.jama.carouselviewexample.R
import kotlinx.android.synthetic.main.activity_centered_carousel.*

class CenteredCarouselActivity : AppCompatActivity() {

    val images = arrayListOf(R.drawable.boardwalk_by_the_ocean, R.drawable.journal_and_coffee_at_table, R.drawable.tying_down_tent_fly)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_centered_carousel)

        carouselView.apply {
            size = images.size
            autoPlay = true
            autoPlayDelay = 3000
            resource = R.layout.center_carousel_item
            indicatorAnimationType = IndicatorAnimationType.THIN_WORM
            carouselOffset = OffsetType.CENTER
            setCarouselViewListener { view, position ->
                val imageView = view.findViewById<ImageView>(R.id.imageView)
                imageView.setImageDrawable(resources.getDrawable(images[position]))
            }
            show()
        }
    }
}
