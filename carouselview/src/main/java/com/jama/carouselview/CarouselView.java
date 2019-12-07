package com.jama.carouselview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

public class CarouselView extends FrameLayout {

  private ViewPager2 viewPager2;
  private CompositePageTransformer compositePageTransformer;
  private CarouselViewListener carouselViewListener;
  private int resource;
  private int size;
  private boolean isResourceSet = false;
  private boolean isSizeSet = false;
  private int margin = 0;

  public CarouselView(@NonNull Context context) {
    super(context);
    init(context);
  }

  public CarouselView(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  private void init(Context context) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View carouselView = inflater.inflate(R.layout.view_carousel, this);
    this.viewPager2 = carouselView.findViewById(R.id.carouselViewPager2);
    this.viewPager2.setOffscreenPageLimit(1);
    this.viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
    this.compositePageTransformer = new CompositePageTransformer();
  }

  public void setSize(int size) {
    this.size = size;
    this.isSizeSet = true;
  }

  public int getSize() {
    return this.size;
  }

  public void setResource(int resource) {
    this.resource = resource;
    this.isResourceSet = true;
  }

  public int getResource() {
    return this.resource;
  }

  public void setMargin(int margin) {
    if (margin < 0) {
      throw new IllegalArgumentException("Margin cannot be negative");
    }
    this.margin = margin;
  }

  public int getMargin() {
    return this.margin;
  }

  public void setCarouselViewListener(CarouselViewListener carouselViewListener) {
    this.carouselViewListener = carouselViewListener;
  }

  public CarouselViewListener getCarouselViewListener() {
    return this.carouselViewListener;
  }

  public void validate() {
    if (this.carouselViewListener == null) throw new RuntimeException("A carouselviewlistener is need");
    else if (!this.isResourceSet) throw new RuntimeException("A resource to a view is needed");
    else if (!this.isSizeSet) throw new RuntimeException("A size is needed");
  }

  public void show() {
    this.validate();
    this.viewPager2.setAdapter(new CarouselViewAdapter(this.getCarouselViewListener(), this.getResource(), this.getSize()));

    this.compositePageTransformer.addTransformer(new MarginPageTransformer(getMargin()));

    viewPager2.setPageTransformer(compositePageTransformer);
  }

}
