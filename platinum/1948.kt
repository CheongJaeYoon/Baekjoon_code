import java.io.*
import java.util.*
import kotlin.collections.ArrayList


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()
fun main(){
    val st = StreamTokenizer(br)
    val readInt = {
        st.nextToken()
        st.nval.toInt()
    }
    val n = readInt()
    val m = readInt()
    val input = Array(m){ intArrayOf() }
    for(i in 0 until m){
        input[i] = intArrayOf(readInt(), readInt(), readInt())
    }
    val s = readInt()
    val e = readInt()
    br.close()

    val solution = Solution(n, m, s, e)
    solution.init(input)
    solution.solve()

    bw.append(solution.print())
    bw.flush()
    bw.close()
}

class Solution(val n: Int, val m: Int, val s: Int, val e: Int){
    private val time = Array(n+1){0L}
    private val indegree = Array(n+1){0}
    private val edges = Array(n+1){ ArrayList<Edge>() }
    private val reverseEdges = Array(n+1){ ArrayList<Edge>() }
    private var cnt = 0

    fun solve(){
        val queue = LinkedList<Int>()
        queue.add(s)
        while(!queue.isEmpty()){
            val cur = queue.poll()
            for(next in edges[cur]){
                if(time[next.e] < time[cur] + next.w){
                    time[next.e] = time[cur] + next.w
                }
                if(--indegree[next.e] == 0){
                    queue.add(next.e)
                }
            }
        }

        val visited = Array<Boolean>(n+1) { false }
        queue.add(e)
        visited[e] = true
        while(!queue.isEmpty()){
            val cur = queue.poll()
            for(next in reverseEdges[cur]){
                if(time[next.e] == time[cur] - next.w){
                    cnt++
                    if(!visited[next.e]){
                        visited[next.e] = true
                        queue.add(next.e)
                    }
                }
            }
        }
    }

    fun init(input: Array<IntArray>){
        for(i in 0 until m){
            val s = input[i][0]
            val e = input[i][1]
            val w = input[i][2]
            edges[s].add(Edge(e, w))
            reverseEdges[e].add(Edge(s, w))
            indegree[e]++;
        }
    }


    fun print(): String {
        return "${time[e]}\n$cnt"
    }
}

data class Edge(val e: Int, val w: Int)
