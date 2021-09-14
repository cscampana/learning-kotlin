/**
 * To further simplify can be class Mathematician( val firstName: String, val lastName: String)
 * and that would be the entirety of this code.
 */
class Mathematician(_firstName: String, _lastName: String) {
    val firstName: String
    val lastName: String

    /**
     * Can also initialize firstName, lastName as firstName = _firstName
     */
    // Block of code that always run, can have multiples.
    init {
        firstName = _firstName
        lastName = _lastName
        println("Init 1")
    }
    // Secondary constructor, this() -> primary constructor.
    constructor(): this("Obscure", "Mathematician"){
        println("Secondary constructor")
    }

    init {
        println("Init 2")
    }

    var nickName: String? = null
            set(value){     // Custom getter
                // Underlining variable to work it.
                field = value
                println("The nickname is $nickName")
            }
            get(){ // custom getter. Like the toString.
                println("the getter has returned")
                return field
            }
    // Method declaration on a class.
    fun printInfo(){
        // Elvis operator, return left if it is not null, otherwise return right.
        val nickNameToPrint = nickName ?: "no nickname"
        println("$firstName ($nickNameToPrint) $lastName")
    }

}