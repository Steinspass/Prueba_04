package com.example.ndpsh.prueba_04.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ndpsh.prueba_04.Models.Movie;
import com.example.ndpsh.prueba_04.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 *  Created by Naim on 25/09/18
 */

public class Myadapter  extends RecyclerView.Adapter<Myadapter.ViewHolder> {

    // En el constructor
    private List<Movie> movies;
    private int layout;
    private OnItemClickListener itemClickListener;



    public Myadapter(List<Movie> movies, int layout, OnItemClickListener listener) {
        this.movies = movies;
        this.layout = layout;
        this.itemClickListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        // Es para inflar la vista y nuestro layout y lo pasamos directamente al constructor del ViewHolder
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    // Aqui volcamos los datos que nos den el objecto actual
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.bind(movies.get(position), itemClickListener);
    }

    @Override
    // Para saber el tamano de nuestra lista
    public int getItemCount() {
        return movies.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public ImageView imageViewPoster;

        public ViewHolder (View v) {
            super(v);
            textViewName = (TextView) itemView.findViewById(R.id.textViewTitle);
            imageViewPoster = (ImageView) itemView.findViewById(R.id.imageViewPoster);

        }
        // Aqui se le dice itemClickListener como funcionar y lo que debe hacer
        public void bind(final Movie movie, final OnItemClickListener listener) {
            textViewName.setText(movie.getName());
            Picasso.get().load(movie.getPoster()).fit().centerCrop().into(this.imageViewPoster);
            imageViewPoster.setImageResource(movie.getPoster());
            //this.textViewName.setText(movie);
            // El primer elemento es una vista y en su conjunto tambien es una vista.
            // Itemview es la instancia para la vista y luego tiene un layout en donde le decimos como quiere que se comporte
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Aqui le decimos como quiere que se comporte cuando se hace click
                   listener.onItemClick(movie, getAdapterPosition());
                }
            });
        }
    }

        public interface OnItemClickListener {
            void onItemClick(Movie movie, int position);
        }










}
