package com.example.artur.tweet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.artur.tweet.dal.ObjectBox
import io.objectbox.Box
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var rvTweets: RecyclerView
    private lateinit var tweetsBox: Box<Tweet>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tweetsBox = ObjectBox.boxStore.boxFor(Tweet::class.java)

        //addTweets()

        rvTweets = rv_tweets

        val tweetsAdapter = TweetAdapter(tweetsBox.all, this)
        rvTweets.adapter = tweetsAdapter

        rvTweets.layoutManager = LinearLayoutManager(this)
    }

    private fun addTweets(){
        for (i in 0 .. 1000){
            tweetsBox.put(Tweet("Artur", "@artur_auditore",
                "Deus tenha misericórdia dessa nação", "21/12/2018"))
        }
    }
}
