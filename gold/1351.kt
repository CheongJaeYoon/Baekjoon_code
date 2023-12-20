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

    val map = mutableMapOf<Long, Long>()
    map[0] = 1;

    fun f(num: Long): Long{
        if(map[num] != null){
            return map[num]!!;
        }
        else{
            var res = f(num/p) + f(num/q)
            map[num] = res;
            return res;
        }
    }

    print(f(n));
}
