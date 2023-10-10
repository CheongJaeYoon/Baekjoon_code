//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val n = br.readLine().toInt()
    val arr = Array<Long>(n){br.readLine().toLong()}
    br.close()

    val solution = Solution(arr, n)
    solution.solve()
    solution.print()

}

class Solution(val arr: Array<Long>, val n: Int) {
    val sb = StringBuilder("")

    fun solve(){
    }

    fun print(){
        print(sb.toString())
    }
}
