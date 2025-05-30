package org.example

fun main() {
    var name:String?=null
    var w0:Int=4;var w1:Int=11
    val x0:Float=5f;val x1:Float=2.2f
    val y0:Boolean=true
    println(w1%w0)
    println(y0)
    w0=rect(w0,w1)
    when(w0%3)
    {
        0->println("divisible by 3")
        1->println("1 off from 3 multiple")
        2->println("2 off from 3 multiple")
    }
    /*var x=5
    var y=3
    var z=x+y
    println("${x}+${y}=${z}")
    println("Hello World!")
    println("${x}!=${factorial(x)}")
    println("${y}!=${factorial(y)}")
    println("${z}!=${factorial(z)}")*/
}
fun rect(a:Int, b:Int):Int
{
    if(a<0||b<0)
    {
        return 0;
    }
    for(i in 1..a)
    {
        print('\n')
        for(j in 1..b)
        {
            print('*')
        }
    }
    println('\n')
    return a*b
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