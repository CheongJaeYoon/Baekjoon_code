import java.io.*
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main(args: Array<String>) = with(BufferedReader(File(path).bufferedReader())) {
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    for(i in 0 until t){
        var st = StringTokenizer(readLine())
        val row = st.nextToken().toInt()
        val col = st.nextToken().toInt()
        val arr = Array<String> (row) {
            readLine()
        }
        println(solution(row, col, arr))
    }
}

fun solution(row:Int, col:Int, arr: Array<String>): Int {
    val dr = arrayOf(-1, 0, 1, -1, 0, 1)
    val dc = arrayOf(-1, -1, -1, 1, 1, 1)
    var graph = Array<MutableList<Int>>(row*col) { mutableListOf<Int>() }
    var matching = IntArray(row*col) { -1 }
    var totalNodeCnt = 0
    for(r in 0 until row){
        for(c in 0 until col){
            if(arr[r][c] == '.'){
                totalNodeCnt++
                if(c%2 == 1) continue
                for(i in 0..5){
                    val nr = r + dr[i]
                    val nc = c + dc[i]
                    if(nr < 0 || nr >= row || nc < 0 || nc >= col) continue
                    if(arr[nr][nc] == '.') graph[r*col + c].add(nr*col + nc)
                }
            }
        }
    }
    var matchingCnt = 0
    var visited= mutableSetOf<Int>()
    for(c in 0 until col) {
        if(c%2 == 1) continue
        for(r in 0 until row){
            visited.clear()
            if(biMatching(r*col + c, visited, matching, graph)) matchingCnt++
        }
    }
    return totalNodeCnt - matchingCnt
}
//Bipartite Matching 이분탐색
fun biMatching(node: Int, visited: MutableSet<Int>, matching: IntArray, graph: Array<MutableList<Int>>):Boolean{
    visited.add(node)
    for(even in graph[node]){
        if(matching[even] == -1 || (!visited.contains(matching[even]) && biMatching(matching[even], visited, matching, graph))){
            matching[even] = node
            matching[node] = even
            return true
        }
    }
    return false
}