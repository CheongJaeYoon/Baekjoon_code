import java.io.File
import java.io.StreamTokenizer
import java.math.BigInteger
import java.util.*

//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val str = br.readLine()
    var newStr = ""
    if(str.length % 2 == 0){
        newStr += str.slice(0..str.length/2-1);
        newStr += newStr.reversed();
        if(BigInteger(newStr) > BigInteger((str))){
            print(newStr)
        }
        else{
            var newStr2 = ""
            var changeOnce = false;
            for(idx in str.length/2 until str.length){
                if(changeOnce == true){
                    newStr2 += newStr[idx]
                    continue;
                }
                if(newStr[idx] < '9'){
                    newStr2 += (newStr[idx]+1)
                    changeOnce = true;
                }
                else{
                    newStr2 += '0'
                }
            }
            if(changeOnce == false){
                print('1')
                repeat(str.length-1){
                    print('0')
                }
                print('1')
            }
            else{
                newStr2 = newStr2.reversed() + newStr2
                print(newStr2)
            }
        }
    }
    else{
        val tmp = str.slice(0..str.length/2-1);
        newStr += tmp;
        newStr += str[str.length/2]
        newStr += tmp.reversed();
        if(BigInteger(newStr) > BigInteger((str))){
            print(newStr)
        }
        else{
            var newStr2 = ""
            var changeOnce = false;
            for(idx in str.length/2 until str.length){
                if(changeOnce == true){
                    newStr2 += newStr[idx]
                    continue;
                }
                if(newStr[idx] < '9'){
                    newStr2 += (newStr[idx]+1)
                    changeOnce = true;
                }
                else{
                    newStr2 += '0'
                }
            }
            if(changeOnce == false){
                print('1')
                repeat(str.length-1){
                    print('0')
                }
                print('1')
            }
            else{
                newStr2 = newStr2.reversed() + newStr2.slice(1.. newStr2.length-1)
                print(newStr2)
            }
        }
    }
}
