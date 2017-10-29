package com.example.ok.makhtotat;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class IndianMoviesAdapter extends RecyclerView.Adapter<IndianMoviesAdapter.IndanMovieHolder> implements View.OnClickListener {

    List<IndianMovie> moviesList;
    allmkktota allmkktota;
    Context context;
    public  static  int position;

    public IndianMoviesAdapter(List<IndianMovie> moviesList, Context context, allmkktota allmkktota) {
        this.moviesList = moviesList;
        this.allmkktota = allmkktota;
        this.context = context;


    }

    @Override
    public IndanMovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.indian_movie_row, parent, false);
        IndanMovieHolder holder = new IndanMovieHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(IndanMovieHolder holder, int position) {

        IndianMovie movie = moviesList.get(position);
        holder.movietitle.setText(movie.movieName);
        holder.moviedesc.setText(movie.movieStory+"");
        Picasso.with(context).load(movie.posterImage).into(holder.poster);

        holder.lin.setTag(position);


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    @Override
    public void onClick(View view) {

    }

    class IndanMovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView movietitle, moviedesc;
        ImageView poster;
        LinearLayout lin;

        public IndanMovieHolder(View itemView) {
            super(itemView);
            movietitle = (TextView) itemView.findViewById(R.id.movietitleTV);
            moviedesc = (TextView) itemView.findViewById(R.id.moviedescTV);
            poster = (ImageView) itemView.findViewById(R.id.movieposteIMG);
            lin = (LinearLayout) itemView.findViewById(R.id.line1);

            lin.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

             position = (int) view.getTag();
            IndianMovie movie = moviesList.get(position);


           // Toast.makeText(allmkktota, ""+position, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(allmkktota, gallary.class);

            intent.putExtra("title", movie.movieName);

            allmkktota.startActivity(intent);


        }
    }

}



