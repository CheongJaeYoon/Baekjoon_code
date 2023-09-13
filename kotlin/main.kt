import java.io.*
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main(args: Array<String>) = with(BufferedReader(File(path).bufferedReader())) {
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val arr = Array<String>(r) { "" }
    val dp = Array(r) { Array(c) { Array(2) { 0 } } }
    val dr = intArrayOf(-1, -1)
    val dc = intArrayOf(-1, 1)
    for (row in 0 until r) {
        arr[row] = readLine()
    }
    for (row in 0 until r) {
        for (col in 0 until c) {
            if(arr[row][col] == '1'){
                for(i in 0..1){
                    val nr = row + dr[i]
                    val nc = col + dc[i]
                    if(nr < 0 || r <= nr || nc < 0 || c <= nc){
                        dp[row][col][i] = 1
                        continue
                    }
                    dp[row][col][i] = dp[nr][nc][i] + 1
                }
            }
        }
    }
    var answer = 0
    for (row in 0 until r) {
        for (col in 0 until c) {
            val min = Math.min(dp[row][col][0], dp[row][col][1])
            if(answer < min){
                for(k in answer+1..min){
                    var isExist = true
                    for(i in 0..1){
                        val nr = row + dr[i]*(k-1)
                        val nc = col + dc[i]*(k-1)
                        if(dp[nr][nc][(i+1)%2] < k) isExist = false
                    }
                    if(isExist) answer = k
                }
            }
        }
    }
    print(answer)

}