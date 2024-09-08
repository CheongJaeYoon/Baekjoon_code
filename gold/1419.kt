import java.io.*

//val path = File("").absolutePath.toString() + "\\src\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val l = br.readLine().toLong();
    val r = br.readLine().toLong();
    val k = br.readLine().toLong();
    var cnt = 0L;
    when(k){
        2L ->{ // 3이상의 자연수
            cnt = maxOf(r - maxOf(l, 3) + 1, 0);
        }
        3L ->{ // 6이상의 3의 배수
            for(i in maxOf(l, 6)..r){
                if(i % 3 == 0L) cnt++;
            }
        }
        4L ->{ //10이상의 2의 배수(12제외)
            for(i in maxOf(l, 10)..r){
                if(i % 2 == 0L && i != 12L) cnt++;
            }
        }
        5L ->{ // 15이상의 5의 배수
            for(i in maxOf(l, 15)..r){
                if(i % 5 == 0L) cnt++;
            }
        }
    }
    print(cnt);
}