import java.io.*
import java.util.*


//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//fun main(args: Array<String>) = with(BufferedReader(File(path).bufferedReader())) {
fun main(args: Array<String>) = with (BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val treeArr = Array(n) {
        var split = readLine().split(" ").map{ it.toInt() }
        Tree(split[0], split[1], split[2])
    }
    val xSort = treeArr.map{it.x}.sorted()
    val ySort = treeArr.map{it.y}.sorted()
    var answer = Int.MAX_VALUE
    var innerTrees = ArrayList<Tree>()
    for(a in xSort.indices){
        for(b in a until xSort.size){
            for(c in ySort.indices){
                for(d in c until ySort.size){
                    var outerCnt = 0
                    var treeCnt = 0
                    val fence = (xSort[b] - xSort[a] + ySort[d] - ySort[c])*2
                    for(tree in treeArr){
                        if(tree.x >= xSort[a] && tree.x <= xSort[b] && tree.y >= ySort[c] && tree.y <= ySort[d]){
                            innerTrees.add(tree)
                        }
                        else{
                            outerCnt += tree.cnt
                            treeCnt++
                        }
                    }
                    if(fence <= outerCnt){
                        answer = Math.min(answer, treeCnt)
                    }
                    else{
                        innerTrees.sortByDescending { it.cnt }
                        for(innerTree in innerTrees){
                            outerCnt += innerTree.cnt
                            treeCnt++
                            if(fence <= outerCnt){
                                answer = Math.min(answer, treeCnt)
                                break
                            }
                        }
                    }
                    innerTrees.clear()
                }
            }
        }
    }
    print(answer)

}
class Tree(val x:Int, val y:Int, val cnt:Int)