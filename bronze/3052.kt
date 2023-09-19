import java.io.*
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main(args: Array<String>) = with(BufferedReader(File(path).bufferedReader())) {
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val set = mutableSetOf<Int>()
    for(i in 1..10){
        set.add(readLine().toInt()%42)
    }
    print(set.size)
}