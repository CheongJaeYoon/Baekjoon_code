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
    val n = readInt();
    val craneLimits = Array<Int>(n){readInt()};
    val m = readInt();
    val boxes= Array<Int>(m){readInt()};
    br.close()

    val solution = Solution(n, craneLimits, m, boxes)
    solution.init()
    solution.solve()

}

class Solution(var n: Int, var craneLimits: Array<Int>, var m: Int, var boxes: Array<Int>) {
    var isDone = Array<Boolean>(m){false};
    fun init(){
        boxes = boxes.sortedArrayDescending();
        craneLimits = craneLimits.sortedArrayDescending();
    }
    fun solve(){
        if(boxes[0] > craneLimits[0]){
            print(-1);
            return;
        }
        var time = 0;
        while(true){
            var isWork = false;
            var curCrane = 0;
            for(boxIdx in 0 until m){
                if(isDone[boxIdx]) continue;
                if(boxes[boxIdx] <= craneLimits[curCrane]){
                    isDone[boxIdx] = true;
                    curCrane++;
                    isWork = true;
                    if(curCrane == n) break;
                }
            }
            if(isWork == false){
                break;
            }
            else{
                time++;
            }
        }
        print(time);
    }
}