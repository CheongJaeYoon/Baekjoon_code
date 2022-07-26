const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const num = input[0].replace(/\r/, "").split(" ").map(el => +el);
const N = num[0];
const M = num[1];
const K = num[2];
const INF = -1;

let data = new Array(N + 1);
for(let i= 0; i <= N; i++){
    data[i] = [];
}
for(let i = 1; i <= M; i++){
    let temp = input[i].replace(/\r/, "").split(" ").map(el => +el)
    data[temp[0]].push([temp[1], temp[2]]);
    data[temp[1]].push([temp[0], temp[2]]);
}

let dp = new Array(N + 1);
for(let i = 0; i < N+1; i++){
    dp[i] = new Array(K + 1).fill(INF)
}


const solution = () => {
    func(1, N);
}

const func = (start_node, end_node) => {

    dp[start_node][0] = 0;

    let queue = [];
    queue.push([0, 1, 0]) // [dist, node, K]

    while(queue.length != 0){
        
        let tmp = queue.shift();
        let cur_dist = tmp[0]
        let cur_node = tmp[1]
        let cur_k = tmp[2]

        if(cur_dist > dp[cur_node][cur_k])
            continue;

        dp[cur_node][cur_k] = cur_dist;
        for(let i = 0; i < data[cur_node].length; i++){
            let next_node = data[cur_node][i][0]
            let next_dist = cur_dist + data[cur_node][i][1]

            if(cur_k < K){
                if(dp[next_node][cur_k + 1] > cur_dist || dp[next_node][cur_k + 1] == INF){
                    dp[next_node][cur_k + 1] = cur_dist;
                    queue.push([cur_dist, next_node, cur_k + 1])
                }
            }

            if(dp[next_node][cur_k] > next_dist || dp[next_node][cur_k] == INF){
                dp[next_node][cur_k] = next_dist;
                queue.push([next_dist, next_node, cur_k])
            }
        }
    }
    let result = dp[end_node][0];
    for(let i = 0; i <= K; i++){
        if(dp[end_node][i] < result && dp[end_node][i] != INF){
            result = dp[end_node][i]
        }
    }
    console.log(result)
}

solution();