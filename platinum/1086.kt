import java.io.*
import java.math.BigDecimal


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main() = with(BufferedReader(File(path).bufferedReader())) {
fun main() = with (BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val set = Array<String>(n) {readLine() }
    val k = readLine().toInt()
    val answer = solution(n, set, k)
    println(answer)
}

fun solution(n: Int, set: Array<String>, k: Int): String {
    val cache = mutableMapOf<Int, Int>()
    val arr = Array<IntArray>(n) { intArrayOf(BigDecimal(set[it]).remainder(BigDecimal(k)).toInt(), cache.getOrPut(set[it].length){BigDecimal("1" + "0".repeat(set[it].length)).remainder(BigDecimal(k)).toInt()})}
    val dp = Array<LongArray>(1 shl n){ LongArray(k){0} }
    dp[0][0] = 1
    for(curBit in 0 until (1 shl n)){
        for(i in 0 until n){
            if(!curBit.andWithBit(i)){
                val nextBit = curBit.orWithBit(i)
                for(curK in 0 until k){
                    val nextK = ((curK * arr[i][1])%k + arr[i][0])%k
                    dp[nextBit][nextK] += dp[curBit][curK]
                }
            }
        }
    }
    val p = dp[(1 shl n) - 1][0]
    val q = (1..n).fold(1L) { fac, num -> fac*num}
    val gcd = gcd(p, q)


    return "${p/gcd}/${q/gcd}"
}

fun gcd(a: Long, b: Long): Long{
    if(b == 0L) return a
    return gcd(b, a%b)
}

fun Int.andWithBit(bit : Int) = this and (1 shl bit) > 0
fun Int.orWithBit(bit : Int) = this or (1 shl bit)
