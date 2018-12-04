package com.example.artur.appnutrientes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

//TMB = (11,3 x peso (kg)) + (16 x altura (metros)) + 901

class MainActivity : AppCompatActivity() {

    private lateinit var editNome: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViews()
    }

    private fun setUpViews() {
        editNome = edit_nome
    }

    fun prosseguir(view: View){

        val nome = editNome.text.toString()
        val intent = Intent(this, UserInfoActivity::class.java)

        intent.putExtra("nome", nome)
        startActivity(intent)
    }
}


