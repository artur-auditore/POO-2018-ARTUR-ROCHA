package com.example.artur.appnutrientes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : AppCompatActivity() {

    private lateinit var textSaudacao: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        setUpViews()
    }

    private fun setUpViews() {
        textSaudacao = text_saudacao

        val saudacao = "Olá ${intent.getStringExtra("nome")}, digite suas informações"
        textSaudacao.text = saudacao
    }

}
