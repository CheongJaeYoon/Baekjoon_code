import java.io.*
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main(args: Array<String>) = with(BufferedReader(File(path).bufferedReader())) {
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    for(i in 1..t){
        println(solution(readLine()))
    }
}

fun solution(str: String): String {
    var prev = str[0]
    var score = if(prev == 'O') 1 else 0
    var total = score
    for(idx in 1 until str.length){
        if(str[idx] == 'O'){
            if(str[idx] == prev){
                score++
            }
            else{
                score = 1
            }
            total += score
        }
        prev = str[idx]
    }
    return total.toString()
}