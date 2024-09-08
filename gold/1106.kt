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
    val c = readInt();
    val n = readInt();
    val cities = Array(n){Array(2){readInt()} }
    br.close()

    val solution = Solution(c, n, cities)
    solution.init();
    solution.solve();
}

class Solution(var c: Int, var n: Int, var cities: Array<Array<Int>>) {

    val dp = Array(1000*100+1){0};

    fun init(){
        for(cIdx in 0 until n) {
            for(cost in 0..1000*100){
                if(cost - cities[cIdx][0] >= 0){
                    dp[cost] = Math.max(dp[cost], dp[cost - cities[cIdx][0]] + cities[cIdx][1])
                }
            }
        }
    }
    fun solve(){
        for(cost in 1..1000*100){
            if(dp[cost] >= c){
                print(cost);
                break;
            }
        }
    }
}