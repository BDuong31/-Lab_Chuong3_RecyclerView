package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull; // <-- Import NonNull
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    // It's good practice to make the list final if it's only set in the constructor
    private final List<Food> foodList;

    public FoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }

    // This method is now correctly annotated with @NonNull
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    // This method is now correctly annotated with @NonNull
    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.foodNameTextView.setText(food.getName());
        holder.foodImageView.setImageResource(food.getImageResId());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    // Method name typo corrected from "removeltem" to "removeItem"
    public void removeItem(int position) {
        foodList.remove(position);
        notifyItemRemoved(position);
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImageView;
        TextView foodNameTextView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.foodImageView);
            foodNameTextView = itemView.findViewById(R.id.foodNameTextView);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Toast.makeText(v.getContext(), "Bạn chọn: " + foodList.get(position).getName(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}