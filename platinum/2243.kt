import java.io.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val st = StreamTokenizer(br)
    val readInt = {
        st.nextToken()
        st.nval.toInt()
    }

    val solution = Solution()

    val n = readInt()
    repeat(n){
        when(readInt()){
            1 -> {
                solution.get(readInt())
            }
            2 -> {
                solution.update(readInt(), readInt())
            }
        }
    }

    br.close()

    solution.print()
}

class Solution() {
    val TREESIZE = 2097152
    val segmentTree = Array<Int>( TREESIZE ) { 0 }
    val candy = Array<Int>( 1000001 ) { 0 }
    val sb = StringBuilder("")


    fun update(idx: Int, num: Int){
        candy[idx] += num
        fun recursive(searchIdx: Int, node: Int, nodeStart: Int, nodeEnd: Int, diff: Int){
            if(searchIdx < nodeStart || nodeEnd < searchIdx) return
            segmentTree[node] += diff
            if(nodeStart == nodeEnd) return

            if(nodeStart != nodeEnd){
                val nodeMid = (nodeStart + nodeEnd) / 2
                recursive(searchIdx, node*2, nodeStart, nodeMid, diff)
                recursive(searchIdx, node*2 + 1, nodeMid + 1, nodeEnd, diff)
            }
        }

        recursive(idx, 1, 0, 1000000, num)
    }

    fun get(rank: Int){
        fun recursive(node: Int, nodeStart: Int, nodeEnd: Int, sum: Int): Int{
            segmentTree[node]--
            if(nodeStart == nodeEnd) return nodeStart
            val left = segmentTree[node*2]
            val nodeMid = (nodeStart + nodeEnd) / 2
            if(left >= sum){
                return recursive(node*2, nodeStart, nodeMid, sum)
            }
            else{
                return recursive(node*2 + 1, nodeMid + 1, nodeEnd, sum - left)
            }
        }

        sb.append(recursive(1, 0, 1000000, rank))
        sb.append("\n");
    }

    fun print(){
        print(sb.toString())
    }
}
