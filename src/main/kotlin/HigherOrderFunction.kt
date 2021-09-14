// Higher order function, we have an input as String and return Boolean
fun printFilteredStrings(list: List<String>, predicate: (String) -> Boolean) {
    list.forEach {
        if (predicate(it)) { // can be called as a regular function
            println(it)
        }
    }
}

fun printFilteredStringNullable(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
        if (predicate?.invoke(it) == true) { // can be called as a regular function
            println(it)
        }
    }
}
// Variables as functions!
val predicate: (String) -> Boolean = {
    it.startsWith("J")
}
// Function that returns another function!
fun getPrintPredicate(): (String) -> Boolean{
    return {it.startsWith("J")}
}

fun main() {
    //We can remove the lambda outside since it is a function and last on the argument list
    val list = listOf("Kotlin", "Java", "C++", "JavaScript")

    //All the same
    printFilteredStrings(list) { it.startsWith("J") }
    printFilteredStrings(list,predicate)
    printFilteredStrings(list,getPrintPredicate())

    printFilteredStringNullable(list,null)

}