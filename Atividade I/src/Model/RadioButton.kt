package Model

class RadioButton: Button(){
    var checked = false

    fun check(){
        this.checked = true
    }

    fun isChecked(): Boolean {
        return this.checked
    }
}