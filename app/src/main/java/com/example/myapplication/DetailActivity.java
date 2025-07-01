package com.example.myapplication;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView detailImageView = findViewById(R.id.detailImageView);
        TextView detailTextView = findViewById(R.id.detailTextView);

        // Nhận dữ liệu từ Intent
        String foodName = getIntent().getStringExtra("foodName");
        int foodImage = getIntent().getIntExtra("foodImage", 0);
        String foodDescription = getIntent().getStringExtra("foodDescription");
        double foodPrice = getIntent().getDoubleExtra("foodPrice", 0);

        // Gán dữ liệu lên các View
        detailImageView.setImageResource(foodImage);
        String detailText = "Tên món ăn: " + foodName +
                "\nMô tả: " + foodDescription +
                "\nGiá: " + foodPrice + " VND";
        detailTextView.setText(detailText);
    }
}