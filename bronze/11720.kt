import java.io.*
fun main() = with (BufferedReader(InputStreamReader(System.`in`))) {
    readLine()
    print(readLine().map{it-'0'}.sum())
}