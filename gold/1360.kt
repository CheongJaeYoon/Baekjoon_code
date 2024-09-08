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
    var typeList = mutableListOf<Type>()
    var undoList = mutableListOf<Undo>()
    repeat(n){
        val strArr = br.readLine().split(" ");
        if(strArr[0] == "type"){
            typeList.add(Type(strArr[1], strArr[2].toLong(), true))
        }
        else{
            undoList.add(Undo(strArr[2].toLong() - strArr[1].toLong(), strArr[2].toLong(), true))
        }
    }

    fun doUndo(undo: Undo){
        for(type in typeList){
            if(type.time >= undo.end) break;
            if(undo.start <= type.time && type.time < undo.end){
                type.use = !type.use;
            }
        }
        for(innerUndo in undoList){
            if(innerUndo.end >= undo.end) break;
            if(undo.start <= innerUndo.end && innerUndo.end < undo.end){
                innerUndo.use = !innerUndo.use;
            }
        }
    }

    for(idx in undoList.size-1 downTo 0){
        if(undoList[idx].use == true){
            doUndo(undoList[idx])
        }
        undoList[idx].use = false;
    }
    val sb = StringBuilder("");

    for(type in typeList){
        if(type.use){
            sb.append(type.str);
        }
    }
    print(sb.toString());

}


class Type(var str: String, var time: Long, var use: Boolean)
class Undo(var start: Long, var end: Long, var use: Boolean)
