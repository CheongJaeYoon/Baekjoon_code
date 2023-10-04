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
    val m = readInt()
    val arr = Array(n){ readInt() }

    val solution = Solution(arr)

    repeat(m){
        solution.query(readInt()-1, readInt()-1)
    }

    br.close()

    solution.print()
}

class Solution(val arr: Array<Int>) {
    val sb = StringBuilder("");
    val size = 1 shl (arr.size.toString(2).length)
    var maxSegmentTree: Array<Int>
    var minSegmentTree: Array<Int>

    init {
        maxSegmentTree = Array<Int>( size shl 1){ 0 }
        minSegmentTree = Array<Int>( size shl 1){ 0 }
        buildTree()
    }

    fun buildTree(){
        fun recursiveMax(node: Int, s: Int, e: Int): Int{
            if(s == e){
                maxSegmentTree[node] = arr[s]
                return arr[s]
            }
            val mid = (s + e) / 2
            maxSegmentTree[node] = Math.max(recursiveMax(node*2, s, mid), recursiveMax(node*2 + 1, mid+1, e))
            return maxSegmentTree[node]
        }
        fun recursiveMin(node: Int, s: Int, e: Int): Int{
            if(s == e){
                minSegmentTree[node] = arr[s]
                return arr[s]
            }
            val mid = (s + e) / 2
            minSegmentTree[node] = Math.min(recursiveMin(node*2, s, mid), recursiveMin(node*2 + 1, mid+1, e))
            return minSegmentTree[node]
        }
        recursiveMax(1, 0, arr.size-1)
        recursiveMin(1, 0, arr.size-1)
    }

    fun query(s: Int, e: Int){
        fun recursiveMax(node: Int, targetStart: Int, targetEnd: Int, start: Int, end: Int): Int{
            if(end < targetStart || start > targetEnd) return Int.MIN_VALUE

            if(targetStart <= start && end <= targetEnd) return maxSegmentTree[node]

            val mid = (start + end) / 2
            val left = recursiveMax(node*2, targetStart, targetEnd, start, mid)
            val right = recursiveMax(node*2 + 1, targetStart, targetEnd, mid + 1, end)
            return Math.max(left, right)
        }
        fun recursiveMin(node: Int, targetStart: Int, targetEnd: Int, start: Int, end: Int): Int{
            if(end < targetStart || start > targetEnd) return Int.MAX_VALUE

            if(targetStart <= start && end <= targetEnd) return minSegmentTree[node]

            val mid = (start + end) / 2
            val left = recursiveMin(node*2, targetStart, targetEnd, start, mid)
            val right = recursiveMin(node*2 + 1, targetStart, targetEnd, mid + 1, end)
            return Math.min(left, right)

        }
        sb.append(recursiveMin(1, s, e, 0, arr.size-1))
        sb.append(" ")
        sb.append(recursiveMax(1, s, e, 0, arr.size-1))
        sb.append("\n")
    }

    fun print(){
        print(sb.toString())
    }
}
