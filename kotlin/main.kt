import java.io.*
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main(args: Array<String>) = with(BufferedReader(File(path).bufferedReader())) {
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    print(solution(n))
}

fun solution(n:Int): String {
    return (1..9).fold(StringBuilder("")){sb, num -> sb.append("$n * $num = ${num*n}\n")}.toString()
}