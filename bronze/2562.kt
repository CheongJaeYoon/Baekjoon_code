import java.io.*

//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main() = with(BufferedReader(File(path).bufferedReader())) {
fun main() = with (BufferedReader(InputStreamReader(System.`in`))) {
    var arr = Array<Int>(9) { readLine().toInt() }
    var max = arr.sortedDescending()[0]
    for(i in arr.indices){
        if(arr[i] == max){
            println(arr[i])
            println(i+1)
            break
        }
    }
}