package com.latihan.android.cfreelance_2nd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.latihan.android.cfreelance_2nd.Model.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private static final String TAG = "CategoryAdapter";
    
    private Context mContext;
    private ArrayList<Category> categories = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder{

       private CardView parent;
       private ImageView imgCategory;
       private TextView txtCategoryName;

       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           parent = itemView.findViewById(R.id.parent);
           imgCategory = itemView.findViewById(R.id.imgCategory);
           txtCategoryName = itemView.findViewById(R.id.txtCategoryName);
       }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_category_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //ignore this
        Log.d(TAG, "onBindViewHolder: Called");

        //make a toast message when you clicked a holder
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, categories.get(position).getCategoryName(), Toast.LENGTH_SHORT).show();
            }
        });

        //change its categoryName
        holder.txtCategoryName.setText(categories.get(position).getCategoryName());

        //provide picture from imageUrl
        Glide.with(mContext)
                .asBitmap()
                .load(categories.get(position).getCategoryImageUrl())
                .into(holder.imgCategory);

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public CategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }
}