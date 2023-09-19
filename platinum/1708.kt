import java.io.*
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main() = with(BufferedReader(File(path).bufferedReader())) {
fun main() = with (BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var st: StringTokenizer
    val pointArray = Array<Point>(n) {
        st = StringTokenizer(readLine())
        Point(st.nextToken().toInt(), st.nextToken().toInt())
    }
    print(solution(n, pointArray))
}

fun solution(n: Int, pointArray: Array<Point>): Int {
    val sortArr = pointArray.sortedWith(Comparator{o1, o2 -> when{
        o1.y - o2.y > 0 -> 1
        o1.y == o2.y -> when{
            o1.x - o2.x > 0 -> 1
            o1.x == o2.x -> 0
            else -> -1
        }
        else -> -1
    }})
    val startPoint = sortArr[0]
    val sortedArrByCCW = sortArr.slice(1 until sortArr.size).sortedWith(Comparator { o1, o2 ->
        var ccw = ccw(startPoint, o1, o2)
        when (ccw) {
            0 -> {
                var diff = dist(o1, startPoint) - dist(o2, startPoint)
                when{
                    diff < 0L -> -1
                    diff == 0L -> 0
                    else -> 1
                }
            }
            else -> {
                if (ccw > 0L) -1
                else 1
            }
        }
    })
    val stack = Stack<Point>()
    stack.push(startPoint)
    stack.push(sortedArrByCCW[0])
    var idx = 1
    while(idx <= sortedArrByCCW.lastIndex){
        while(stack.size >= 2){
            val second = stack.peek()
            stack.pop()
            val first = stack.peek()
            if(ccw(first, second, sortedArrByCCW[idx]) > 0L){
                stack.push(second)
                break
            }

        }
        stack.push(sortedArrByCCW[idx++])
    }

    return stack.size
}

fun ccw(p1: Point, p2: Point, p3: Point): Int{ // 직선p1p2기준으로 직선p1p3가 반시계면 양수
    val ccw = 1L * (p2.x - p1.x) * (p3.y - p1.y) - 1L * (p3.x - p1.x) * (p2.y - p1.y)
    return when {
        ccw < 0 -> -1
        ccw == 0L -> 0
        else -> 1
    }
}

fun dist(p1: Point, p2: Point): Long{
    return 1L * (p1.x - p2.x) * (p1.x - p2.x) + 1L * (p1.y - p2.y) * (p1.y - p2.y)
}

class Point(val x: Int, val y: Int)