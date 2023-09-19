import java.io.*
import java.util.*


const val MOD = 1000003L
//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main() = with(BufferedReader(File(path).bufferedReader())) {
fun main() = with (BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val s = st.nextToken().toInt()
    val e = st.nextToken().toInt()
    val t = st.nextToken().toInt()
    val arr = Array<String>(n) { readLine() }
    val answer = solution(n, s, e, t, arr)
    print(answer)
}

fun solution(n: Int, s: Int, e: Int, t: Int, arr: Array<String>): Int {
    val a = Array<LongArray>(n*5) { LongArray(n*5){0} }
    for(node in 0 until n){
        for(i in 1..4){
            a[node*5+i][node*5+i-1] = 1
        }
    }
    for(to in 0 until n){
        for(from in 0 until n){
            if(arr[to][from] != '0'){
                a[to*5][from*5 + (arr[to][from] - '1')] = 1
            }
        }
    }
    val res = matrixPow(a, t, n*5)
    return res[(s-1)*5][(e-1)*5].toInt()
}

fun matrixPow(arr: Array<LongArray>, t: Int, l: Int): Array<LongArray>{
    if(t == 1) return arr
    var tmp = matrixPow(arr, t/2, l)
    tmp = matrixMul(tmp, tmp, l)
    if(t%2 == 1) tmp = matrixMul(tmp, arr, l)
    return tmp
}

fun matrixMul(arr1: Array<LongArray>, arr2: Array<LongArray>, l: Int): Array<LongArray> {
    val matrix = Array<LongArray>(l) { LongArray(l){0} }
    for(i in 0 until l){
        for(j in 0 until l){
            for(k in 0 until l){
                matrix[i][j] += arr1[i][k] * arr2[k][j]
                matrix[i][j] %= MOD
            }
        }
    }
    return matrix
}