# CarouselView

[![Library Version](https://img.shields.io/badge/Library-v1.0.0-blue)](https://pub.dev/packages/jiffy)

An android carousel library for RecyclerView

#### [ChangeLog]() | [Examples]()

## Demos

Full Image | Item Centered | Item Start
------------ | ------------- | -------------
<img src="https://github.com/jama5262/CarouselView/blob/develop/app/src/main/res/drawable/image1.gif" alt="alt text" height="500px"> | <img src="https://github.com/jama5262/CarouselView/blob/develop/app/src/main/res/drawable/image2.gif" alt="alt text" height="500px"> | <img src="https://github.com/jama5262/CarouselView/blob/develop/app/src/main/res/drawable/image3.gif" height="500px">

## Installation

Current Version: [![Library Version](https://img.shields.io/badge/Library-v1.0.0-blue)](https://pub.dev/packages/jiffy)

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
    implementation 'com.github.User:Repo:Tag'
}
```

#### Maven

```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

```
<dependency>
    <groupId>com.github.User</groupId>
    <artifactId>Repo</artifactId>
    <version>Tag</version>
</dependency>
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
