package com.cybernerd.animequote

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_quotes.*
import kotlinx.android.synthetic.main.quote_item_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Activity_Quotes : AppCompatActivity() {

    lateinit var animeQuoteAdapter : AnimeQuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        animeQuoteAdapter = AnimeQuoteAdapter(this)
        anime_quote_recycler.adapter = animeQuoteAdapter
        val layoutManager = LinearLayoutManager(this)
        anime_quote_recycler.layoutManager = layoutManager

        progressbar.visibility = View.VISIBLE
        getAnimeQuotesApi()


        button_show_next_quotes.setOnClickListener {
            progressbar.visibility = View.VISIBLE
            getAnimeQuotesApi()
        }







    }

    //Calling Api to get quotes
    @SuppressLint("ServiceCast")
    fun getAnimeQuotesApi() {

        MyApi.MyApi().getRandomAnimeQuotes().enqueue(object : Callback<AnimeModel>{
            override fun onResponse(call: Call<AnimeModel>, response: Response<AnimeModel>) {
                Log.d("anime","this is success :) ${response.body()}")

                animeQuoteAdapter.setAnimeData(response.body()!!)
                progressbar.visibility = View.GONE





            }

            override fun onFailure(call: Call<AnimeModel>, t: Throwable) {
                Log.d("anime","this failed :( ${t.message}")

            }

        })










    }

}