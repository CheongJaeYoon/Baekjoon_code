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
    val n = readInt()
    val w = readInt()
    val event = Array(w + 1 ){ if(it != 0)intArrayOf(readInt(), readInt()) else intArrayOf(0, 0) }
    br.close()

    val solution = Solution(event, n, w)
    solution.solve()
    solution.print()

}

class Solution(val event: Array<IntArray>, val n: Int, val w: Int) {
    val dp = Array(w){ Array(w) { -1 } }
    val sb = StringBuilder("")

    fun solve(){
        totalDist(0, 0)
        sb.append("${dp[0][0]}\n")
        route(0, 0)
    }

    fun totalDist(police1: Int, police2: Int): Int{
        if(police1 == w || police2 == w) return 0
        if(dp[police1][police2] != -1) return dp[police1][police2]

        val nextEvent = Math.max(police1, police2) + 1
        var result1 = if(police1 == 0){getDist(1, 1, event[nextEvent][0], event[nextEvent][1])}
        else{getDist(event[police1][0], event[police1][1], event[nextEvent][0], event[nextEvent][1])}
        result1 += totalDist(nextEvent, police2)
        var result2 = if(police2 == 0){getDist(n, n, event[nextEvent][0], event[nextEvent][1])}
        else{getDist(event[police2][0], event[police2][1], event[nextEvent][0], event[nextEvent][1])}
        result2 += totalDist(police1, nextEvent)

        dp[police1][police2] = Math.min(result1, result2)
        return dp[police1][police2]
    }

    fun route(police1: Int, police2: Int){
        if(police1 == w || police2 == w) return

        val nextEvent = Math.max(police1, police2) + 1

        var result1 = if(police1 == 0){getDist(1, 1, event[nextEvent][0], event[nextEvent][1])}
        else{getDist(event[police1][0], event[police1][1], event[nextEvent][0], event[nextEvent][1])}
        result1 += if(nextEvent == w) 0 else dp[nextEvent][police2]
        var result2 = if(police2 == 0){getDist(n, n, event[nextEvent][0], event[nextEvent][1])}
        else{getDist(event[police2][0], event[police2][1], event[nextEvent][0], event[nextEvent][1])}
        result2 += if(nextEvent == w) 0 else dp[police1][nextEvent]

        if(result1 < result2){
            sb.append("1\n")
            route(nextEvent, police2)
        }
        else{
            sb.append("2\n")
            route(police1, nextEvent)
        }
    }

    fun getDist(x1: Int, y1: Int, x2: Int, y2: Int): Int{
        return Math.abs(x1 - x2) + Math.abs(y1 - y2)
    }

    fun print(){
        print(sb.toString())
    }
}
