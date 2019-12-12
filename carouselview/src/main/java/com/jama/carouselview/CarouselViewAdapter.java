package com.jama.carouselview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarouselViewAdapter extends RecyclerView.Adapter<CarouselViewAdapter.CarouselAdapterViewHolder> {

  private CarouselViewListener carouselViewListener;
  private int resource;
  private int size;
  private RecyclerView recyclerView;

  public CarouselViewAdapter(CarouselViewListener carouselViewListener, int resource, int size, RecyclerView recyclerView) {
    this.carouselViewListener = carouselViewListener;
    this.resource = resource;
    this.size = size;
    this.recyclerView = recyclerView;
  }

  @NonNull
  @Override
  public CarouselAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(this.resource, parent, false);
    return new CarouselAdapterViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull CarouselAdapterViewHolder holder, int position) {
    carouselViewListener.setItemPosition(holder.itemView, position);
    final View v = holder.itemView;
    v.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
      @Override
      public void onGlobalLayout() {
        Log.e("jjj", v.getWidth() + " " + v.getMeasuredWidth());
        if (recyclerView.getItemDecorationCount() > 0) {
          recyclerView.removeItemDecorationAt(0);
        }
        recyclerView.addItemDecoration(new CarouselItemDecoration(v.getWidth()), 0);
        v.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    });
  }

  @Override
  public int getItemCount() {
    return this.size;
  }

  static class CarouselAdapterViewHolder extends RecyclerView.ViewHolder {

   CarouselAdapterViewHolder(@NonNull View itemView) {
     super(itemView);
   }
 }

}
