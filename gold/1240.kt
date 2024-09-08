import java.io.*

//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val st = StreamTokenizer(br);
    val readInt = {
        st.nextToken()
        st.nval.toInt()
    }
    var n = readInt();
    var m = readInt();
    var graph = List<MutableList<Pair<Int, Int>>>(n+1){ mutableListOf() }
    while(n --> 1){
        var s = readInt();
        var e = readInt();
        var dist = readInt();
        graph[s].add(Pair(e, dist))
        graph[e].add(Pair(s, dist))
    }
    val tree = Tree(graph);
    while(m --> 0){
        print("${tree.getDistance(readInt(), readInt())}\n");
    }
    br.close()
}

class Tree(var graph: List<MutableList<Pair<Int, Int>>>) {
    fun getDistance(node1:Int, node2: Int):Int{
        var distance = 0;
        var visited = Array(graph.size){false}
        fun dfs(sNode: Int, eNode: Int, dist: Int){
            if(sNode == eNode) distance = dist;
            visited[sNode] = true;
            for(child in graph[sNode]){
                if(visited[child.first]) continue;
                dfs(child.first, eNode, dist + child.second);
            }
        }
        dfs(node1, node2, 0)
        return distance;
    }
}