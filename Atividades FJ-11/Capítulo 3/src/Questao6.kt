fun main(args: Array<String>) {
    var x = 0
    var y = 1

    var i = 0
    while (x < 100) {

        println(x)
        y += x
        x = y - x
        i++

    }
}