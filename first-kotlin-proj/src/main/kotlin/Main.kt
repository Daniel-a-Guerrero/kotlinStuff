package org.example

fun main() {
    var x=5
    var y=3
    var z=x+y
    println("${x}+${y}=${z}")
    println("Hello World!")
    println("${x}!=${factorial(x)}")
    println("${y}!=${factorial(y)}")
    println("${z}!=${factorial(z)}")
}
fun factorial(a:Int): Int
{
    return if (a==0)
    {
        1
    }
    else{
        a*(factorial(a-1))
    }

}