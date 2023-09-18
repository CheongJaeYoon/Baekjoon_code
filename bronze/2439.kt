import java.io.*
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main() = with(BufferedReader(File(path).bufferedReader())) {
fun main() = with (BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val answer = solution(n)
    println(answer)
}

fun solution(n: Int): String {
    return (1..n).fold(StringBuilder("")){sb, num -> sb.append(" ".repeat(n - num) + "*".repeat(num) + if(num != n) "\n" else "")}.toString()
}