import java.io.*
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main(args: Array<String>) = with(BufferedReader(File(path).bufferedReader())) {
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    for(i in 0 until t){
        var st = StringTokenizer(readLine())
        val r = st.nextToken().toInt()
        val s = st.nextToken()
        println(solution(r, s))
    }
}

fun solution(r:Int, s: String): String {
    return s.fold(StringBuilder("")){sb, c -> sb.append(c.toString().repeat(r))}.toString()
}