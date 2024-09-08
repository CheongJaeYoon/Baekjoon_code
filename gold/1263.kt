import java.io.File
import java.io.StreamTokenizer
import java.util.*

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
    var arr = Array(n){Pair(readInt(),  readInt())};
    arr.sortByDescending{ it.second }
    var lastTime = arr[0].second;

    var canDo = true;
    for(time in arr){
        if(lastTime < 0){
            canDo = false
            break;
        }
        if(lastTime >= time.second){
            lastTime = time.second - time.first;
        }
        else{
            lastTime -= time.first;
        }

    }
    if(lastTime >= 0 && canDo){
        print("$lastTime")
    }
    else{
        print("-1")
    }

}
