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
  private RecyclerView recyclerView;
  private CarouselOffset carouselOffset;
  private boolean isOffsetStart;
  private int spacing;

  CarouselViewAdapter(CarouselViewListener carouselViewListener, int resource, int size, RecyclerView recyclerView, int spacing, boolean isOffsetStart) {
    this.carouselViewListener = carouselViewListener;
    this.resource = resource;
    this.size = size;
    this.recyclerView = recyclerView;
    this.isOffsetStart = isOffsetStart;
    this.spacing = spacing;
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
    if (this.carouselViewListener != null) {
      this.carouselViewListener.onBindView(holder.itemView, position);
    }
    this.carouselOffset.init(recyclerView, holder.itemView, this.spacing, this.isOffsetStart);
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
