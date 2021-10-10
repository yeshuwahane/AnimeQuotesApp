package com.cybernerd.animequote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val newEndPoint = "quotes"
private const val BASE_URL = "https://animechan.vercel.app/api/"
interface MyApi {

    interface MyApi {

        companion object{
            operator fun invoke(): MyApi{
                return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(MyApi::class.java)
            }
        }

        @GET(newEndPoint)
        fun getRandomAnimeQuotes(): Call<AnimeModel>
    }
}