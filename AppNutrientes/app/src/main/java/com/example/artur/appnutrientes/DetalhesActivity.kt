package com.example.artur.appnutrientes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detalhes.*

class DetalhesActivity : AppCompatActivity() {

    private lateinit var textNome: TextView
    private lateinit var textTBM: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        setUpViews()
    }

    private fun setUpViews() {
        textNome = nome_usuario
        textTBM = text_tbm_tela3
    }
}
