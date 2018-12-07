package com.example.artur.appnutrientes


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {

    object constants{
        const val NOME = "nome"
        const val TBM = "TBM"
        const val REQUEST_CODE = 1
    }
    private lateinit var editNome: EditText
    private lateinit var textTBM: TextView
    private lateinit var textAltura: TextView
    private lateinit var textPeso: TextView
    private lateinit var textNome: TextView
    private lateinit var textoSelecione: TextView
    private var tbmAtual: Double = 0.0
    private lateinit var nomeAtual: String
    private var result: Double = 0.0
    private lateinit var buttonDetalhes: Button

    private lateinit var botoes: RadioGroup
    var decimalFormat = DecimalFormat("#####.##")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViews()
    }

    private fun setUpViews() {
        editNome = edit_nome
        textTBM = text_tbm
        textAltura = text_altura
        textPeso = text_peso
        textNome = text_nome

        textoSelecione = text_selecione
        botoes = botoes_radio_group
        buttonDetalhes = button_detalhes
    }

    fun prosseguir(view: View){

        val nome = editNome.text.toString()
        if (nome.trim() == ""){
            Toast.makeText(this, "Nome Inválido!", Toast.LENGTH_SHORT).show()
        } else{
            nomeAtual = nome
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
                tbmAtual = tbm
                val altura  = data.getDoubleExtra(UserInfoActivity.constants.ALTURA, 0.0)
                val peso= data.getDoubleExtra(UserInfoActivity.constants.PESO, 0.0)


                textTBM.text = "${decimalFormat.format(tbm)} kcal"
                textTBM.visibility = View.VISIBLE

                textNome.text = "${editNome.text.toString()}, suas informações:"
                textNome.visibility = View.VISIBLE

                textAltura.text = "Altura: $altura m"
                textAltura.visibility = View.VISIBLE

                textPeso.text = "Peso: $peso kg"
                textPeso.visibility = View.VISIBLE

                textoSelecione.visibility = View.VISIBLE
                botoes.visibility = View.VISIBLE

                editNome.text.clear()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun btnSelecionado(view: View){
        val checked = (view as RadioButton).isChecked
        var estiloVida = 0.0

        when(view.id){

            R.id.sedentario ->{
                if (checked) estiloVida = 1.0
            }

            R.id.levemente_ativo ->{
                if (checked) estiloVida = 1.11
            }

            R.id.moderadamente_ativo -> {
                if (checked) estiloVida = 1.25
            }
            R.id.muito_ativo ->{
                if (checked) estiloVida = 1.48
            }
        }
        result = tbmAtual * estiloVida
        textTBM.text = "${decimalFormat.format(result)} kcal"
        buttonDetalhes.visibility = View.VISIBLE
    }

    fun detalhes(view: View){
        val intent = Intent(this, DetalhesActivity::class.java)
        intent.putExtra(constants.NOME, nomeAtual)
        intent.putExtra(constants.TBM, result)

        startActivity(intent)
    }

}