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
    val num = st.nextToken().toInt();
    if(num < 6){
        val arr = intArrayOf(0, 1, 2, 3, 4, 5)
        print(arr[num]);
        return;
    }
    val n = num/6;
    var cur = n * 6;
    var value = 1L + 3L*n*(n+1)
    while(true){
        if(cur == num){
            print(value);
            return;
        }
        cur++;
        if(cur%6 == 1){
            value += n
        }
        else{
            value += (n+1)
        }
    }
}