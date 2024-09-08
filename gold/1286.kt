import java.io.File
import java.io.StreamTokenizer
import java.util.*

//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val st = StringTokenizer(br.readLine());
    var n = st.nextToken().toInt();
    var m = st.nextToken().toInt();
    var strArr = Array(n){br.readLine()};
    var map = mutableMapOf<Char, Long>();
    for(c in 'A'..'Z'){
        map[c] = 0L;
    }
    for(r in 0 until 2 * n){
        for(c in 0 until 2 * m){
            val alpha = strArr[if(r >= n) (r-n) else r][if(c >= m) (c-m) else c]
            map[alpha] = map[alpha]!! + 1L*(r+1)*(2*n - r)*(c+1)*(2*m - c);
        }
    }
    for(c in 'A'..'Z'){
        print("${map[c]}\n")
    }
}
