import java.io.*
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()
fun main(){
    val t = br.readLine()
    val p = br.readLine()
    br.close()

    val solution = Solution(t, p)
    solution.solve(input2)

    bw.append(solution.print())
    bw.flush()
    bw.close()
}

class Solution(val t: String, val p: String){
    private val m = p.length
    private val kArr = Array<Int>(m){0}
    private var cnt = 0
    private var firstIdxArr = ArrayList<Int>()

    fun solve(){
        preProcess()
        var k = 0
        for(idx in t.indices){
            //println(t[idx])
            while(k > 0 && t[idx] != p[k]){
                k = kArr[k-1]
            }
            if(t[idx] == p[k]){
                if(k == m-1){
                    cnt++
                    firstIdxArr.add(idx - k + 1)
                    k = kArr[k]
                }
                else{
                    k++
                }
            }
        }
    }

    private fun preProcess(){
        var k = 0
        for(j in 1 until m){
            while(k > 0 && p[j] != p[k]){
                k = kArr[k-1]
            }
            if(p[j] == p[k]){
                kArr[j] = ++k
            }
        }
    }

    fun print(): String {
        return "$cnt\n${firstIdxArr.joinToString(" ")}"
    }
}
