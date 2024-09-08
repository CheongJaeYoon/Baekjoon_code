import java.io.*
import java.lang.StringBuilder
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main(args: Array<String>) = with(BufferedReader(File(path).bufferedReader())) {
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    println(solution(readLine()))
}

fun solution(str: String): String {
    var arr = Array<Int>('z' - 'a' + 1){-1}
    for(idx in str.indices){
        if(arr[str[idx]-'a'] == -1){
            arr[str[idx]-'a'] = idx
        }
    }
    var sb = StringBuilder("")
    for(idx in arr.indices){
        if(idx != arr.lastIndex){
            sb.append("${arr[idx]} ")
        }
        else{
            sb.append("${arr[idx]}")
        }
    }
    return sb.toString()
}