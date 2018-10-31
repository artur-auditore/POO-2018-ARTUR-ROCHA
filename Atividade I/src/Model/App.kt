package Model

class App{

    var nome = ""
    var install = false
    var open = false
    val activities = arrayListOf<Activity>()

    fun addActivity(){
        val activity = Activity()
        activities.add(activity)
    }

    fun isAberto(): Boolean {
        return this.open
    }
}