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
import com.latihan.android.cfreelance_2nd.Model.Forum;

import java.util.ArrayList;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ViewHolder> {

    private static final String TAG = "ForumAdapter";
    
    private Context mContext;
    private ArrayList<Forum> forums = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CardView parent;
        private ImageView imgForum;
        private TextView txtPersonName, txtForumTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgForum = itemView.findViewById(R.id.imgForum);
            txtPersonName = itemView.findViewById(R.id.txtPersonName);
            txtForumTitle = itemView.findViewById(R.id.txtForumTitle);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_forum_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: Called");

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, forums.get(position).getForumTitle() + " Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(mContext)
                .asBitmap()
                .load(forums.get(position).getForumImageUrl())
                .into(holder.imgForum);

        holder.txtPersonName.setText(forums.get(position).getForumPersonName());
        holder.txtForumTitle.setText(forums.get(position).getForumTitle());

    }

    @Override
    public int getItemCount() {
        return forums.size();
    }

    public ForumAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setForums(ArrayList<Forum> forums) {
        this.forums = forums;
        notifyDataSetChanged();
    }
}