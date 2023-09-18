import java.io.*
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main(args: Array<String>) = with(BufferedReader(File(path).bufferedReader())) {
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val t = readLine().toInt()
    for(i in 0 until t){
        var st = StringTokenizer(readLine())
        val row = st.nextToken().toInt()
        val col = st.nextToken().toInt()
        val arr = Array<String> (row) {
            readLine()
        }
        println(solution(row, col, arr))
    }
}

fun solution(row:Int, col:Int, arr: Array<String>): Int {
    var result = 0;
    var dp = Array<IntArray>(row) { IntArray(1 shl col) { 0 } }
    var enableSitList = mutableListOf<IntArray>()
    for(sit in 0 until (1 shl col)){
        if(isAdjacent(sit, col)) enableSitList.add(intArrayOf(sit, sit.bitCount()))
    }
    for(r in 0 until row){
        for(curSit in enableSitList){
            if(isBlocked(curSit[0], arr[r])) continue
            for(prevSit in enableSitList){
                if(isEnable(prevSit[0], curSit[0], col)){
                    dp[r][curSit[0]] = Math.max(dp[r][curSit[0]], if(r == 0) curSit[1] else dp[r-1][prevSit[0]] + curSit[1])
                    result = Math.max(result, dp[r][curSit[0]])
                }
            }
        }
    }
    return result
}

fun isEnable(prevSit: Int, curSit: Int, col: Int): Boolean {
    for(i in 0 until col){
        if(curSit.andWithBit(i)){
            for(dc in intArrayOf(-1, 1)){
                val nc = i + dc
                if(nc < 0 || nc >= col) continue
                if(prevSit.andWithBit(nc)) return false
            }
        }
    }
    return true
}

fun isBlocked(curSit: Int, row: String): Boolean {
    for(i in row.indices){
        if(row[i] == 'x' && curSit.andWithBit(i)) return true
    }
    return false
}

fun isAdjacent(sit: Int, col: Int): Boolean {
    for(i in 0 until col-1){
        if(sit.andWithBit(i) && sit.andWithBit(i+1))
            return false
    }
    return true
}

infix fun Int.andWithBit(i:Int) = this and (1 shl i) > 0

fun Int.bitCount(): Int {
    var sit = this
    var sum = 0
    while(sit > 0){
        sum += sit % 2
        sit /= 2
    }
    return sum
}