package com.jama.carouselviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jama.carouselview.CarouselView;

public class MainActivity extends AppCompatActivity {

  CarouselView carouselView;
  String[] data = {"1", "2", "3"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    carouselView = findViewById(R.id.carouselView);
    carouselView.setSize(data.length);
    carouselView.setResource(R.layout.item);
    carouselView.show();

  }
}
