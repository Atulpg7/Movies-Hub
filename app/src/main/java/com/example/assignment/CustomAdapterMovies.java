package com.example.assignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapterMovies extends RecyclerView.Adapter<CustomAdapterMovies.ViewHolder>{

    //Context for Calling Activity and ArrayList for Movies.
    Context context;
    ArrayList<String> arrayList;


    //Settings the values.
    public CustomAdapterMovies(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Setting the custom view of movies.
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view_movie,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //getting and setting the url and thumbnail of movies.
        final String url=arrayList.get(position);
        Glide.with(context).load(url).into(holder.image);


        //Setting on click for get the details of particular movie.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Starting details activity and passing the url of movie's thubnail
                Intent intent=new Intent(context,DetailActivity.class);
                intent.putExtra("url",url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        //ImageView for thumbnail of Image
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Getting reference of ImageView.
            image=itemView.findViewById(R.id.image);
        }
    }
}
