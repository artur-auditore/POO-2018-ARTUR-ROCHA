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
        tweetsBox.put(Tweet("Artur", "@artur_auditore",
            "Deus tenha misericórdia dessa nação", "21/12/2018"))
        tweetsBox.put(Tweet("Hadadd 13", "@Haddad_Fernando",
            "Bora pro debate @jairbolsonaro", "16/10/2018"))
        tweetsBox.put(Tweet("Jair Bolsonaro", "@jairbolsonaro",
            "Brasil acima de tudo, Deus acima de todos!", "28/10/2018"))
        tweetsBox.put(Tweet("Quebrando o Tabu", "@aquebrandotabu",
            "Ninguém solta a mão de ninguém", "21/12/2018"))
        tweetsBox.put(Tweet("CBM", "@cbmon",
            "Conservador nos costumes e liberal na economia é a piada do ano", "01/08/2018"))
        tweetsBox.put(Tweet("Neymar", "@neymarjr",
            "pior copa foi a desse ano", "11/07/2022"))

        for (i in 0 .. 994){
            tweetsBox.put(Tweet("Artur", "@artur_auditore",
                "Deus tenha misericórdia dessa nação", "21/12/2018"))
        }
    }
}
