import java.io.*

//val path = File("").absolutePath.toString() + "\\src\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val str = br.readLine();
    val code = br.readLine();
    val map = mutableMapOf<Char, Int>();
    for(idx in str.indices){
        if(map[str[idx]] == null){
            map[str[idx]] = idx+1;
        }
    }
    var result = 0L;
    for(idx in code.indices){
        result *= str.length;
        result += map[code[idx]]!!;
        result %= 900528;
    }

    print(result);
}