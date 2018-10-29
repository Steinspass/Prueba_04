package com.example.ndpsh.prueba_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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
            public void onItemClick(Movie movies, int position) {

            }
            //Toast.makeText(MainActivity.this, name + "" + " - " + position, Toast.LENGTH_LONG).show();
            //deleteName(position);
        });


        // Si sabemos que el layout de nuestro item no va cambiar o ser mas grande, esto hace que mejore el performance y redimiento de la app
        //mRecyclerView.setHasFixedSize(true);
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

        switch (item.getItemId()){
            case R.id.add_name:
                //this.addName(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
        // Lista de nombres
    private  List<Movie> getAllMovies() {
        return new ArrayList<Movie>() {{
           add(new Movie("Django", R.drawable.undjango));
           add(new Movie("Seven_Samurai", R.drawable.samuraiseven));
           add(new Movie("Oldboy", R.drawable.oldboy));
           add(new Movie("The Godfather II", R.drawable.godfatherii));
           add(new Movie ("Skyfall", R.drawable.skyfall));
        }};
    }
//  Agregar nombre
//    private void addName(int position) {
//        movies.add(position, "New Movie" +(++counter));
//        mAdapter.notifyItemInserted(position);
//        mLayoutManager.scrollToPosition(position);
//    } // Borrar nombre
//    private void deleteName(int position){
//        movies.remove(position);
//        mAdapter.notifyItemRemoved(position);
    }

