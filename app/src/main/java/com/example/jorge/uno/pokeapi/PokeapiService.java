package com.example.jorge.uno.pokeapi;

import com.example.jorge.uno.models.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Jorge on 19/10/2017.
 */

public interface PokeapiService {

    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon();


}
