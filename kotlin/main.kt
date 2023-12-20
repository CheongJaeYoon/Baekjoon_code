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
    val n = st.nextToken().toInt();
    val arr = Array(n){Array(2){ 0 }}
    repeat(n){
        val str = br.readLine().split(" ");
        arr[it][0] = str[1].toInt();
        arr[it][1] = str[2].toInt();
    }
    arr.sortWith(Comparator { o1, o2 ->
        when {
            o1[0] - o2[0] > 0 -> 1
            o1[0] == o2[0] -> when {
                o1[1] - o2[1] > 0 -> 1
                o1[1] == o2[1] -> 0
                else -> -1
            }
            else -> -1
        }
    })
    val queue = PriorityQueue<Int>();
    for(lecture in arr){
        if(queue.isEmpty()){
            queue.add(lecture[1]);
        }
        else{
            val prevEndTime = queue.peek();
            if(prevEndTime <= lecture[0]){
                queue.poll();
                queue.add(lecture[1])
            }
            else{
                queue.add(lecture[1])
            }
        }
    }

    print(queue.size)
}