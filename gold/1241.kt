import java.io.*
import kotlin.math.floor
import kotlin.math.sqrt

//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val st = StreamTokenizer(br);
    val readInt = {
        st.nextToken()
        st.nval.toInt()
    }
    var n = readInt();
    var arr = Array(n){ readInt() };
    br.close()
    var max = arr.max();
    var cntArr = Array(max!!+1){ 0 }
    for(i in arr){
        cntArr[i]++;
    }
    val sb = StringBuilder("");
    for(player in 0 until n){
        var cnt = 0;
        var i = 1;
        while(true){
            if(i*i > arr[player]) break;
            if(arr[player]%i == 0){
                cnt += cntArr[i];
                if(i != arr[player]/i){
                    cnt += cntArr[arr[player]/i];
                }
            }
            i++;
        }
        cnt--;
        sb.append("$cnt\n");
    }
    print(sb.toString());
}
