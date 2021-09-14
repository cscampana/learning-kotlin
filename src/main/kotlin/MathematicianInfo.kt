interface MathematicianInfo {
    // Can have properties, but cannot initialize.
    val mathematicianInfo: String
    // Can implement methods
    fun printInfo(mathematician : Mathematician) {
        println("Math")
        mathematician.printInfo()
    }
}
interface MathSessionProvide {
    fun getMathNumber() : String
}
// How to implement the interface
class ImplementedMathematician : MathematicianInfo, MathSessionProvide{
    // You must override!
    override val mathematicianInfo: String
        get() = "Mathematician info"

    // You must use the keyword override.
    override fun printInfo(mathematician: Mathematician) {
        super.printInfo(mathematician)
        println("It works!")
    }

    override fun getMathNumber(): String {
        return "1234"
    }
}
// Type check using the keyword is
fun checkTypes(mathInfo : ImplementedMathematician){
    // Use !is to check not.
    if(mathInfo is MathSessionProvide ){
        println("true")
        (mathInfo as MathSessionProvide )
    } else {
        println("false")
    }
}

fun main(){
    val currentMathematician = ImplementedMathematician()
    currentMathematician.printInfo(Mathematician())
    currentMathematician.getMathNumber()
    checkTypes(currentMathematician)
}