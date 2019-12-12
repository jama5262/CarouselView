package com.jama.carouselview;

import android.view.View;
import android.view.ViewTreeObserver;

import androidx.recyclerview.widget.RecyclerView;

public class CarouselOffset {

  public void init(final RecyclerView recyclerView, final View view) {
    view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
      @Override
      public void onGlobalLayout() {
        if (recyclerView.getItemDecorationCount() > 0) {
          recyclerView.removeItemDecorationAt(0);
        }
        recyclerView.addItemDecoration(new CarouselItemDecoration(view.getWidth()), 0);
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    });
  }
}
