class FancyMath : ImplementedMathematician() {
    override val numericalMath: Int
        get() = 4567

    override val mathematicianInfo: String
        get() = "Fancy Maths"

    override fun printInfo(mathematician: Mathematician) {
        super.printInfo(mathematician)
        println("Nice maths")
    }
}