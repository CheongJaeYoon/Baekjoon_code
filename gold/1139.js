const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const N = +input[0];
let data = input[1].replace(/\r/, "").split(" ").map(el => +el);

let edge = new Array(Math.floor(N/3)).fill(0);
let result = 0;
let visited = new Array(N).fill(0)
let dp = new Array(1<<N).fill(-1);
let cap = new Array(Math.floor(N/3)).fill(0)

const solution = () => {
    func(0, 0, 0, 0);
    console.log(result)
}

const func = (cnt, i, g_cnt, sum) => { //tcnt : 선택한 숫자의 개수, i : 지금 선택한 숫자, g_cnt : 총 그룹의 개수


    if(cnt == 3){
        let tmp = getArea(g_cnt, edge[g_cnt])
        if(tmp === false)
            return;
        g_cnt++

        if((g_cnt+1)*3 > N){
            //console.log(edge.map(el => ("0000000000000000"+el.toString(2)).slice(-16)).join(" "), sum+tmp)
            result = (sum + tmp) > result ? (sum + tmp) : result;
        }
        else{
            func(0, cap[g_cnt-1], g_cnt, sum + tmp)
        }
        return;
    }
    for(let j = i; j < N; j++){
        if(visited[j] == 0){
            visited[j] = 1; 
            edge[g_cnt] += (1<<j);
            if(cnt == 0)
                cap[g_cnt] = j
            func(cnt+1, j, g_cnt, sum)
            visited[j] = 0;
            edge[g_cnt] -= (1<<j)
        }
    }
}
 
const getArea = (g_cnt, bit) => {
    if(dp[bit] != -1)
        return dp[bit]
    let p = 0;
    let num = [];
    let cnt = 0;
    for(let i =0; i < N; i++){
        if(edge[g_cnt] & (1 << i)){
            let tmp = data[i];
            num[cnt] = tmp;
            p += tmp;
            cnt++;
        }
    }
    p = p/2
    let ret = p;
    for(let i =0 ; i < 3; i++){
        ret *= (p - num[i])
    }
    if(ret > 0)
        dp[bit] = Math.sqrt(ret);
    else
        dp[bit] = 0;
    return dp[bit]
}

solution();