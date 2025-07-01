package com.example.myapplication;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView detailImageView = findViewById(R.id.detailImageView);
        TextView detailTextView = findViewById(R.id.detailTextView);
        Food food = getIntent().getParcelableExtra("foodItem");

        if (food != null) {
            detailImageView.setImageResource(food.getImageResId());
            detailTextView.setText("Tên: " + food.getName() +
                    "\nMô tả: " + food.getDescription() +
                    "\nGiá: " + food.getPrice() + " VND");

            SharedPreferences prefs = getSharedPreferences("LastViewedFood", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("lastFoodName", food.getName());
            editor.apply();
        }

        Button orderButton = findViewById(R.id.orderButton);
        orderButton.setOnClickListener(v -> {
            Toast.makeText(this, "Bạn đã gọi món: " + food.getName(), Toast.LENGTH_SHORT).show();
            SharedPreferences prefs = getSharedPreferences("OrderedFood", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("orderedFoodName", food.getName());
            editor.apply();
        });
    }
}