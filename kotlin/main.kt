import java.io.*
import java.util.*
import kotlin.math.log2
import kotlin.math.pow


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val input1 = Array(n){ br.readLine().toLong() }
    val input2 = Array(m+k){
        st = StringTokenizer(br.readLine())
        longArrayOf(st.nextToken().toLong(), st.nextToken().toLong(), st.nextToken().toLong())}
    br.close()

    val solution = Solution(n, m, k, input1)
    solution.init()
    solution.solve(input2)

    solution.print()
}

class Solution(val n: Int, val m: Int, val k: Int, val arr: Array<Long>){
    lateinit var segmentTree: Array<Long>
    var result = StringBuilder("")

    fun solve(input: Array<LongArray>) {
        for(command in input){
            when(command[0]){
                1L -> {
                    update(command[1].toInt()-1, command[2])
                    arr[command[1].toInt()-1] = command[2]
                }
                else -> {
                    result.append(subSum(command[1].toInt()-1, command[2].toInt()-1))
                    result.append("\n")
                }
            }
        }
    }

    fun init() {
        var treeSize = (2.0).pow((log2(n.toDouble()).toInt() + 2).toDouble()).toInt()
        segmentTree = Array<Long>(treeSize){ 0L }

        fun recursive(startIdx: Int, endIdx: Int, idx: Int): Long{
            if(startIdx == endIdx){
                segmentTree[idx] = arr[startIdx]
            }
            else{
                val midIdx = (startIdx + endIdx)/2
                segmentTree[idx] = recursive(startIdx, midIdx, idx*2) + recursive(midIdx + 1, endIdx, idx*2 + 1)
            }
            return segmentTree[idx]
        }

        recursive(0, n-1, 1)
    }

    private fun update(idx: Int, num: Long){
        fun recursive(searchIdx: Int, node: Int, nodeStart: Int, nodeEnd: Int, diff: Long){
            if(searchIdx < nodeStart || nodeEnd < searchIdx) return
            segmentTree[node] += diff

            if(nodeStart != nodeEnd){
                val nodeMid = (nodeStart + nodeEnd) / 2
                recursive(searchIdx, node*2, nodeStart, nodeMid, diff)
                recursive(searchIdx, node*2 + 1, nodeMid + 1, nodeEnd, diff)
            }
        }
        recursive(idx, 1, 0, n-1, (num - arr[idx]))
    }

    private fun subSum(startIdx: Int, endIdx: Int): Long{
        fun recursive(startIdx: Int, endIdx: Int, node: Int, nodeStart: Int, nodeEnd: Int): Long{
            if(endIdx < nodeStart || nodeEnd < startIdx) return 0L
            if(startIdx <= nodeStart && nodeEnd <= endIdx) return segmentTree[node]

            val nodeMid = (nodeStart + nodeEnd) / 2
            return recursive(startIdx, endIdx, node*2, nodeStart, nodeMid) + recursive(startIdx, endIdx, node*2 + 1, nodeMid + 1, nodeEnd)
        }
        return recursive(startIdx, endIdx, 1, 0, n-1)
    }


    fun print(){
        print(result.toString())
    }
}
