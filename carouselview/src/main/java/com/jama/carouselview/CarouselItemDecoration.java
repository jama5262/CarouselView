package com.jama.carouselview;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarouselItemDecoration extends RecyclerView.ItemDecoration {

  private int width;

  CarouselItemDecoration(int width) {
    this.width = width;
  }

  @Override
  public void getItemOffsets(@NonNull final Rect outRect, @NonNull final View view, @NonNull final RecyclerView parent, @NonNull final RecyclerView.State state) {
    super.getItemOffsets(outRect, view, parent, state);

    outRect.left = 0;
    outRect.right = 0;

    if (parent.getChildLayoutPosition(view) == 0) {
      outRect.left = ((parent.getMeasuredWidth() / 2) - (width / 2));
    }
    else if ((state.getItemCount() - 1 == parent.getChildLayoutPosition(view))) {
      outRect.right = ((parent.getMeasuredWidth() / 2) - (width / 2));
      outRect.left = 10;
    }
    else {
      outRect.left = 10;
    }
  }
}
