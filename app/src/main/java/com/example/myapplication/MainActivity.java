package com.example.myapplication;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;
    private List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Khởi tạo danh sách dữ liệu
        foodList = new ArrayList<>();
        foodList.add(new Food("Phở", R.drawable.pho));
        foodList.add(new Food("Bún chả", R.drawable.buncha));
        foodList.add(new Food("Bánh mì", R.drawable.banhmi));
        foodList.add(new Food("Cơm tấm", R.drawable.comtam));
        foodList.add(new Food("Gỏi cuốn", R.drawable.goicuon));

        // Khởi tạo Adapter và gán cho RecyclerView
        foodAdapter = new FoodAdapter(foodList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(foodAdapter);

        // Cấu hình vuốt để xóa
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false; // Không xử lý kéo thả
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                foodAdapter.removeItem(viewHolder.getAdapterPosition());
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}