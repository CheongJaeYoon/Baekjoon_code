import java.io.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main() = with(BufferedReader(File(path).bufferedReader())) {
fun main() = with (BufferedReader(InputStreamReader(System.`in`))) {
    val answer = solution(readLine())
    println(answer)
}

fun solution(str: String): String {
    var map = mutableMapOf<Char, Int>()
    for(c in 'A'..'Z'){
        map[c] = 0
    }
    str.toUpperCase().forEach{ map[it] = map[it]!! + 1}
    var sortedmap = map.toList().sortedByDescending { it.second }
    return if(sortedmap[0].second == sortedmap[1].second) "?" else sortedmap[0].first.toString()
}
