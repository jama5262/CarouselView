package com.jama.carouselviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import android.widget.Toast;

import com.jama.carouselview.CarouselView;
import com.jama.carouselview.CarouselViewListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

  CarouselView carouselView;
  String[] data = {"#EF5350", "#EC407A", "#AB47BC", "#4CAF50", "#FFA726", "#78909C", "#FFA726"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    carouselView = findViewById(R.id.carouselView);
    carouselView.setSize(20);
    carouselView.setResource(R.layout.item);
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
  }
}
