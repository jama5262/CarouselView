package com.jama.carouselview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jama.carouselview.enums.OffsetType;

public class CarouselViewAdapter extends RecyclerView.Adapter<CarouselViewAdapter.CarouselAdapterViewHolder> {

  private CarouselViewListener carouselViewListener;
  private int resource;
  private int size;
  private RecyclerView recyclerView;
  private CarouselOffset carouselOffset;
  private boolean isOffsetStart;

  public CarouselViewAdapter(CarouselViewListener carouselViewListener, int resource, int size, RecyclerView recyclerView, boolean isOffsetStart) {
    this.carouselViewListener = carouselViewListener;
    this.resource = resource;
    this.size = size;
    this.recyclerView = recyclerView;
    this.isOffsetStart = isOffsetStart;
    this.carouselOffset = new CarouselOffset();
  }

  @NonNull
  @Override
  public CarouselAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(this.resource, parent, false);
    return new CarouselAdapterViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull CarouselAdapterViewHolder holder, int position) {
    this.carouselViewListener.setItemPosition(holder.itemView, position);
    if (this.isOffsetStart) {
      this.carouselOffset.init(recyclerView, holder.itemView);
    }
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
