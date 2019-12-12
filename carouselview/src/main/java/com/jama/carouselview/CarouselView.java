package com.jama.carouselview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.jama.carouselview.enums.IndicatorAnimationType;
import com.jama.carouselview.enums.OffsetType;
import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;

public class CarouselView extends FrameLayout {

  private PageIndicatorView pageIndicatorView;
  private RecyclerView carouselRecyclerView;
  private RecyclerView.LayoutManager layoutManager;
  private CarouselViewListener carouselViewListener;
  private IndicatorAnimationType indicatorAnimationType;
  private OffsetType offsetType;
  private SnapHelper snapHelper;
  private boolean enableSnapping = true;
  private int resource;
  private int size;
  private int spacing = 25;
  private boolean isResourceSet = false;
  private boolean isSizeSet = false;

  public CarouselView(@NonNull Context context) {
    super(context);
    init(context);
  }

  public CarouselView(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  private void init(final Context context) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View carouselView = inflater.inflate(R.layout.view_carousel, this);
    this.carouselRecyclerView = carouselView.findViewById(R.id.carouselRecyclerView);
    this.pageIndicatorView = carouselView.findViewById(R.id.pageIndicatorView);

    carouselRecyclerView.setHasFixedSize(false);
    this.layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
    carouselRecyclerView.setLayoutManager(this.layoutManager);

    this.setCarouselOffset(OffsetType.START);
    this.hideIndicator(false);
  }

  public void enableSnapping(boolean enable) {
    this.enableSnapping = enable;
  }

  private void setAdapter() {
    this.carouselRecyclerView.setAdapter(new CarouselViewAdapter(getCarouselViewListener(), getResource(), getSize(), carouselRecyclerView, this.getSpacing(), this.getOffsetType() == OffsetType.CENTER));
    if (this.enableSnapping) {
      this.snapHelper.attachToRecyclerView(this.carouselRecyclerView);
    }
    this.setScrollListener();
  }

  private void setScrollListener() {
    this.carouselRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
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

      @Override
      public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
      }
    });
  }

  public void setSize(int size) {
    this.size = size;
    this.pageIndicatorView.setCount(size);
    this.isSizeSet = true;
  }

  public int getSize() {
    return this.size;
  }

  public void setSpacing(int spacing) {
    this.spacing = spacing;
  }

  public int getSpacing() {
    return this.spacing;
  }

  public void setResource(int resource) {
    this.resource = resource;
    this.isResourceSet = true;
  }

  public int getResource() {
    return this.resource;
  }

  public void setIndicatorAnimationType(IndicatorAnimationType indicatorAnimationType) {
    this.indicatorAnimationType = indicatorAnimationType;
    switch (indicatorAnimationType) {
      case DROP:
        this.pageIndicatorView.setAnimationType(AnimationType.DROP);
        break;
      case FILL:
        this.pageIndicatorView.setAnimationType(AnimationType.FILL);
        break;
      case NONE:
        this.pageIndicatorView.setAnimationType(AnimationType.NONE);
        break;
      case SWAP:
        this.pageIndicatorView.setAnimationType(AnimationType.SWAP);
        break;
      case WORM:
        this.pageIndicatorView.setAnimationType(AnimationType.WORM);
        break;
      case COLOR:
        this.pageIndicatorView.setAnimationType(AnimationType.COLOR);
        break;
      case SCALE:
        this.pageIndicatorView.setAnimationType(AnimationType.SCALE);
        break;
      case SLIDE:
        this.pageIndicatorView.setAnimationType(AnimationType.SLIDE);
        break;
      case THIN_WORM:
        this.pageIndicatorView.setAnimationType(AnimationType.THIN_WORM);
        break;
      case SCALE_DOWN:
        this.pageIndicatorView.setAnimationType(AnimationType.SCALE_DOWN);
    }
  }

  public IndicatorAnimationType getIndicatorAnimationType() {
    return this.indicatorAnimationType;
  }

  public void setIndicatorSelectedColor(int color) {
    this.pageIndicatorView.setSelectedColor(color);
  }

  public int getIndicatorSelectedColor() {
    return this.pageIndicatorView.getSelectedColor();
  }

  public void setIndicatorUnselectedColor(int color) {
    this.pageIndicatorView.setUnselectedColor(color);
  }

  public int getIndicatorUnselectedColor() {
    return this.pageIndicatorView.getUnselectedColor();
  }

  public void setIndicatorRadius(int radius) {
    this.pageIndicatorView.setRadius(radius);
  }

  public int getIndicatorRadius() {
    return this.pageIndicatorView.getRadius();
  }

  public void setIndicatorPadding(int padding) {
    this.pageIndicatorView.setPadding(padding);
  }

  public int getIndicatorPadding() {
    return this.pageIndicatorView.getPadding();
  }

  public void hideIndicator(boolean hide) {
    if (hide) {
      this.pageIndicatorView.setVisibility(GONE);
    } else {
      this.pageIndicatorView.setVisibility(VISIBLE);
    }
  }

  public void setCarouselOffset(OffsetType offsetType) {
    this.offsetType = offsetType;
    switch (offsetType) {
      case CENTER:
        this.snapHelper = new LinearSnapHelper();
        break;
      case START:
        this.snapHelper = new CarouselSnapHelper();
        break;
    }
  }

  public OffsetType getOffsetType() {
    return this.offsetType;
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
    this.setAdapter();
  }

}
