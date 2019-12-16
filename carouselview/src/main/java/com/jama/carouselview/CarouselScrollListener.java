package com.jama.carouselview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public interface CarouselScrollListener {

  void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState, int position);

  void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy);

}
