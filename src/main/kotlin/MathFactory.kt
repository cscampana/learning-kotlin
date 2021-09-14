interface IdProvider{
    fun getId() : String
}
class Entity private constructor(val id: String){

    // Companion Object, it is scope to instance of another class. It can also implement interfaces.
    companion object Factory : IdProvider{
        // Static object alike
        const val id = "id"

        override fun getId(): String {
            return "Maths"
        }
        fun create() =  Entity(getId())

    }
}

fun main(){
    val entity = Entity.Factory.create()
    Entity.id
}