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
    val n = readInt();
    val arr = Array<Int>(n){readInt()};
    val s = readInt();
    br.close()

    val solution = Solution(n, arr, s)
    solution.solve()
    solution.print()

}

class Solution(var n: Int, var arr: Array<Int>, var s: Int) {
    val sb = StringBuilder("")

    fun solve(){
        for(idx in 0 until n){
            if(s == 0) break;
            algo(idx);
        }
    }

    fun algo(startIdx: Int){
        val endIdx = if(s >= (n-startIdx)){
            n-1;
        } else {
            startIdx + s;
        }
        var biggest = arrayOf(-1, -1);
        for(idx in startIdx..endIdx){
            if(arr[idx] > biggest[0]){
                biggest[0] = arr[idx];
                biggest[1] = idx;
            }
        }
        for(idx in biggest[1]-1 downTo startIdx ){
            arr[idx+1] = arr[idx]
            s--;
        }
        arr[startIdx] = biggest[0];
    }

    fun print(){
        print(arr.joinToString(" ") + "\n")
    }
}