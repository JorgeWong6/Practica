package com.example.jorge.uno.models;

import java.util.ArrayList;

/**
 * Created by Jorge on 19/10/2017.
 */

public class PokemonRespuesta {

    private ArrayList<Pokemon> results;
    public ArrayList<Pokemon> getResults(){
        return results;

    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }

}
