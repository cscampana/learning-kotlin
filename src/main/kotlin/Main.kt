/**
 * Learning Kotlin - Code examples of basic functionalities
 */
fun main() {
    println("Hello World")
    /**
     * Variables
     */
    variables()

    /**
     *  Control Flows
     */
    controlFlows()

    /**
     * Basic Functions
     */
    println(getGreeting())
    printNum()
    println(printNumReduced())
    printNumbers(numberToPrint = 5) // or printNumbers(5)
    stringTemplate("Caike")
    templateSingleExpression("Caike", "Campana")

    /**
     * Collections and Iterations
     */

    // Array
    val niceNumbers = arrayOf(2, 3, 4, 5, 6, 7, 8, 9, 10)

    println(niceNumbers.size)
    println(niceNumbers[0])
    println(niceNumbers.get(0))

    for (number in niceNumbers) {
        println(number)
    }

    // For each structure, "it" is the default name;
    niceNumbers.forEach {
        println(it)
    }

    //For each using lambda
    niceNumbers.forEach { numbers ->
        println(numbers)
    }

    // For each with indexes
    niceNumbers.forEachIndexed { index, numbers ->
        println("$numbers is at index $index")
    }

    // Lists
    val coolNumbers = listOf(1, 3, 5, 7, 9)
    println(coolNumbers.get(0))
    println(coolNumbers[0])

    coolNumbers.forEach { number -> println(number) }

    // Map                     key to value
    val mathematicians = mapOf(1 to "Euler", 2 to "Tao", 3 to "Newton", 4 to "Ramanujan")

    mathematicians.forEach { (key, value) -> println("The key is $key and the value is $value.") }

    // Mutable collections
    val coolNumbersMutable = mutableListOf(1, 3, 5, 7, 9)
    val mathematiciansMutable =
        mutableMapOf(1 to "Euler", 2 to "Tao", 3 to "Newton", 4 to "Ramanujan")

    coolNumbersMutable.add(5)
    mathematiciansMutable.put(key = 5, value = "Euclid")

    // Function with a list in the parameters
    collectionFunction("Hi", listOf("Euler", "Tao", "Newton", "Ramanujan"))

    /**
     * Classes
     */

    val mathematician = Mathematician("Leonhard", "Euler")
    // Access the property, no need for getters or setter.
    mathematician.firstName
    mathematician.nickName = "Best"
    mathematician.nickName = "Genius"
    println(mathematician.nickName)
    // Secondary constructor
    val unknownMath = Mathematician()

}

fun variables() {
    // keyword name: type = value
    // Mutable variables
    val mutable: String = "Can change"

    //Immutable
    var immutable: String = "Not changing"

    // Nullable types, you need to add ? after the type. The default is non-null type.
    var nullVariable: String? = "Can be null"
    nullVariable = null

    // Kotlin can detect type, but it is inferred to be non-null by default.
    var typeInferred = 30

}

// Declaring a top level variable
var globalVariable: String = "Global scope"

fun controlFlows() {
    var greeting: String? = "Hello World"

    // Regular if/else statement
    if (greeting != null) {
        println(greeting)
    } else {
        println("Hi")
    }


    var numberToBeCheck: Int? = 30
    // Just like a switch statement
    when (numberToBeCheck) {
        // Cases
        3 -> println(3)
        null -> println("Null")

        // Default case
        else -> println("Error")
    }

    // if-else to set variable value
    val validNumber = if (numberToBeCheck != null) numberToBeCheck else "Else"

    // when to set variable value
    val validNumber2 = when (numberToBeCheck) {
        null -> "Null"
        else -> numberToBeCheck
    }
}

// fun name(parameters): return type {...}
fun getGreeting(): String {
    return "Hello Kotlin"
}

// Unit is a placeholder unit, means DONE!
fun printNum(): Unit {
    println(42)
}

// Single expression function; you can omit the return type, it will be inferred.
fun printNumReduced() = 23

// parameters: name : return type
fun printNumbers(numberToPrint: Int) {
    println(numberToPrint)
}

// String Template, use $nameOfTheVariable to map it to a string.
fun stringTemplate(word: String) {
    val msg = "Hello $word"
    println(msg)
}

// String Template with a single expression function and multiple parameters
fun templateSingleExpression(firstName: String, lastName: String) = println(
    "Hi$lastName, your " +
            "first name $firstName is awesome"
)

// Using collections as parameters
fun collectionFunction(greeting: String, people: List<String>) {
    people.forEach { person -> println("$greeting, $person") }
}

// Vararg arguments - variable number of arguments
fun mathematiciansVariable(greeting: String, vararg mathematicians: String){
    mathematicians.forEach { mathematician -> println("$greeting, $mathematician") }
}