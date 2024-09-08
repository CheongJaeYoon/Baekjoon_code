import java.io.*
import kotlin.math.*
import kotlin.math.log2


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main() = with(BufferedReader(File(path).bufferedReader())) {
fun main() = with (BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val arr = Array<Int>(n) { readLine().toInt() }
    print(solution(n, arr))
}

fun solution(n: Int, arr: Array<Int>): Int {
    val segTreeSize = (2.0).pow(ceil(log2(n.toDouble()))).toInt()*2
    val segmentTree = Array<Int>(segTreeSize){ 0 }
    init(0, arr.lastIndex, 1, segmentTree, arr)

    return searchMax(0, arr.lastIndex, arr, segmentTree)
}

fun searchMax(l: Int, r: Int, arr: Array<Int>, segmentTree: Array<Int>): Int {
    if(l > r) return 0
    val pivot = query(0, arr.lastIndex, 1, l, r, segmentTree, arr)
    var res = (r - l + 1) * arr[pivot]
    res = Math.max(res, searchMax(l, pivot-1, arr, segmentTree))
    res = Math.max(res, searchMax(pivot+1, r, arr, segmentTree))
    return res
}

fun init(s: Int, e: Int, idx: Int, segmentTree: Array<Int>, arr: Array<Int>): Int {
    if(s == e){
        segmentTree[idx] = s
        return s
    }
    val mid = (s + e) / 2
    val leftIdx = init(s, mid, idx*2, segmentTree, arr)
    val rightIdx = init(mid+1, e, idx*2+1, segmentTree, arr)
    segmentTree[idx] = if(arr[leftIdx] < arr[rightIdx]) leftIdx else rightIdx
    return segmentTree[idx]
}

fun query(s: Int, e: Int,idx: Int, l: Int, r: Int, segmentTree: Array<Int>, arr: Array<Int>): Int{
    if(r < s || e < l){
        return -1
    }
    else if(l <= s && e <= r){
        return segmentTree[idx]
    }
    val mid = (s + e) / 2
    val leftIdx = query(s, mid, idx*2, l, r, segmentTree, arr)
    val rightIdx = query(mid+1, e, idx*2+1, l, r, segmentTree, arr)
    if(leftIdx < 0) return rightIdx
    if(rightIdx < 0) return leftIdx
    return if(arr[leftIdx] < arr[rightIdx]) leftIdx else rightIdx
}