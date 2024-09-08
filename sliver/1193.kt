//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val n = br.readLine().toInt()
    br.close()

    val solution = Solution(n)
    solution.solve()
    solution.print()

}

class Solution(var n:Int) {
    val sb = StringBuilder("")

    fun solve(){
        var line = 1;
        var sum = line;
        while(true){
            if(n <=sum) break;
            line++;
            sum += line;
        }
        sum -= line;
        var idx = n - sum - 1;
        var row = 0;
        var col = 0;
        if(line%2 == 0){
            row = 1+idx;
            col = line-idx;
        }
        else{
            row = line-idx;
            col = 1+idx;
        }
        sb.append("$row/$col")
    }

    fun print(){
        print(sb.toString())
    }
}
