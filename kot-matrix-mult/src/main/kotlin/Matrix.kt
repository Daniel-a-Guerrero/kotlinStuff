package main.kotlin
import java.util.Scanner
import java.util.Random
import kotlin.math.*

class Matrix(val _x:Int = 1, val _y:Int = 1, val _min:Int = 0, val _max:Int = 1, val _template:Array<Array<Int>>? = null) {
     val y = abs(_y); val min = _min ;    val max = _max;

    //assign new value
    val x = abs(_x);
    init{
        println("New matrix:\nSize: $x x $y\nValue range: $min - $max")
        val m=genNew()
        printMatrix(m)
    }

    //generate new matrix
    fun genNew(): Array<Array<Int>>{
        val random=Random()
        val m = Array(x){Array(y){0}}
        for(i in 0 until y)
        {
            for (j in 0 until x){
                m[i][j]=random.nextInt(max-min+1)+min
            }
        }
        return m
    }

    //print matrices
    //reusable printer for matrices
    fun printMatrix(m:Array<Array<Int>>?){
        if(m==null)
            println(' ')
        else{
            for(i in 0 until m.size){
                for(j in 0 until m[0].size){
                    print("${m[i][j].toString().padStart(4,' ')}\t")
                }
                print('\n')
            }
        }
    }


}