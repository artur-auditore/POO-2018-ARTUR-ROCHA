fun main(args: Array<String>) {
    var x = 13

    while (x > 1) {
        if (x % 2 == 0) {
            x /= 2
            println(x)
        } else {
            x = 3 * x + 1
            println(x)
        }
    }
}