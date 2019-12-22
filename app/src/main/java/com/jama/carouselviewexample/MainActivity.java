package com.jama.carouselviewexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jama.carouselviewexample.examples.CenteredCarouselActivity;
import com.jama.carouselviewexample.examples.ImageCarouselActivity;
import com.jama.carouselviewexample.examples.StartCarouselActivity;


public class MainActivity extends AppCompatActivity {

  RecyclerView recyclerView;
  private RecyclerView.Adapter mAdapter;
  private RecyclerView.LayoutManager layoutManager;


  private String[] examples = {"Image Carousel Example", "Centered Carousel Example", "Start Carousel Example"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setHasFixedSize(true);
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    mAdapter = new Adapter(examples);
    recyclerView.setAdapter(mAdapter);


  }

  class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    private String[] mDataset;

    Adapter(String[] mDataset) {
      this.mDataset = mDataset;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.examples_items, parent, false);
      return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, final int position) {
      TextView textView = holder.itemView.findViewById(R.id.textViewExamples);
      textView.setText(mDataset[position]);
      textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          if (position == 0) {
            startActivity(new Intent(MainActivity.this, ImageCarouselActivity.class));
          } else if (position == 1) {
            startActivity(new Intent(MainActivity.this, CenteredCarouselActivity.class));
          } else if (position == 2) {
            startActivity(new Intent(MainActivity.this, StartCarouselActivity.class));
          }
        }
      });
    }

    @Override
    public int getItemCount() {
      return mDataset.length;
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
      AdapterViewHolder(@NonNull View itemView) {
        super(itemView);
      }
    }
  }
}
