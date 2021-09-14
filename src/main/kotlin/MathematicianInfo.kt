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
    fun getMathNumber() : Int
}
// How to implement the interface (use the open keyword to allow it to be extended)
open class ImplementedMathematician : MathematicianInfo, MathSessionProvide{
    // Need to add the open key to properties too.
    protected open val numericalMath = 12334
    // You must override!
    override val mathematicianInfo: String
        get() = "Mathematician info"

    // You must use the keyword override.
    override fun printInfo(mathematician: Mathematician) {
        super.printInfo(mathematician)
        println(mathematicianInfo)
    }

    override fun getMathNumber(): Int {
        return numericalMath
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
    val currentMathematician = FancyMath()
    currentMathematician.printInfo(Mathematician())
    currentMathematician.getMathNumber()
    checkTypes(currentMathematician)
}