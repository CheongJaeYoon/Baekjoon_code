import java.io.*
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val st = StreamTokenizer(br)
    val readInt = {
        st.nextToken()
        st.nval.toInt()
    }
    val v = readInt()
    val e = readInt()
    val graph = Array(e){ ArrayList<Int>() }
    repeat(e){
        graph[readInt()].add(readInt())
    }
    br.close()

    val solution = Solution(v, e, graph)
    solution.solve()
    solution.print()
}

class Solution(val v: Int, val e: Int, val graph: Array<ArrayList<Int>>) {
    var result = StringBuilder("")
    val discovery = Array(v+1){0}
    val finished = Array(v+1){false}
    val sccList = ArrayList<TreeSet<Int>>()
    var id = 1
    val stack = ArrayDeque<Int>()

    fun solve() {
        fun dfs(node: Int): Int {
            discovery[node] = id++
            var parent = discovery[node]
            stack.addLast(node)

            for(next in graph[node]){
                if(discovery[next] == 0){
                    parent = Math.min(parent, dfs(next))
                }
                else if(!finished[next]){
                    parent = Math.min(parent, discovery[next])
                }
            }
            if(parent == discovery[node]){
                val scc = TreeSet<Int>()

                while(true){
                    val now = stack.removeLast()
                    scc.add(now)
                    finished[now] = true
                    if(now == node) break
                }
                sccList.add(scc)
            }
            return parent
        }
        for(node in 1..v){
            if(discovery[node] == 0) dfs(node)
        }
    }

    fun print(){
        var sb = StringBuilder("")
        sccList.sortWith(Comparator{o1, o2 -> o1.first() - o2.first()})
        sb.append(sccList.size)
        sb.append("\n")
        sccList.forEach {scc ->
            scc.forEach { sb.append("$it ")}
            sb.append("-1\n")
        }
        print(sb.toString())
    }
}