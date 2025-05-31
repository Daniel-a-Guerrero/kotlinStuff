package org.example
import java.util.Scanner
import java.util.Random
fun main() {
    var X1:Int = 0; var X2:Int = 0;var Y1:Int = 0;var Y2:Int = 0
    //random "seed"
    val random=Random()
    try {
        println("Enter X axis of Matrix 1:")
        X1 = Scanner(System.`in`).nextInt()
        println("Enter Y axis of Matrix 1:")
        Y1 = Scanner(System.`in`).nextInt()
        println("Enter X axis of Matrix 2:")
        X2 = Scanner(System.`in`).nextInt()
        println("Enter Y axis of Matrix 2:")
        Y2 = Scanner(System.`in`).nextInt()
        if(X1!=Y2)
        {
            throw IllegalArgumentException("Can only multiply Matrices with same x axis and y axis of matrices 1 and 2 respectively")
        }
    }
    catch (e:IllegalArgumentException){
        println("Invalid axes: ${e.message}")
    }

    //declare matrix arrays
    val m1=Array(Y1){Array<Int>(X1){0}}
    val m2=Array(Y2){Array<Int>(X2){0}}

    //print out initial matrices
    println("Matrix 1:")
    for(i in 0..Y1-1)
    {
        for (j in 0..X1-1)
        {
            m1[i][j]=random.nextInt(21)-10
        }
    }
    printMatrix(m1)

    println("\nMatrix 2:")
    for(i in 0..Y2-1)
    {
        for (j in 0..X2-1)
        {
            m2[i][j]=random.nextInt(21)-10
        }
    }
    printMatrix(m2)
println("")




    val productMatrix= multMatrix(m1,m2)
    printMatrix(productMatrix)
}

//make an array based on the column
fun getColumn(m:Array<Array<Int>>,index:Int=0):Array<Int>
{
    var retu=Array(m.size){0}
    for(i in 0..m.size-1)
    {
        retu[i]=m[i][index]
    }
    return retu
}

//multiplication of row/column step
fun multStep(m:Array<Int>,n:Array<Int>):Int
{
    var prod=0
    for(i in 0..m.size-1) {
        prod += m[i] * n[i]
    }
    return prod
}

//multiply matrix algorithm
fun multMatrix(m:Array<Array<Int>>,n:Array<Array<Int>>):Array<Array<Int>>
{
    var reto=Array(m.size){Array<Int>(n[0].size){0}}
    val mark=m.size-1
    var s:Int=0
    for(i in 0..mark)
    {
        for(j in 0..n[0].size-1)
        {
            s=multStep(m[i], getColumn(n,j))
            reto[i][j]=s
        }
    }
    return reto
}

//reusable printer for matrices
fun printMatrix(m:Array<Array<Int>>):Unit
{
    for(i in 0..m.size-1)
    {
        for(j in 0..m[0].size-1)
        {
            print("${m[i][j].toString().padStart(4,' ')}\t")
        }
        print('\n')
    }
}