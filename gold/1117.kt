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
    val arr = Array(8){readInt()}
    br.close()

    val solution = Solution(arr)
    solution.print()
}

class Solution(var arr: Array<Int>) {
    fun solve(): Long {
        val w = arr[0];
        val h = arr[1];
        var f = arr[2];
        val c = arr[3];
        val x1 = arr[4];
        val y1 = arr[5];
        val x2 = arr[6];
        val y2 = arr[7];

        if(2*f <= w){
            if(x1 <= f && x2 <= f){
                return 1L*2*(x2 - x1)*(y2 - y1)*(c + 1)
            }
            else if(x1 <= f && x2 > f){
                return 1L*(2*(f - x1)+(x2 - f))*(y2 - y1)*(c + 1)

            }
            else if(x1 > f && x2 > f){
                return 1L*(x2 - x1)*(y2 - y1)*(c + 1)
            }
        }
        else{
            f = w-f;
            if(x1 <= f && x2 <= f){
                return 1L*2*(x2 - x1)*(y2 - y1)*(c + 1)
            }
            else if(x1 <= f && x2 > f){
                return 1L*(2*(f - x1)+(x2 - f))*(y2 - y1)*(c + 1)

            }
            else if(x1 > f && x2 > f){
                return 1L*(x2 - x1)*(y2 - y1)*(c + 1)
            }
        }
        return 1L;
    }

    fun print(){
        print(1L * arr[0] * arr[1] - solve());
    }
}