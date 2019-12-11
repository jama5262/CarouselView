package com.jama.carouselview;

import android.content.Context;
import android.graphics.Rect;

import android.view.View;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarouselItemDecoration extends RecyclerView.ItemDecoration {

  private int horizontalMarginInPx;

  public CarouselItemDecoration(Context context, @DimenRes int dimen) {
    this.horizontalMarginInPx = (int) context.getResources().getDimension(dimen);
  }

  @Override
  public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
    super.getItemOffsets(outRect, view, parent, state);

    outRect.right = this.horizontalMarginInPx / 10;
    if (parent.getChildLayoutPosition(view) == 0) {
          outRect.left = this.horizontalMarginInPx;
    }
    if (state.getItemCount() - 1 == parent.getChildLayoutPosition(view)) {
      outRect.right = this.horizontalMarginInPx;
    }
  }
}
