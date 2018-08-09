package com.example.lenovo.imagefinder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Lenovo on 30-05-2018.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {
    List<Photo> imageDetails;
    Context c;
    public ImageAdapter(Context c, List<Photo> imageDetails) {
        this.c=c;
        this.imageDetails = imageDetails;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

            holder.Name_tv.setText(imageDetails.get(position).getId());

            Picasso.with(c).load(imageDetails.get(position).getUrlS()).into(holder.img);

        //Picasso.get().load(R.drawable.dsih_icon).into(holder.recipeimg);

    }

    @Override
    public int getItemCount() {
        return imageDetails.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name_tv;
        ImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);
            Name_tv=(TextView)itemView.findViewById(R.id.imagename);
            img=(ImageView) itemView.findViewById(R.id.image);
        }
    }
}
