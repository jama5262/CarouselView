package com.jama.carouselview;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarouselItemDecoration extends RecyclerView.ItemDecoration {

  private int margin;
  private int width;

  CarouselItemDecoration(int width, int margin) {
    this.margin = margin;
    this.width = width;
  }

  @Override
  public void getItemOffsets(@NonNull final Rect outRect, @NonNull final View view, @NonNull final RecyclerView parent, @NonNull final RecyclerView.State state) {
    super.getItemOffsets(outRect, view, parent, state);

    outRect.right = this.width > 0 ? this.margin / 2 : this.margin;
    outRect.left = this.width > 0 ? this.margin / 2 : 0;

    if ((state.getItemCount() - 1 == parent.getChildLayoutPosition(view))) {
      outRect.right = this.width > 0 ? ((parent.getMeasuredWidth() / 2) - (this.width / 2)) : 0;
    }
    if (parent.getChildLayoutPosition(view) == 0) {
      outRect.left = this.width > 0 ? ((parent.getMeasuredWidth() / 2) - (this.width / 2)) : 0;
    }
  }
}
