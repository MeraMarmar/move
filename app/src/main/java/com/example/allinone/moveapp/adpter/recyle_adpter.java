package com.example.allinone.moveapp.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.allinone.moveapp.R;
import com.example.allinone.moveapp.models.move;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class recyle_adpter extends RecyclerView.Adapter<recyle_adpter.holder> {
    ArrayList<move>movies;
    Context con;
    public recyle_adpter(ArrayList<move>movies ,Context con){
      this.movies=movies;
      this.con=con;
    }
    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item,viewGroup,false);
        holder holder=new holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int i) {
        holder.title.setText(movies.get(i).getTitle());
        holder.rate.setText(movies.get(i).getRate());
        holder.date.setText(movies.get(i).getDate());
        holder.overview.setText(movies.get(i).getOverview());
        holder.type.setText(movies.get(i).getType());
        Picasso.with(con).load("http://image.tmdb.org/t/p/w185"+movies.get(i).getImagepath()).placeholder(R.drawable.m1).into(holder.image_movie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class holder extends RecyclerView.ViewHolder{
     TextView title,date,rate,overview,type;
     ImageView image_movie;
        public holder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.txt_title);
            date=itemView.findViewById(R.id.txt_date);
            rate=itemView.findViewById(R.id.txt_rate);
            overview=itemView.findViewById(R.id.txt_overview);
            type=itemView.findViewById(R.id.txt_type);
            image_movie=itemView.findViewById(R.id.image_movie);

        }
    }
}
