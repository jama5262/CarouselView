package com.jama.carouselviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jama.carouselview.CarouselView;
import com.jama.carouselview.CarouselViewListener;
import com.jama.carouselview.enums.IndicatorAnimationType;
import com.jama.carouselview.enums.OffsetType;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

  CarouselView carouselView;
  CarouselView carouselView2;
  String[] data = {"#EF5350", "#EC407A", "#AB47BC", "#4CAF50", "#FFA726", "#78909C", "#FFA726"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    carouselView = findViewById(R.id.carouselView);
    carouselView.setSize(10);
    carouselView.setIndicatorAnimationType(IndicatorAnimationType.FILL);
    carouselView.setResource(R.layout.item);
    carouselView.setIndicatorSelectedColor(Color.parseColor(data[5]));
    carouselView.setIndicatorUnselectedColor(Color.parseColor(data[0]));
    carouselView.setIndicatorRadius(5);
    carouselView.setIndicatorPadding(5);
    carouselView.setCarouselOffset(OffsetType.CENTER);
    carouselView.setCarouselViewListener(new CarouselViewListener() {
      @Override
      public void setItemPosition(View view, final int position) {
        CardView cardView = view.findViewById(R.id.cardView);
        TextView textView = view.findViewById(R.id.textView);
        cardView.setCardBackgroundColor(Color.parseColor(data[new Random().nextInt(7)]));
        textView.setText((position + 1 + ""));
      }
    });
    carouselView.show();

    carouselView2 = findViewById(R.id.carouselView2);
    carouselView2.setSize(10);
    carouselView2.setIndicatorAnimationType(IndicatorAnimationType.SWAP);
    carouselView2.setResource(R.layout.item);
    carouselView2.setIndicatorSelectedColor(Color.parseColor(data[5]));
    carouselView2.setIndicatorUnselectedColor(Color.parseColor(data[0]));
    carouselView2.setIndicatorRadius(5);
    carouselView2.setIndicatorPadding(5);
    carouselView2.hideIndicator(true);
//    carouselView2.enableSnapping(false);
    carouselView2.setCarouselViewListener(new CarouselViewListener() {
      @Override
      public void setItemPosition(View view, final int position) {
        CardView cardView = view.findViewById(R.id.cardView);
        TextView textView = view.findViewById(R.id.textView);
        cardView.setCardBackgroundColor(Color.parseColor(data[new Random().nextInt(7)]));
        textView.setText((position + 1 + ""));
      }
    });
    carouselView2.show();
  }
}
