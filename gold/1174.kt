import java.io.*

//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val solution = Solution()
    solution.solve(br.readLine().toInt())
    br.close()

}

class Solution() {
    val arr = Array(1000001){-1L}
    fun solve(n:Int) {
        if(n >= 1024){
            print(-1);
            return;
        }
        var cnt = 1;
        var isDone = false;
        fun recursive(digit: Int, prev: Int, value: Long) {
            if(isDone) return;
            if (digit == 1) {
                for (i in 0..9) {
                    if (prev != 0 && i >= prev) continue;
                    arr[cnt] = value * 10 + i;
                    if(cnt == n){
                        print(arr[n]);
                        isDone = true;
                    }
                    cnt++;
                }
            } else {
                if (prev == 0) {
                    recursive(digit - 1, 0, value * 10);
                }
                for (i in (digit - 1)..9) {
                    if (prev != 0 && i >= prev) continue;
                    recursive(digit - 1, i, value * 10 + i);
                }
            }
        }
        recursive(10, 0, 0);
    }
}