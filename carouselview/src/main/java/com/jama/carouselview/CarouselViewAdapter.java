package com.jama.carouselview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarouselViewAdapter extends RecyclerView.Adapter<CarouselViewAdapter.CarouselAdapterViewHolder> {

  private CarouselViewListener carouselViewListener;
  private int resource;
  private int size;

  public CarouselViewAdapter(CarouselViewListener carouselViewListener, int resource, int size) {
    this.carouselViewListener = carouselViewListener;
    this.resource = resource;
    this.size = size;
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
