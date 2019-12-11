package com.jama.carouselview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import com.rd.PageIndicatorView;

import static android.content.Context.WINDOW_SERVICE;

public class CarouselView extends FrameLayout {

  private Context context;
  private PageIndicatorView pageIndicatorView;
  private ViewPager viewPager;
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

  private void init(final Context context) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View carouselView = inflater.inflate(R.layout.view_carousel, this);
    carouselRecyclerView = carouselView.findViewById(R.id.carouselRecyclerView);
    this.pageIndicatorView = carouselView.findViewById(R.id.pageIndicatorView);

    carouselRecyclerView.setHasFixedSize(false);
    layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
    carouselRecyclerView.setLayoutManager(layoutManager);

    pageIndicatorView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(context, "Ok", Toast.LENGTH_SHORT).show();
      }
    });

    final SnapHelper snapHelper = new LinearSnapHelper();
    snapHelper.attachToRecyclerView(carouselRecyclerView);

    carouselRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override
      public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        View centerView = snapHelper.findSnapView(layoutManager);
        int pos = layoutManager.getPosition(centerView);
        if (newState == RecyclerView.SCROLL_STATE_IDLE || (pos == 0 && newState == RecyclerView.SCROLL_STATE_DRAGGING)) {
          pageIndicatorView.setSelection(pos);
        } else {
          pageIndicatorView.setSelection(pos);
        }
      }

    });
  }

  private int getScreenWidth() {
    DisplayMetrics dm = new DisplayMetrics();
    WindowManager windowManager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
    windowManager.getDefaultDisplay().getMetrics(dm);
    return Math.round(dm.widthPixels / dm.density);
  }

  public void setSize(int size) {
    this.size = size;
    this.pageIndicatorView.setCount(size);
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
    carouselRecyclerView.setAdapter(new CarouselViewAdapter(getCarouselViewListener(), getResource(), getSize(), carouselRecyclerView));

//    carouselRecyclerView.addItemDecoration(new CarouselItemDecoration(layoutManager, context, getResource()));

  }

}
