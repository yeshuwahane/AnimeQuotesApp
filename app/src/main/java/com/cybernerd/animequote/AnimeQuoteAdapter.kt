package com.cybernerd.animequote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimeQuoteAdapter(val context : Context): RecyclerView.Adapter<AnimeQuoteAdapter.MyViewholder>() {


    var data: List<AnimeModelItem> = arrayListOf()

    fun setAnimeData(data: List<AnimeModelItem>){
        this.data = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewholder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.quote_item_layout,parent,false)
        return MyViewholder(view)
    }

    override fun onBindViewHolder(holder: MyViewholder, position: Int) {

        holder.animeName.text = data[position].anime
        holder.animeCharacterName.text = data[position].character
        holder.animeCharacterQuote.text = data[position].quote


    }

    override fun getItemCount(): Int {
        return  data.size
    }

    class MyViewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var animeName = itemView.findViewById<TextView>(R.id.anime_name)
        var animeCharacterName = itemView.findViewById<TextView>(R.id.anime_character_name)
        var animeCharacterQuote = itemView.findViewById<TextView>(R.id.anime_quote)
    }
}