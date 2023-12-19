import java.io.File
import java.io.StreamTokenizer
import java.util.*

//val path = File("").absolutePath.toString() + "\\kotlin\\testcase"
//private val br = File(path).bufferedReader()
private val br = System.`in`.bufferedReader()
fun main(){
    val dr = arrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
    val dc = arrayOf(0, 1, 1, 1, 0, -1, -1, -1)
    val st = StreamTokenizer(br);
    val readInt = {
        st.nextToken()
        st.nval.toInt()
    }
    var n = readInt();
    var m = readInt();

    var farm = Array(n){Array(m) { readInt() } }
    var visited = Array(n){Array(m) { false } }
    var innerVisited = Array(n){Array(m) { false } }
    var isPeak = Array(n){Array(m) { false } }

    fun dfs(row: Int, col: Int): Boolean{
        if(innerVisited[row][col]) return false;
        innerVisited[row][col] = true;
        var result = true;

        for(i in 0..7){
            var nr = row + dr[i];
            var nc = col + dc[i];
            if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
            if(innerVisited[nr][nc]) continue;
            if(result && farm[row][col] == farm[nr][nc]){
                result = dfs(nr, nc)
            }
            if(farm[row][col] < farm[nr][nc]){
                result = false;
            }
        }
        return result;
    }

    fun setPeak(row: Int, col: Int, peak: Boolean) {
        if(innerVisited[row][col]) return;
        innerVisited[row][col] = true;
        visited[row][col] = true;
        isPeak[row][col] = peak;

        for(i in 0..7){
            var nr = row + dr[i];
            var nc = col + dc[i];
            if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
            if(innerVisited[nr][nc]) continue;
            if(farm[row][col] == farm[nr][nc]){
                setPeak(nr, nc, peak)
            }
        }
    }

    fun innerVisitedClear(){
        for(r in 0 until n){
            innerVisited[r].fill(false);
        }
    }

    var cnt = 0;

    for(r in 0 until n){
        for(c in 0 until m){
            if(visited[r][c]) continue;
            innerVisitedClear();
            if(dfs(r, c)){
                cnt++;
                innerVisitedClear();
                setPeak(r, c, true);
            }
            else{
                innerVisitedClear();
                setPeak(r, c, false);
            }
        }
    }
    print("$cnt");

}
