import java.io.*
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main(args: Array<String>) = with(BufferedReader(File(path).bufferedReader())) {
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val arr = Array<Int>(8) { st.nextToken().toInt() }
    print(solution(arr))
}

fun solution(arr: Array<Int>): String {
    var d = arr[1] - arr[0]
    var prev = arr[1]
    for(i in 2 until 8){
        if(d != arr[i]-prev){
            d = 0
            break
        }
        else{
            d = arr[i]-prev
        }
        prev = arr[i]
    }
    return when(d){
        -1 -> "descending"
        1 -> "ascending"
        else -> "mixed"
    }

}