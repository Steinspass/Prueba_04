package com.example.ndpsh.prueba_04;

/**
 * Created by Naim on 29/10/18
 */


public class Movie {

    public String name;
    public int poster;

   public Movie () {

   }

    public Movie(String name, int poster) {
        this.name = name;
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
