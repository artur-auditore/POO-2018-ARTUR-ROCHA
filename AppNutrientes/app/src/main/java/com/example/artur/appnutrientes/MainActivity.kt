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
import kotlinx.android.synthetic.main.activity_user_info.*


class MainActivity : AppCompatActivity() {

    object constants{
        const val NOME = "nome"
        const val REQUEST_CODE = 1
        const val SEDENTARIO = 1.0
        const val LV_ATIVO = 1.15
        const val MD_ATIVO = 1.25
        const val MUITO_ATIVO = 1.48
    }
    private lateinit var editNome: EditText
    private lateinit var textTBM: TextView
    private lateinit var textoSelecione: TextView
    private var tbmAtual: Double = 0.0
    private lateinit var buttonDetalhes: Button

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
        buttonDetalhes = button_detalhes
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
                tbmAtual = tbm
                textTBM.text = "${decimalFormat.format(tbm)} kcal"

                textTBM.visibility = View.VISIBLE
                textoSelecione.visibility = View.VISIBLE
                botoes.visibility = View.VISIBLE

            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun btnSelecionado(view: View){
        val checked = (view as RadioButton).isChecked
        val result: Double

        when(view.id){

            R.id.sedentario ->{
                if (checked) {
                    result = tbmAtual * constants.SEDENTARIO
                    textTBM.text = "${decimalFormat.format(result)} kcal"
                }
            }

            R.id.levemente_ativo ->{
                if (checked) {
                    result = tbmAtual * constants.LV_ATIVO
                    textTBM.text = "${decimalFormat.format(result)} kcal"
                }
            }

            R.id.moderadamente_ativo ->{
                if (checked) {
                    result = tbmAtual * constants.MD_ATIVO
                    textTBM.text = "${decimalFormat.format(result)} kcal"
                }
            }

            R.id.muito_ativo ->{
                if (checked) {
                    result = tbmAtual * constants.MUITO_ATIVO
                    textTBM.text = "${decimalFormat.format(result)} kcal"
                }
            }
        }
        buttonDetalhes.visibility = View.VISIBLE
    }

    fun detalhes(view: View){
        //TODO por enquanto
        startActivity(Intent(this, DetalhesActivity::class.java))
    }

}


