import java.io.*
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main(args: Array<String>) = with(BufferedReader(File(path).bufferedReader())) {
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val h = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    print(solution(h, m))
}

fun solution(h:Int, m:Int): String {
    var min = (h*60 + m) -45
    if(min < 0) min += 24*60
    return "${min/60} ${min%60}"
}