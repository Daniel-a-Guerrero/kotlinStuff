package main.kotlin
import java.util.Scanner
import java.util.Random
//import java.io.IO.*
fun main() {
    var X1:Int = 0; var X2:Int = 0;var Y1:Int = 0;var Y2:Int = 0
    //random "seed"
    val random=Random()
    val scanner = Scanner(System.`in`)
        println("Enter X axis of Matrix 1 and Y axis of Matrix 2:")
        X1 = scanner.nextInt()
        Y2 = X1
        println("Enter Y axis of Matrix 1:")
        Y1 = scanner.nextInt()
        println("Enter X axis of Matrix 2:")
        X2 = scanner.nextInt()

            //declare matrix arrays
            val m1=Array(Y1){Array<Int>(X1){0}}
            val m2=Array(Y2){Array<Int>(X2){0}}

            //print out initial matrices
            println("Matrix 1:")
            for(i in 0 until Y1)
            {
                for (j in 0 until X1)
                {
                    m1[i][j]=random.nextInt(21)-10
                }
            }
            printMatrix(m1)

            println("${getDeterminant(m1)}\n")

            println("\nMatrix 2:")
            for(i in 0..Y2-1)
            {
                for (j in 0..X2-1)
                {
                    m2[i][j]=random.nextInt(21)-10
                }
            }
            printMatrix(m2)
            println("${getDeterminant(m2)}\n")
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
fun multMatrix(m:Array<Array<Int>>,n:Array<Array<Int>>):Array<Array<Int>>?
{
    if(m.size==0)
        return null
    var reto=Array(m.size){Array<Int>(n[0].size){0}}
    val mark=m.size-1
    var s:Int=0
    for(i in 0..mark)
    {
        for(j in 0..n[0].size-1)
        {
            s= multStep(m[i], getColumn(n,j))
            reto[i][j]=s
        }
    }
    return reto
}

//reusable printer for matrices
fun printMatrix(m:Array<Array<Int>>?):Unit
{
    if(m==null)
        println(' ')
    else{
        for(i in 0 until m.size)
        {
            for(j in 0 until m[0].size)
            {
                print("${m[i][j].toString().padStart(4,' ')}\t")
            }
            print('\n')
        }
    }
}






//Determine if it is possible to get a determinant
fun deterDeter(m:Array<Array<Int>>): Boolean
{
    if(m.size==0) return false
    val i:Boolean = m.size==m[0].size
    /*when(i)
    {
        true -> println("This matrix has a determinant")
        false -> println("This matrix doesn't have a determinant")
    }*/
    return i
}

//Return smaller matrix for determinant calculation

fun getDeterminant(m:Array<Array<Int>>):Int {
    if(!deterDeter(m)){
        return 0
    }
    else if(m.size<=1){
        return m[0][0]
    }
    if(m.size==2){
        return(m[0][0]*m[1][1]-m[0][1]*m[1][0])
    }
    else{
        var allDets=0
        for(i in 0..m[0].size-1){
            var mark:Int=m[0][i]
            if(i%2==1) {
                mark *= -1
            }
            var mm = micro(m,i)
            when(mm)
            {
                null->mark=0
                else->mark*=getDeterminant(mm)
            }
            allDets+=mark
        }
        return allDets
    }
}

//get smaller matrix
fun micro(m:Array<Array<Int>>,tic:Int):Array<Array<Int>>?{
    var m0 = Array(m.size-1){Array<Int>(m[0].size-1){0}}
    for(i in 1..m.size-1) {
        for(j in 0..m[0].size-1) {
            var rJ=j
            if(j==tic){
                continue
            }
            else {
                if(j>tic)
                    rJ--
                m0[i - 1][rJ] = m[i][j]
            }
        }
    }
    return m0
}