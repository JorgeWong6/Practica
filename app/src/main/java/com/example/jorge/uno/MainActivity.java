package com.example.jorge.uno;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.jorge.uno.models.Pokemon;
import com.example.jorge.uno.models.PokemonRespuesta;
import com.example.jorge.uno.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "POKEDEX";
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obternerDatos();

    }

    private void obternerDatos() {
        PokeapiService service = retrofit.create(PokeapiService.class);
        Call<PokemonRespuesta> pokemonRespuestaCall = service.obtenerListaPokemon();

        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
            if (response.isSuccessful()){

                PokemonRespuesta pokemonRespuesta = response.body();
                ArrayList<Pokemon> listaPokemon = pokemonRespuesta.getResults();

                for (int i = 0; i < listaPokemon.size(); i++){
                    Pokemon p = listaPokemon.get(i);
                    Log.i(TAG, " Pokemon: " + p.getNamel());
                }

            } else{
                Log.e(TAG, " onResponse: " + response.errorBody());
            }
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                Log.e(TAG, " onFailure: " + t.getMessage());

            }
        }
        );



    }

}
