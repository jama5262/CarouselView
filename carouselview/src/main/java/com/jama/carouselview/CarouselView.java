package com.jama.carouselview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

public class CarouselView extends FrameLayout {

  private Context context;
  RecyclerView carouselRecyclerView;
  private RecyclerView.LayoutManager layoutManager;
  private CarouselViewListener carouselViewListener;
  private int resource;
  private int size;
  private boolean isResourceSet = false;
  private boolean isSizeSet = false;

  public CarouselView(@NonNull Context context) {
    super(context);
    this.context = context;
    init(context);
  }

  public CarouselView(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    this.context = context;
    init(context);
  }

  private void init(Context context) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View carouselView = inflater.inflate(R.layout.view_carousel, this);
    carouselRecyclerView = carouselView.findViewById(R.id.carouselRecyclerView);
    Button button = carouselView.findViewById(R.id.button);
    carouselRecyclerView.setHasFixedSize(false);
    layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
    carouselRecyclerView.setLayoutManager(layoutManager);

    final SnapHelper snapHelper = new PagerSnapHelper();
    snapHelper.attachToRecyclerView(carouselRecyclerView);

//    recyclerView.addItemDecoration(new CarouselItemDecoration(context, R.dimen.viewpager_current_item_horizontal_margin));
//
//    recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//      @Override
//      public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//        super.onScrollStateChanged(recyclerView, newState);
//        View centerView = snapHelper.findSnapView(layoutManager);
//        Button button = carouselView.findViewById(R.id.button2);
//        int pos = layoutManager.getPosition(centerView);
//        if (newState == RecyclerView.SCROLL_STATE_IDLE || (pos == 0 && newState == RecyclerView.SCROLL_STATE_DRAGGING)) {
//          button.setText((pos + 1) + "");
//        } else {
//          button.setText((pos + 1) + "");
//        }
//
//      }
//
//      @Override
//      public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//        super.onScrolled(recyclerView, dx, dy);
//        Log.e("jjj", dx+ "");
//      }
//    });
  }

  public void setSize(int size) {
    this.size = size;
    this.isSizeSet = true;
  }

  public int getSize() {
    return this.size;
  }

  public void setResource(int resource) {
    this.resource = resource;
    this.isResourceSet = true;
  }

  public int getResource() {
    return this.resource;
  }

  public void setCarouselViewListener(CarouselViewListener carouselViewListener) {
    this.carouselViewListener = carouselViewListener;
  }

  public CarouselViewListener getCarouselViewListener() {
    return this.carouselViewListener;
  }

  public void validate() {
    if (this.carouselViewListener == null) throw new RuntimeException("A carouselviewlistener is need");
    else if (!this.isResourceSet) throw new RuntimeException("A resource to a view is needed");
    else if (!this.isSizeSet) throw new RuntimeException("A size is needed");
  }

  public void show() {
    this.validate();
    carouselRecyclerView.setAdapter(new CarouselViewAdapter(this.getCarouselViewListener(), this.getResource(), this.getSize()));
      }

}
