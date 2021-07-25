# CarouselView

[![](https://jitpack.io/v/jama5262/CarouselView.svg)](https://jitpack.io/#jama5262/CarouselView)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

An android carousel library for RecyclerView

#### [Examples](https://github.com/jama5262/CarouselView/tree/master/app/src/main/java/com/jama/carouselviewexample/examples)

## Demos

Full Image | Item Centered | Item Start
------------ | ------------- | -------------
<img src="https://github.com/jama5262/CarouselView/blob/master/app/src/main/res/drawable/image1.gif" alt="alt text" height="500px"> | <img src="https://github.com/jama5262/CarouselView/blob/master/app/src/main/res/drawable/image2.gif" alt="alt text" height="500px"> | <img src="https://github.com/jama5262/CarouselView/blob/master/app/src/main/res/drawable/image3.gif" height="500px">

## Installation

Current Version: [![](https://jitpack.io/v/jama5262/CarouselView.svg)](https://jitpack.io/#jama5262/CarouselView)

#### Gradle

Add the following

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

```
dependencies {
    implementation 'com.github.jama5262:CarouselView:1.2.2'
}
```

Great the project has been setup 👍

## Usage

#### XML

Below is all the XML attributes that the CarouselView has

```xml
<com.jama.carouselview.CarouselView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:enableSnapping="true"
    app:scaleOnScroll="false"
    app:setAutoPlay="true"
    app:setAutoPlayDelay="3000"
    app:carouselOffset="center"
    app:indicatorAnimationType="drop"
    app:indicatorRadius="5"
    app:indicatorPadding="5"
    app:indicatorSelectedColor="@color/colorAccent"
    app:indicatorUnselectedColor="@color/colorPrimary"
    app:size="10"
    app:spacing="10"
    app:resource="@layout/image_carousel_item"/>
```

#### Kotlin Implementation

```Kotlin
class CarouselActivity : AppCompatActivity() {

    private val images = arrayListOf(R.drawable.boardwalk_by_the_ocean, 
            R.drawable.journal_and_coffee_at_table, R.drawable.tying_down_tent_fly)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carousel)

        val carouselView = findViewById<CarouselView>(R.id.carouselView)

        carouselView.apply {
            size = images.size
            resource = R.layout.carousel_item
            autoPlay = true
            indicatorAnimationType = IndicatorAnimationType.THIN_WORM
            carouselOffset = OffsetType.CENTER
            setCarouselViewListener { view, position ->
                // Example here is setting up a full image carousel
                val imageView = view.findViewById<ImageView>(R.id.imageView)
                imageView.setImageDrawable(resources.getDrawable(images[position]))
            }
            // After you finish setting up, show the CarouselView
            show()
        }
    }
}
```

#### Java Implementation

```java
class CenteredCarouselActivity extends AppCompatActivity {

  private int[] images = {R.drawable.boardwalk_by_the_ocean,
      R.drawable.journal_and_coffee_at_table, R.drawable.tying_down_tent_fly};

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_centered_carousel);
    
    CarouselView carouselView = findViewById(R.id.carouselView);
    
    carouselView.setSize(images.length);
    carouselView.setResource(R.layout.center_carousel_item);
    carouselView.setAutoPlay(true);
    carouselView.setIndicatorAnimationType(IndicatorAnimationType.THIN_WORM);
    carouselView.setCarouselOffset(OffsetType.CENTER);
    carouselView.setCarouselViewListener(new CarouselViewListener() {
      @Override
      public void onBindView(View view, int position) {
        // Example here is setting up a full image carousel
        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(images[position]));
      }
    });
    // After you finish setting up, show the CarouselView
    carouselView.show();
  }
}
```

Below are all the methods available

| Name | Description | Values | Default | Is XML Attribute |
| ------------- | ------------- | ------------- | ------------- | ------------- |
| show | Show the carousel |  |  | No |
| enableSnapping | Enables and disables snapping | true, false | true | Yes |
| hideIndicator | Show and hide indicator | true, false | false | No |
| setAutoPlay | Enable auto play | true, false | false | Yes |
| setAutoPlayDelay | Set delay time for auto play | Takes in integers | 2500 (2.5 sec) | Yes |
| setCarouselOffset | Sets the carousel item to display center or from start | OffsetType.CENTER, OffsetType.START | OffsetType.START | Yes |
| setCurrentItem |This sets the item position | Takes item position |  | No |
| setIndicatorAnimationType | Sets the indicator animation type. This is thanks to [romandanylyk](https://github.com/romandanylyk/PageIndicatorView) | AnimationType.DROP, FILL, NONE, SWAP, WORM, COLOR, SCALE, SLIDE, THIN_WORM, SCALE_DOWN | AnimationType.NONE | Yes |
| setIndicatorRadius | Sets the radius of the indicator | Takes in radius integer |  | Yes |
| setIndicatorPadding | Sets the padding of the indicator | Takes in padding integer|  | Yes |
| setIndicatorSelectedColor | Sets the color of the selected indicator | Takes in color type | Set to black | Yes |
| setIndicatorUnselectedColor | Sets the color of the unselected indicator | Takes in color type | Set to grey | Yes |
| setScaleOnScroll | Sets the carousel item to scale on scroll | true, false | false | Yes |
| setSize | Sets the number of items to display in the carousel | Takes in size integer |  | Yes |
| setSpacing | Sets the spacing between items | Takes in spacing integer | 0 | Yes |
| setResource | Sets the item to be displayed in the carousel | Takes in a layout item |  | Yes |
| setCarouselViewListener | Adding custom view |  |  | No |
| setCarouselScrollListener | Listens for scrolls |  |  | No |

## Support

Reach out to me at one of the following places!

- Email at jama3137@gmail.com
- Twitter [timedjama5262](https://twitter.com/timedjama5262)

## License

```
MIT License

Copyright (c) 2019 Jama Mohamed

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

