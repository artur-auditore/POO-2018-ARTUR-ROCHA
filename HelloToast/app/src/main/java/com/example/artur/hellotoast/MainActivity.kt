package com.example.artur.hellotoast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mCount: Int = 0
    private lateinit var mShowCount: TextView
    private lateinit var editNumero: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViews()
    }

    private fun setUpViews(){
        mShowCount = show_count // equivale a findViewByID
        editNumero = edit_numero
    }

    private fun obterValor(): Int{
        val entrada = editNumero.text.toString()
        var valor = 0
        if (!entrada.trim().isEmpty()) valor = entrada.toInt()
        else Toast.makeText(this, "Digite um valor!", Toast.LENGTH_SHORT).show()

        return valor
    }

    fun toast(view: View){
        val toast = Toast.makeText(this, getString(R.string.hello_toast), Toast.LENGTH_SHORT)
        toast.show()
    }

    fun incrementar(view: View){
        mCount += obterValor()
        mShowCount.text = mCount.toString()
    }

    fun decrementar(view: View){
        mCount -= obterValor()
        mShowCount.text = mCount.toString()
    }
}
