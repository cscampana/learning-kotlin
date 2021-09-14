import java.util.*

interface IdProvider{
    fun getId() : String
}
object EntityFactory {
    fun create() = EntityNotSealed("id", "name")
}
enum class EntityType {
    EASY, MEDIUM, HARD;

    fun getFormattedName() = name.lowercase(Locale.getDefault())
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

enum class EntityTypeWithHelp {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.lowercase(Locale.getDefault())
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it
            .toString() } as String
}
object EntityFactory2{
    fun create(type: EntityType) : EntityNotSealed {
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityType.EASY -> type.name // Use the name of the enum to encapsulate more
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> type.name
        }
        return EntityNotSealed(id, name)
    }

}

object EntityFactory3{
    fun create(type: EntityTypeWithHelp) : Entity {
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityTypeWithHelp.EASY -> type.getFormattedName() // Use the name of the enum to encapsulate more
            EntityTypeWithHelp.MEDIUM -> type.getFormattedName()
            EntityTypeWithHelp.HARD -> type.name
            EntityTypeWithHelp.HELP -> Entity.Help
        }
        return when(type) {
            EntityTypeWithHelp.EASY -> Entity.Easy(id, name as String)
            EntityTypeWithHelp.MEDIUM -> Entity.Medium(id, name as String)
            EntityTypeWithHelp.HARD -> Entity.Hard(id, name as String, 2f)
            EntityTypeWithHelp.HELP -> Entity.Help
        }
    }

}
// Sealed classes and interfaces represent restricted class hierarchies that provide more control over inheritance.
sealed class Entity(){
    object Help : Entity() {
        val name = "help"
    }
    // Concise and immutable data types. Generate equals, hashcode, toString automatically
    data class Easy(val id: String, val name: String) : Entity()
    data class Medium(val id: String, val name: String) : Entity()
    data class Hard(val id: String, val name: String, val multiplier: Float) : Entity()
}

class EntityNotSealed  constructor(val id: String, val name: String){

    // Companion Object, it is scope to instance of another class. It can also implement interfaces.
    companion object Factory : IdProvider{
        // Static object alike
        const val id = "id"

        override fun getId(): String {
            return "Maths"
        }
        fun create() =  EntityNotSealed(getId(), "name")

    }
    // toString override!
    override fun toString(): String {
        return "id:$id, name:$name"
    }
}
// Class/property extension outside of its body.
fun Entity.Medium.printInfo(){
    println("Medium class $id")
}
// Extending fields
val Entity.Medium.info: String
    get() = "Some Info"

fun main(){
    val entity = EntityNotSealed.Factory.create()
    EntityNotSealed.id

    //Object declaration
    val entityObject = EntityFactory.create()
    println(entityObject)

    //Enum class
    val entityEasy = EntityFactory2.create(EntityType.EASY)
    val entityMedium = EntityFactory2.create(EntityType.MEDIUM)
    val entityHard = EntityFactory2.create(EntityType.HARD)
    println(entityEasy)
    println(entityMedium)
    println(entityHard)

    // Sealed Class advantage
    val entitySealedEasy: Entity = EntityFactory3.create(EntityTypeWithHelp.HELP)
    val msg = when(entitySealedEasy){
        Entity.Help -> "Help Class"
        is Entity.Easy -> "Easy"
        is Entity.Hard -> "Medium"
        is Entity.Medium -> "Hard"
    }

    println(msg)

    //Data Class in-depth
    val entity1 = EntityFactory3.create(EntityTypeWithHelp.EASY)
    val entity2 = EntityFactory3.create(EntityTypeWithHelp.EASY)
    if(entity1 == entity2){ // They will not be equal since we have different Ids
        println("equal")
    } else{
        println("not equal")
    }

    val entity3 = Entity.Easy("1","a")
    val entity4 = Entity.Easy("1","a")
    if(entity3 == entity4){ // They will  be equal since we have same Ids
        println("equal")
    } else{
        println("not equal")
    }

    val entity5 = entity4.copy() // you can copy data classes directly
    val entity6 = entity4.copy("4","b") // you can even change the values.

    // === is a referential equality

    //Class extension and property extension
    Entity.Medium("id", "name").printInfo()
    println(Entity.Medium("id", "name").info)

}