package com.example.artur.tweet

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_tweet.view.*

class TweetAdapter(private val tweets: MutableList<Tweet>,
                   private val context: Context): RecyclerView.Adapter<TweetAdapter.ViewHolder>(){

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(tweet: Tweet){
            val nome = itemView.text_nome
            val username = itemView.text_username
            val texto = itemView.text_tweet
            val data = itemView.text_data

            nome.text = tweet.nomeAutor
            username.text = tweet.username
            texto.text = tweet.texto
            data.text = tweet.data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false))
    }

    override fun getItemCount(): Int {
        return tweets.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tweet = tweets[position]
        holder.bind(tweet)
    }

}