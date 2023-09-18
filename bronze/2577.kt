import java.io.*
fun main() = with (BufferedReader(InputStreamReader(System.`in`))) {
    var map = mutableMapOf<Int, Int>()
    (0..9).forEach{ map[it] = 0 }
    (0..2).fold(1L){mul, _ -> mul*readLine().toLong()}.toString().map{it - '0'}.forEach{ it -> map[it] = map[it]!! + 1 }
    (0..9).forEach{ println(map[it]) }
}