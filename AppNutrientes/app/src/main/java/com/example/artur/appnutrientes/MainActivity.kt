package com.example.artur.appnutrientes


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    object constants{
        const val NOME = "nome"
        const val REQUEST_CODE = 1
    }
    private lateinit var editNome: EditText
    private lateinit var textTBM: TextView
    private lateinit var textoSelecione: TextView
    private lateinit var botoes: RadioGroup
    var decimalFormat = DecimalFormat("#####.#")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViews()
    }

    private fun setUpViews() {
        editNome = edit_nome
        textTBM = text_tbm

        textoSelecione = text_selecione
        botoes = botoes_radio_group
    }

    fun prosseguir(view: View){

        val nome = editNome.text.toString()
        if (nome.trim() == ""){
            Toast.makeText(this, "Nome Inválido!", Toast.LENGTH_SHORT).show()
        } else{

            val intent = Intent(this, UserInfoActivity::class.java)

            intent.putExtra(constants.NOME, nome)
            startActivityForResult(intent, constants.REQUEST_CODE)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == constants.REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK){
                val tbm = data!!.getDoubleExtra(UserInfoActivity.constants.TBM, 0.0)
                textTBM.text = "${decimalFormat.format(tbm)} kcal"

                textTBM.visibility = View.VISIBLE
                textoSelecione.visibility = View.VISIBLE
                botoes.visibility = View.VISIBLE

            }
        }
    }




}


