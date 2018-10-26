package com.example.ndpsh.prueba_04;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 *  Created by Naim on 25/09/18
 */

public class Myadapter  extends RecyclerView.Adapter<Myadapter.ViewHolder> {

    // En el constructor
    private List<String> names;
    private int layout;
    private OnItemClickListener itemClickListener;


    public Myadapter(List<String> names, int layout, OnItemClickListener listener) {
        this.names = names;
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
        holder.bind(names.get(position), itemClickListener);
    }

    @Override
    // Para saber el tamano de nuestra lista
    public int getItemCount() {
        return names.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;

        public ViewHolder (View v) {
            super(v);
            this.textViewName = (TextView) v.findViewById(R.id.textViewName);
        }
        // Aqui se le dice itemClickListener como funcionar y lo que debe hacer
        public void bind(final String name, final OnItemClickListener listener) {

            this.textViewName.setText(name);
            // El primer elemento es una vista y en su conjunto tambien es una vista.
            // Itemview es la instancia para la vista y luego tiene un layout en donde le decimos como quiere que se comporte
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Aqui le decimos como quiere que se comporte cuando se hace click
                   listener.onItemClick(name, getAdapterPosition());
                }
            });
        }
    }

        public interface OnItemClickListener {
            void onItemClick(String name, int position);
        }










}
