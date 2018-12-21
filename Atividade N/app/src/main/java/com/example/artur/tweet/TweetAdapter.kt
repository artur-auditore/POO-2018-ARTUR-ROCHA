package com.example.artur.tweet

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.objectbox.Box

class TweetAdapter(private val tweets: MutableList<Tweet>,
                   private val tweetsBox: Box<Tweet>,
                   private val context: Context): RecyclerView.Adapter<TweetAdapter.ViewHolder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_tweet, p0, false))
    }

    override fun getItemCount(): Int {
        return tweets.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

    }

}