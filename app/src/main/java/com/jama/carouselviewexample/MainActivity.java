package com.jama.carouselviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jama.carouselview.CarouselView;
import com.jama.carouselview.CarouselViewListener;

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
    carouselView.setCarouselViewListener(new CarouselViewListener() {
      @Override
      public void setItemPosition(View view, final int position) {
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(data[position]);
        textView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Toast.makeText(MainActivity.this, "This is number " + data[position], Toast.LENGTH_SHORT).show();
          }
        });
      }
    });
    carouselView.show();

  }
}
