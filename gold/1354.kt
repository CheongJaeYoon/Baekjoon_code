import java.io.File
import java.io.StreamTokenizer
import java.math.BigInteger
import java.util.*
import kotlin.math.floor

//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val st = StringTokenizer(br.readLine());
    val n = st.nextToken().toLong();
    val p = st.nextToken().toLong();
    val q = st.nextToken().toLong();
    val x = st.nextToken().toLong();
    val y = st.nextToken().toLong();

    val arr = Array(3500000){ -1L }

    fun f(num: Long): Long{
        if(num <= 0) return 1L;
        if(num >= 3500000){
            return f(num/p - x) + f(num/q - y);
        }
        if(arr[num.toInt()] != -1L){
            return arr[num.toInt()];
        }
        else{
            var res = f(num/p - x) + f(num/q - y)
            arr[num.toInt()] = res;
            return res;
        }
    }

    print(f(n));
}
