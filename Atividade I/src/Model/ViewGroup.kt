package Model

open class ViewGroup: View(){

    val views = arrayListOf<View>()

    fun addView(altura: Int, largura: Int){
        val view = View()
        view.altura = altura
        view.largura = largura
        views.add(view)
    }
}