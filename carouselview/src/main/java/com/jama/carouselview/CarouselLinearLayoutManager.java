package com.jama.carouselview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CarouselLinearLayoutManager extends LinearLayoutManager {

  // Shrink the cards around the center up to 50%
  private final float mShrinkAmount = 0.5f;
  // The cards will be at 50% when they are 75% of the way between the
  // center and the edge.
  private final float mShrinkDistance = 0.9f;

  public CarouselLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
    super(context, orientation, reverseLayout);
  }

  @Override
  public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
    super.onLayoutChildren(recycler, state);
    scrollHorizontallyBy(0, recycler, state);
  }

  @Override
  public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
    int orientation = getOrientation();
    if (orientation == HORIZONTAL) {
      int scrolled = super.scrollHorizontallyBy(dx, recycler, state);

      for (int i = 0; i < getChildCount(); i++) {
        View child = getChildAt(i);
        float parentWidth = getWidth();
        float parentWidthHalf = parentWidth / 2.f;
        float childWidth = child.getRight() - child.getLeft();
        float childWidthHalf = childWidth / 2.f;
        float boundLeft = parentWidthHalf - childWidthHalf;
        float boundRight = parentWidthHalf + childWidthHalf;
        float childCenter = child.getLeft() + childWidthHalf;

        if (childCenter >= boundLeft && childCenter <= boundRight) {
          child.setScaleX(1f);
          child.setScaleY(1f);
        } else {
          child.setScaleX(.6f);
          child.setScaleY(.6f);
        }
      }
      return scrolled;
    } else {
      return 0;
    }
  }
}
