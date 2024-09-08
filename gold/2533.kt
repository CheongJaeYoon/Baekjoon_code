import java.io.*
import java.lang.StringBuilder


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val st = StreamTokenizer(br)
    val readInt = {
        st.nextToken()
        st.nval.toInt()
    }
    val n = readInt()
    val graph = Array(n + 1){ mutableListOf<Int>()}
    repeat(n-1){
        val s = readInt()
        val e = readInt()
        graph[s].add(e)
        graph[e].add(s)
    }
    br.close()

    val solution = Solution(graph, n)
    solution.solve()
    solution.print()

}

class Solution(val graph: Array<MutableList<Int>>, val n: Int) {
    val dp = Array(n + 1){ intArrayOf(0, 0)}
    val visited = Array(n+1){ false }

    fun solve(){
        fun dfs(node: Int){
            visited[node] = true
            dp[node][0] = 0
            dp[node][1] = 1
            for(child in graph[node]){
                if(visited[child]) continue
                dfs(child)
                dp[node][0] += dp[child][1]
                dp[node][1] += Math.min(dp[child][0], dp[child][1])
            }
        }
        dfs(1)
    }


    fun print(){
        print(Math.min(dp[1][0], dp[1][1]))
    }
}
