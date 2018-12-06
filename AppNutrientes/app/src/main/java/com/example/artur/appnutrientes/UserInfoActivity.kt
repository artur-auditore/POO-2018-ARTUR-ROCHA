package com.example.artur.appnutrientes


import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : AppCompatActivity() {

    object constants{
        const val TBM = "tbm"
    }
    private lateinit var textSaudacao: TextView
    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        setUpViews()
        saudacao()
    }

    private fun setUpViews() {
        textSaudacao = text_saudacao

        editPeso = edit_peso
        editAltura = edit_altura
    }

    private fun saudacao(){
        val saudacao = "Olá ${intent.getStringExtra("nome")}, digite suas informações"
        textSaudacao.text = saudacao
    }

    //TMB = (11,3 x peso (kg)) + (16 x altura (metros)) + 901
    fun calculoTBM(peso: Double, altura: Double): Double{
        return ((11.3 * peso) + (16 * altura) + 901)
    }

    fun calcularTBM(view: View){

        val peso = editPeso.text.toString()
        val altura = editPeso.text.toString()

        if (peso.trim() == "" || altura.trim() == ""){
            Toast.makeText(this, "Digite valores válidos!", Toast.LENGTH_SHORT).show()
        } else {

            val tbm = calculoTBM(peso.toDouble(), altura.toDouble())

            val intent = Intent()
            intent.putExtra(constants.TBM, tbm)

            setResult(Activity.RESULT_OK, intent); finish()
        }

    }
}
