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
    val tree = Array<Int>(n){readInt()};
    val delNode = readInt();
    br.close()

    val solution = Solution(n, tree, delNode)
    solution.init()
    solution.solve()
    solution.print()

}

class Solution(var n: Int, var tree: Array<Int>, var delNode: Int) {
    val isLeaf = Array<Boolean>(n) {true};
    val sb = StringBuilder("")

    fun init(){
        for(i in 0 until n){
            if(tree[i] == -1){
                continue;
            }
            isLeaf[tree[i]] = false;
        }
    }

    fun solve(){
        fun recursive(parent:Int){
            if(isLeaf[parent]){
                isLeaf[parent] = false;
            }
            else{
                for(child in 0 until n){
                    if(tree[child] == parent){
                        recursive(child);
                    }
                }
            }
        }

        if(tree[delNode] == -1){ // 노드를 지우는 경우
            sb.append(0);
        }
        else{
            isLeaf[tree[delNode]] = true;
            for(child in 0 until n){
                if(child == delNode) continue;
                if(tree[child] == tree[delNode]){
                    isLeaf[tree[delNode]] = false;
                }
            }
            recursive(delNode);
            var sum = isLeaf.count{it};
            if(sum == 0){

            }
            sb.append(sum);
        }
    }

    fun print(){
        print(sb.toString())
    }
}