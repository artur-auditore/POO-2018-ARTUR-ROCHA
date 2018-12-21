package com.example.artur.tweet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.artur.tweet.dal.ObjectBox
import io.objectbox.Box

class MainActivity : AppCompatActivity() {

    private lateinit var tweetsBox: Box<Tweet>
    private lateinit var tweet: Tweet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tweetsBox = ObjectBox.boxStore.boxFor(Tweet::class.java)
    }
}
