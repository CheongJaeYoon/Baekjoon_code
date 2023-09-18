import java.io.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main() = with(BufferedReader(File(path).bufferedReader())) {
fun main() = with (BufferedReader(InputStreamReader(System.`in`))) {
    val answer = solution(readLine())
    println(answer)
}

fun solution(str: String): String {
    return str.trim().split(" ").let{ it -> if(it.size == 1 && it[0]=="") 0 else it.count()}.toString()
}
