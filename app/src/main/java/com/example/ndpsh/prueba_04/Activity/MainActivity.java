package com.example.ndpsh.prueba_04.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ndpsh.prueba_04.Models.Movie;
import com.example.ndpsh.prueba_04.Adapter.Myadapter;
import com.example.ndpsh.prueba_04.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movies;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = this.getAllMovies();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager = new GridLayoutManager(this, 2);
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);


        mAdapter = new Myadapter(movies, R.layout.recycler_view_item, new Myadapter.OnItemClickListener() {
            @Override
            public void onItemClick(Movie movie, int position) {
                removeMovie(position);
            }
        });


        // Si sabemos que el layout de nuestro item no va cambiar o ser mas grande, esto hace que mejore el performance y redimiento de la app
        mRecyclerView.setHasFixedSize(true);
        // Implementa una animacion
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_name:
                this.addMovie(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Lista de nombres
    private List<Movie> getAllMovies() {
        return new ArrayList<Movie>() {{
            add(new Movie("Django", R.drawable.undjango));
            add(new Movie("Seven Samurai", R.drawable.samuraiseven));
            add(new Movie("Oldboy", R.drawable.oldboy));
            add(new Movie("The Godfather II", R.drawable.godfatherii));
            add(new Movie("Skyfall", R.drawable.skyfall));
        }};
    }


    private void addMovie(int position) {
        movies.add(position, new Movie("new image" + (++counter), R.drawable.newmovie));
        // Notificamos de un nuevo item insertado en nuestra coleccion
        mAdapter.notifyItemInserted(position);
        // Hacemos scroll hacia la position donde  el nuevo elemento se aloja
        mLayoutManager.scrollToPosition(position);
    }
    private void removeMovie(int position){
        movies.remove(position);
        // Notificamos de un item borrado en nuestra colecion
        mAdapter.notifyItemRemoved(position);
    }
}






