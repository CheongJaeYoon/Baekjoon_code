import java.io.*
import java.util.*
import kotlin.math.ceil
import kotlin.math.log2

var k = 0
lateinit var parent: Array<IntArray>
lateinit var level: Array<Int>
lateinit var dist: Array<Long>
lateinit var graph: Array<MutableList<IntArray>>

//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()
fun main(){
    val n = br.readLine().toInt()
    k = ceil(log2(n.toDouble())).toInt()
    var st: StringTokenizer
    parent = Array<IntArray>(n+1){ IntArray(k){ 0 } }
    level = Array<Int>(n+1){ 0 }
    dist = Array<Long>(n+1){ 0 }
    graph = Array<MutableList<IntArray>>(n+1) { mutableListOf<IntArray>() }
    for(i in 0 until n-1){
        st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val dist = st.nextToken().toInt()
        graph[from].add(intArrayOf(to, dist))
        graph[to].add(intArrayOf(from, dist))
    }
    dist[0] = 0
    init(0, 1, 1)

    val m = br.readLine().toInt()
    for(i in 1..m){
        st = StringTokenizer(br.readLine())
        println(solution(st.nextToken().toInt(), st.nextToken().toInt()))
    }
}

fun init(p_node: Int, c_node: Int, c_level: Int) {
    level[c_node] = c_level
    parent[c_node][0] = p_node
    for(level in 1 until k){
        if(parent[parent[c_node][level-1]][level-1] == 0) break
        parent[c_node][level] = parent[parent[c_node][level-1]][level-1]
    }
    for(child in graph[c_node]){
        if(child[0] == p_node) continue
        dist[child[0]] = child[1] + dist[c_node]
        init(c_node, child[0], c_level+1)
    }
}

fun solution(n1: Int, n2: Int): Long {
    var node1 = n1
    var node2 = n2
    if(level[n1] < level[n2]){
        node1 = n2
        node2 = n1
    }

    var lca = 1
    if(n1 == 1 || n2 == 1){
        lca = 1
    }
    else{
        if(level[node2] != level[node1]){
            for(i in k-1 downTo 0){
                if(level[parent[node1][i]] >= level[node2]){
                    node1 = parent[node1][i]
                }
            }
        }
        lca = node1
        if(node1 != node2){
            for(i in k-1 downTo 0){
                if(parent[node1][i] != parent[node2][i]){
                    node1 = parent[node1][i]
                    node2 = parent[node2][i]
                }
            }
            lca = parent[node1][0]
        }
    }
    node1 = n1
    node2 = n2

    return (dist[node1] - dist[lca]) + (dist[node2] - dist[lca])
}