const fs = require('fs');
let input = fs.readFileSync('./dev/stdin').toString().split('\n');

const O = input[0].trim();
const N = input[1].trim();
const INF = 100000
let dp = new Array(O.length + 1)
for(let i = 0;i < O.length + 1; i++){
    dp[i] = new Array(N.length + 1)
    for(let j = 0; j < N.length + 1; j++){
        dp[i][j] = new Array(2);
    }
}

const solution = () => {
    if(O.length > N.length){
        console.log(-1)
        return;
    }
    for(let i = 1; i <= N.length; i++){
        dp[0][i][0] = INF;
        dp[0][i][1] = 1;
    }
    dp[0][0][0] = 0;
    dp[0][0][1] = INF;
    for(let i = 0; i < O.length;i++){
        for(let j = 0; j <= i; j++){
            dp[i+1][j][0] = dp[i+1][j][1] = INF;
        }
        for(let j = i; j < N.length; j++){
            if(O[i] == N[j]){
                dp[i+1][j+1][0] = Math.min(dp[i][j][0], dp[i][j][1])
            }
            else{
                dp[i+1][j+1][0] = INF;
            }
            dp[i+1][j+1][1] = Math.min(dp[i+1][j][0] + 1, dp[i+1][j][1])
        }
    }
    let result = Math.min(dp[O.length][N.length][0], dp[O.length][N.length][1]);
    if(result == INF)
        console.log(-1)
    else
        console.log(result)
}

solution();