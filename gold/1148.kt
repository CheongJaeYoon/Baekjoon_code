import java.io.*

//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val dictionary = MutableList<String>(0) { "" };
    while(true){
        val str = br.readLine();
        if(str == "-"){
            break;
        }
        dictionary.add(str);
    }
    val solution = Solution(dictionary)
    while(true){
        val str = br.readLine();
        if(str == "#"){
            break;
        }
        solution.init(str);
        solution.solve()
    }
    br.close()

}

class Solution(var dictionary: MutableList<String>) {
    var words = mutableListOf<String>();
    var puzzle = ""
    fun init(puzzle: String){
        words.clear();
        this.puzzle = puzzle;
        for(word in dictionary){
            if(canMake(word)){
                words.add(word);
            }
        }
    }

    fun canMake(word:String):Boolean{
        val isCheck = Array(word.length){false};
        for(alpha1 in puzzle){
            for(idx in word.indices){
                if(isCheck[idx]) continue;
                if(word[idx] == alpha1){
                    isCheck[idx] = true;
                    break;
                }
            }
        }
        if(isCheck.count{ !it } == 0) return true;
        else return false;
    }
    fun solve() {
        val map = mutableMapOf<Char, Int>();
        for(alpha in puzzle){
            map[alpha] = 0;
        }
        for(word in words){
            for(alpha in map.keys){
                if(word.contains(alpha)){
                    map[alpha] = map[alpha]!! + 1;
                }
            }
        }
        var min = Int.MAX_VALUE;
        var max = Int.MIN_VALUE;
        for(alpha in map.keys){
            min = Math.min(min, map[alpha]!!)
            max = Math.max(max, map[alpha]!!)
        }
        val minList = mutableListOf<Char>();
        val maxList = mutableListOf<Char>();
        for(alpha in map.keys){
            if(map[alpha]!! == min){
                minList.add(alpha)
            }
            if(map[alpha]!! == max){
                maxList.add(alpha)
            }
        }
        minList.sort();
        maxList.sort();
        print("${minList.joinToString("")} $min ${maxList.joinToString("")} $max\n")

    }
}