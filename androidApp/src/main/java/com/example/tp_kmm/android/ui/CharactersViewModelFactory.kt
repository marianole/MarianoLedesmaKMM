package com.example.tp_kmm.android.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tp_kmm.android.data.client.MarvelCharactersClient
import com.example.tp_kmm.android.data.service.CharactersService
import com.example.tp_kmm.android.ui.characters.CharactersViewModel
import com.example.tp_kmm.data.RepositoryImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharactersViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val repositoryImpl = RepositoryImpl()
        val service= CharactersService(repositoryImpl)

        /*val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(PublicKeyInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiClient = retrofit.create(MarvelCharactersClient::class.java)

        val charactersApi = RetrofitCharactersRepository(apiClient)
        val charactersService = CharactersService(charactersApi)*/
        return CharactersViewModel(service) as T
    }
}